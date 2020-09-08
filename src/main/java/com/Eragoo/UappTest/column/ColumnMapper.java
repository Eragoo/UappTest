package com.Eragoo.UappTest.column;

import org.mapstruct.Mapper;

@Mapper
public interface ColumnMapper {
    ColumnSimpleDto entityToDto(Column column);
}
