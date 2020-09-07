package com.Eragoo.UappTest.task;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/task")
@AllArgsConstructor
public class TaskController {
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDto> create(TaskCommand command) {
        return ResponseEntity.ok(taskService.create(command));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getById(@PathVariable long id) {
        return ResponseEntity.ok(taskService.getById(id));
    }
}
