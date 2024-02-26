package ru.javarush.spring.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.javarush.spring.data.entity.Task;
import ru.javarush.spring.exception.NotFoundException;
import ru.javarush.spring.repository.TaskRepository;
import ru.javarush.spring.service.TaskService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findById(String id) {
        return taskRepository.findById(id).orElseThrow(() -> new NotFoundException("Задача с id: " + id + " не найдена"));
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
