package org.example.core.tasks.useCases;

import org.example.core.tasks.domain.Task;

import java.util.List;

public class TodoFinder {
    private final TaskRepository repository;

    public TodoFinder(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> find(){
        return this.repository.findAll();
    }
}
