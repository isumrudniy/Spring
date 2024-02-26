package ru.javarush.spring.util.mapper;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import ru.javarush.spring.data.dto.TaskDto;
import ru.javarush.spring.data.entity.Task;
import ru.javarush.spring.data.entity.reference.Status;

import java.util.List;

@Component
@RequiredArgsConstructor
@Builder
@Data
public class TaskMapper {

    public Task toEntity(@NotNull TaskDto taskDto) {
        return Task.builder()
                .id(taskDto.getId())
                .header(taskDto.getHeader())
                .description(taskDto.getDescription())
                .status(taskDto.getStatus())
                .build();
    }

    public TaskDto toDto(@NotNull Task task) {
        return TaskDto.builder()
                .id(task.getId())
                .header(task.getHeader())
                .description(task.getDescription())
                .status(task.getStatus())
                .build();
    }

    public List<TaskDto> toDto(List<Task> tasks) {
        return tasks.stream().map(this::toDto).toList();
    }

}
