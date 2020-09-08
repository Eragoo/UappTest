package com.Eragoo.UappTest.column;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ColumnService {
    private ColumnRepository columnRepository;
    private ColumnMapper columnMapper;
    private ColumnFinder columnFinder;

    public ColumnSimpleDto create(@NonNull ColumnCommand columnCommand) {
        Column column = columnMapper.commandToEntity(columnCommand);
        Column saved = columnRepository.save(column);
        return columnMapper.entityToSimpleDto(saved);
    }

    public ColumnDto get(long id) {
        Column column = columnFinder.findColumn(id);
        return columnMapper.entityToDto(column);
    }
}
