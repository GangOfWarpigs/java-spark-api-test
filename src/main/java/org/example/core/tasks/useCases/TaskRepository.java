package org.example.core.tasks.useCases;

import org.example.core.tasks.domain.Task;

import java.util.List;

public interface TaskRepository {
    Boolean save(Task task);
    Task findById(int id);
    List<Task> findAll();
}
