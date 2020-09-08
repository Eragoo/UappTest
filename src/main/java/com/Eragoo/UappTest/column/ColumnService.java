package com.Eragoo.UappTest.column;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
        Column column = columnFinder.find(id);
        return columnMapper.entityToDto(column);
    }

    @Transactional
    public ColumnSimpleDto update(long id, @NonNull ColumnCommand columnCommand) {
        Column column = columnFinder.find(id);
        columnMapper.updateEntityFromCommand(columnCommand, column);
        return columnMapper.entityToSimpleDto(column);
    }

    @Transactional
    public void delete(long id) {
        Column column = columnFinder.find(id);
        column.getTasks().forEach(task -> task.setDeleted(true));
        column.setDeleted(true);
    }

    public List<ColumnSimpleDto> getAll() {
        List<Column> columns = columnRepository.findAllByDeletedFalseOrderByPriority();
        return columns
                .stream()
                .map(columnMapper::entityToSimpleDto)
                .collect(Collectors.toList());
    }
}
