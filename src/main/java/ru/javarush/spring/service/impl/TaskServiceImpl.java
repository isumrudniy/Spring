package ru.javarush.spring.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.javarush.spring.data.entity.Task;
import ru.javarush.spring.exception.NotFoundException;
import ru.javarush.spring.repository.TaskRepository;
import ru.javarush.spring.service.TaskService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public List<Task> findAll() {
        List<Task> content = taskRepository.findAll(PageRequest.of(1, 2)).getContent();
        if (content.isEmpty()) {
            throw new NotFoundException("Данные не найдены");
        }
        return content;
    }

    @Override
    public Task findById(String id) {
        return taskRepository.findById(id).orElseThrow(() -> new NotFoundException("Задача с id: " + id + " не найдена"));
    }

    @Override
    public void delete(String id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new NotFoundException("Задача с id: " + id + " не найдена"));
        taskRepository.delete(task);
    }

    @Override
    public Task update(String id, Task taskUpdate) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new NotFoundException("Задача с id: " + id + " не найдена"));
        return taskRepository.save(Task.builder()
                .id(task.getId())
                .header(taskUpdate.getHeader())
                .description(taskUpdate.getDescription())
                .status(taskUpdate.getStatus())
                .build());
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }
}
