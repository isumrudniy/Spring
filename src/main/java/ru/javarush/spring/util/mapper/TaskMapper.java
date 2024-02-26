package ru.javarush.spring.util.mapper;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import ru.javarush.spring.data.dto.TaskDto;
import ru.javarush.spring.data.entity.Task;

import java.util.List;

@Component
@RequiredArgsConstructor
@Builder
@Data
public class TaskMapper {

    Task toEntity(@NotNull TaskDto taskDto) {
        return Task.builder()
                .id(taskDto.getId())
                .description(taskDto.getDescription())
                .status(taskDto.getStatus())
                .build();
    }

    TaskDto toDto(@NotNull Task task) {
        return TaskDto.builder()
                .id(task.getId())
                .description(task.getDescription())
                .status(task.getStatus())
                .build();
    }

    List<TaskDto> toDto(List<Task> tasks) {
        return tasks.stream().map(this::toDto).toList();
    }

}
