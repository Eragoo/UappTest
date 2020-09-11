package com.Eragoo.UappTest.column;

import com.Eragoo.UappTest.task.Task;
import com.Eragoo.UappTest.task.TaskDto;
import com.Eragoo.UappTest.task.TaskMapper;
import com.Eragoo.UappTest.task.TaskRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ColumnService {
    private ColumnRepository columnRepository;
    private ColumnMapper columnMapper;
    private ColumnFinder columnFinder;
    private TaskMapper taskMapper;
    private TaskRepository taskRepository;

    public ColumnSimpleDto create(@NonNull ColumnCommand columnCommand) {
        Column column = columnMapper.commandToEntity(columnCommand);
        Column saved = columnRepository.save(column);
        return columnMapper.entityToSimpleDto(saved);
    }

    public ColumnSimpleDto get(long id) {
        Column column = columnFinder.find(id);
        return columnMapper.entityToSimpleDto(column);
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

    public List<TaskDto> getAllTasksInColumn(long columnId) {
        return taskRepository.findAllByColumn_IdAndDeletedFalseOrderByPriority(columnId)
                .stream()
                .map(taskMapper::entityToDto)
                .collect(Collectors.toList());
    }
}
