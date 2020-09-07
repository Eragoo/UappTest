package com.Eragoo.UappTest.task;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface TaskMapper {
    @Mapping(target = "id", ignore = true)
    Task commandToEntity(TaskCommand command);

    TaskDto entityToDto(Task task);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromCommand(TaskCommand command, @MappingTarget Task task);
}
