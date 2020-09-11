package com.Eragoo.UappTest.task;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/task")
@AllArgsConstructor
public class TaskController {
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDto> create(@Valid @RequestBody TaskCommand command) {
        TaskDto dto = taskService.create(command);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> get(@PathVariable long id) {
        TaskDto dto = taskService.get(id);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        taskService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> update(@PathVariable long id, @Valid @RequestBody TaskCommand command) {
        TaskDto dto = taskService.update(id, command);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{taskId}/move-to-column")
    public ResponseEntity<TaskDto> moveToAnotherColumn(@PathVariable long taskId, @RequestParam long columnId) {
        TaskDto taskDto = taskService.moveToAnotherColumn(taskId, columnId);
        return ResponseEntity.ok(taskDto);
    }

    @PutMapping("/{taskId}/change-priority")
    public ResponseEntity<TaskDto> changePriority(@PathVariable long taskId, @RequestParam int newPriority) {
        TaskDto taskDto = taskService.changePriority(taskId, newPriority);
        return ResponseEntity.ok(taskDto);
    }
}
