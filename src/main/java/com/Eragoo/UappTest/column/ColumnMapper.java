package com.Eragoo.UappTest.column;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ColumnMapper {
    ColumnSimpleDto entityToDto(Column column);

    @Mapping(target = "tasks", ignore = true)
    @Mapping(target = "id", ignore = true)
    Column commandToEntity(ColumnCommand columnCommand);
}
