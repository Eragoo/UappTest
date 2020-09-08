package com.Eragoo.UappTest.column;

import com.Eragoo.UappTest.task.TaskMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(uses = TaskMapper.class)
public interface ColumnMapper {
    ColumnSimpleDto entityToSimpleDto(Column column);

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "tasks", ignore = true)
    @Mapping(target = "id", ignore = true)
    Column commandToEntity(ColumnCommand columnCommand);

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tasks", ignore = true)
    void updateEntityFromCommand(ColumnCommand command, @MappingTarget Column column);

    ColumnDto entityToDto(Column column);
}
