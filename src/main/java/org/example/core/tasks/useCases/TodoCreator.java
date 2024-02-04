package org.example.core.tasks.useCases;

import org.example.core.tasks.domain.Command;
import org.example.core.tasks.domain.Task;

public class TodoCreator {
    private final TaskRepository repository;

    public TodoCreator(TaskRepository repository) {
        this.repository = repository;
    }

    public Command create(String title){
        return () -> {
            var todo = Task.todo(-1, title);
            this.repository.save(todo);
        };
    }
}
