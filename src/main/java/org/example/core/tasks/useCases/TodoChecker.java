package org.example.core.tasks.useCases;

import org.example.core.tasks.domain.Command;

public class TodoChecker {
    private final TaskRepository taskRepository;

    public TodoChecker(TaskRepository repository) {
        this.taskRepository = repository;
    }

    public Command check(int id){
        return () -> {
            var todo = this.taskRepository.findById(id);
            System.out.println(todo);
            var completedTask = todo.check();
            taskRepository.save(completedTask);
        };
    }
}
