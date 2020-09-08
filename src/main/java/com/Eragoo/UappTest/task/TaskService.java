package com.Eragoo.UappTest.task;

import com.Eragoo.UappTest.column.Column;
import com.Eragoo.UappTest.column.ColumnFinder;
import com.Eragoo.UappTest.column.ColumnRepository;
import com.Eragoo.UappTest.error.exception.NotFoundException;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Objects.nonNull;

@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository taskRepository;
    private TaskMapper taskMapper;
    private ColumnFinder columnFinder;

    public TaskDto create(@NonNull TaskCommand command) {
        Task task = taskMapper.commandToEntity(command);
        Long columnId = command.getColumnId();
        updateColumn(task, columnId);
        Task savedEntity = taskRepository.save(task);
        return taskMapper.entityToDto(savedEntity);
    }

    public TaskDto get(long id) {
        Task task = findTask(id);
        return taskMapper.entityToDto(task);
    }

    private Task findTask(long id) {
        return taskRepository
                .findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new NotFoundException("Task with id " + id + " not found"));
    }

    @Transactional
    public void delete(long id) {
        Task task = findTask(id);
        task.setColumn(null);
        task.setDeleted(true);
    }

    @Transactional
    public TaskDto update(long id, @NonNull TaskCommand taskCommand) {
        Task task = findTask(id);
        taskMapper.updateEntityFromCommand(taskCommand, task);
        Long columnId = taskCommand.getColumnId();
        updateColumn(task, columnId);
        return taskMapper.entityToDto(task);
    }

    private void updateColumn(@NonNull Task task, Long columnId) {
        Column column = null;
        if (nonNull(columnId)) {
            column = columnFinder.findColumn(columnId);
        }
        task.setColumn(column);
    }
}
