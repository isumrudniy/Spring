package ru.javarush.spring.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.javarush.spring.data.entity.Task;
import ru.javarush.spring.exception.NotFoundException;
import ru.javarush.spring.repository.TaskRepository;
import ru.javarush.spring.service.TaskService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public List<Task> findAll() {
        List<Task> content = taskRepository.findAll();
        if (content.isEmpty()) {
            throw new NotFoundException("Данные не найдены");
        }
        return content;
    }

    @Override
    public List<Task> findAllWithPagging(int page, int size) {
        List<Task> content = taskRepository.findAll(PageRequest.of(page, size)).getContent();
        if (content.isEmpty()) {
            throw new NotFoundException("Данные не найдены");
        }
        return content;
    }

    @Override
    public Task findById(String id) {
        log.info("Выполняется поиск по id: " + id);
        return taskRepository.findById(id).orElseThrow(() -> new NotFoundException("Задача с id: " + id + " не найдена"));
    }

    @Override
    public void delete(String id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new NotFoundException("Задача с id: " + id + " не найдена"));
        taskRepository.delete(task);
        log.info("Удалена задача с id: " + id);
    }

    @Override
    public Task update(String id, Task taskUpdate) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new NotFoundException("Задача с id: " + id + " не найдена"));
        log.info("Выполняется обновление задачи с id: " + id);
        return taskRepository.save(Task.builder()
                .id(task.getId())
                .header(taskUpdate.getHeader())
                .description(taskUpdate.getDescription())
                .status(taskUpdate.getStatus())
                .build());
    }

    @Override
    public Task save(Task task) {
        log.info("Выполняется сохранение новой задачи " + task.getHeader());
        return taskRepository.save(task);
    }
}
