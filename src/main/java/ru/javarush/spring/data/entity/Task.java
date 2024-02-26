package ru.javarush.spring.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.javarush.spring.data.entity.reference.Status;


@Entity
@Table(name = "task")
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String header;
    private String description;
    private Status status;
}
