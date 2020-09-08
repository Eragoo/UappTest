package com.Eragoo.UappTest.task;

import com.Eragoo.UappTest.column.ColumnMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(uses = ColumnMapper.class)
public interface TaskMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "column", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    Task commandToEntity(TaskCommand command);

    TaskDto entityToDto(Task task);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "column", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    void updateEntityFromCommand(TaskCommand command, @MappingTarget Task task);
}
