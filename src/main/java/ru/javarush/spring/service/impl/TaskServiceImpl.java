package ru.javarush.spring.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.javarush.spring.data.entity.Task;
import ru.javarush.spring.service.TaskService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    @Override
    public List<Task> findAll() {
        return null;
    }

    @Override
    public Task delete(String id) {
        return null;
    }

    @Override
    public Task update(Task task) {
        return null;
    }

    @Override
    public Task save(Task task) {
        return null;
    }
}
