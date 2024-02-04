package org.example.core.tasks.infraestructure.mocks;

import org.example.core.tasks.domain.Task;
import org.example.core.tasks.useCases.TaskRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MockTaskRepository implements TaskRepository {
    private final List<Task> data = new ArrayList<>();
    @Override
    public Boolean save(Task task) {
        return data.add(task);
    }

    @Override
    public Task findById(int id) {
        return data.stream().filter(x -> x.getId() == id).findFirst().get();
    }

    @Override
    public List<Task> findAll() {
        return data.stream().collect(Collectors.toList());
    }
}
