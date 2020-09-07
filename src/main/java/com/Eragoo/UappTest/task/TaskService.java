package com.Eragoo.UappTest.task;

import com.Eragoo.UappTest.error.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository taskRepository;
    private TaskMapper taskMapper;

    public TaskDto create(TaskCommand command) {
        Task task = taskMapper.commandToEntity(command);
        Task savedEntity = taskRepository.save(task);
        return taskMapper.entityToDto(savedEntity);
    }

    public TaskDto getById(long id) {
        Task task = taskRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Task with id " + id + " not found"));
        return taskMapper.entityToDto(task);
    }
}
