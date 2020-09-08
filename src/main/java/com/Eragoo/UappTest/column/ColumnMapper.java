package com.Eragoo.UappTest.column;

import com.Eragoo.UappTest.task.TaskMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = TaskMapper.class)
public interface ColumnMapper {
    ColumnSimpleDto entityToSimpleDto(Column column);

    @Mapping(target = "tasks", ignore = true)
    @Mapping(target = "id", ignore = true)
    Column commandToEntity(ColumnCommand columnCommand);

    ColumnDto entityToDto(Column column);
}
