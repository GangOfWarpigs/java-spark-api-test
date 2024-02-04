package org.example.core.tasks.infraestructure.hibernate;

import org.example.core.tasks.domain.Task;
import org.example.core.tasks.shared.hibernate.TransactionExecutor;
import org.example.core.tasks.useCases.TaskRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.stream.Collectors;

public class HibernateTaskRepository implements TaskRepository {

    private final TransactionExecutor transactionExecutor = new TransactionExecutor();

    @Override
    public Boolean save(Task task) {
        transactionExecutor.execute((session) -> session.save(TaskDB.from(task)));
        return true;
    }

    @Override
    public Task findById(int id) {
        return transactionExecutor.execute((session) -> {
            var todo = session.find(TaskDB.class, id);
            if(todo.isChecked()) return Task.done(id, todo.getText());
            return Task.todo(id, todo.getText());
        });
    }

    @Override
    public List<Task> findAll() {
        return transactionExecutor.execute((session) -> {
            Query<TaskDB> query = queryAllTasks(session);
            return getTaskListFromQuery(query);
        });
    }

    private static Query<TaskDB> queryAllTasks(Session session) {
        return session.createQuery("FROM TaskDB ", TaskDB.class);
    }

    private static List<Task> getTaskListFromQuery(Query<TaskDB> query) {
        return query.list().stream()
                .map(x -> x.isChecked() ? Task.done(x.getId(), x.getText()) : Task.todo(x.getId(), x.getText()))
                .collect(Collectors.toList());
    }
}
