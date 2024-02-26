package ru.javarush.spring.util.mapper;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import ru.javarush.spring.data.dto.TaskCreationDto;
import ru.javarush.spring.data.dto.TaskDto;
import ru.javarush.spring.data.entity.Task;

@Component
@RequiredArgsConstructor
@Builder
@Data
public class TaskCreationMapper {

    public Task toEntity(@NotNull TaskCreationDto taskCreationDto) {
        return Task.builder()
                .header(taskCreationDto.getHeader())
                .description(taskCreationDto.getDescription())
                .status(taskCreationDto.getStatus())
                .build();
    }

}
