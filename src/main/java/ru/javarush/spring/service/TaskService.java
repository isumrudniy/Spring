package ru.javarush.spring.service;

import org.springframework.stereotype.Service;
import ru.javarush.spring.data.entity.Task;

import java.util.List;


public interface TaskService {

    List<Task> findAll();

    Task findById(String id);

    Task delete(String id);

    Task update(Task task);

    Task save(Task task);

}
