package com.Eragoo.UappTest.task;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TaskMapper {
    @Mapping(target = "id", ignore = true)
    Task commandToEntity(TaskCommand command);

    TaskDto entityToDto(Task task);
}
