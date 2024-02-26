package ru.javarush.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.javarush.spring.data.entity.Task;

public interface TaskRepository extends JpaRepository<Task, String> {
}
