package ru.javarush.spring.data.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.javarush.spring.data.entity.reference.Status;

@RequiredArgsConstructor
@Data
@Builder
public class TaskDto {
    private String id;
    private String description;
    private Status status;
}