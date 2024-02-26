package ru.javarush.spring.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.javarush.spring.data.entity.reference.Status;

@RequiredArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class TaskCreationDto {
    private String header;
    private String description;
    private Status status;
}

