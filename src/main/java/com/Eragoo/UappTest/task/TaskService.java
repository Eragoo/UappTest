package com.Eragoo.UappTest.task;

import com.Eragoo.UappTest.error.exception.NotFoundException;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository taskRepository;
    private TaskMapper taskMapper;

    public TaskDto create(@NotNull TaskCommand command) {
        Task task = taskMapper.commandToEntity(command);
        Task savedEntity = taskRepository.save(task);
        return taskMapper.entityToDto(savedEntity);
    }

    public TaskDto get(long id) {
        Task task = findTask(id);
        return taskMapper.entityToDto(task);
    }

    private Task findTask(long id) {
        return taskRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Task with id " + id + " not found"));
    }

    public void delete(long id) {
        Task task = findTask(id);
        taskRepository.delete(task);
    }

    @Transactional
    public TaskDto update(long id, @NotNull TaskCommand taskCommand) {
        Task task = findTask(id);
        //Hibernate updates entity because of entity persistent state in transaction
        taskMapper.updateEntityFromCommand(taskCommand, task);
        return taskMapper.entityToDto(task);
    }
}
