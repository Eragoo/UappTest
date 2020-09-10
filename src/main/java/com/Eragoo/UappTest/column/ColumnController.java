package com.Eragoo.UappTest.column;

import com.Eragoo.UappTest.task.TaskDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/column")
@AllArgsConstructor
public class ColumnController {
    private ColumnService columnService;

    @GetMapping("/all")
    public ResponseEntity<List<ColumnSimpleDto>> getAll() {
        List<ColumnSimpleDto> columns = columnService.getAll();
        return ResponseEntity.ok(columns);
    }

    @PostMapping
    public ResponseEntity<ColumnSimpleDto> create(@Valid @RequestBody ColumnCommand command) {
        ColumnSimpleDto dto = columnService.create(command);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ColumnSimpleDto> get(@PathVariable long id) {
        ColumnSimpleDto dto = columnService.get(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}/tasks")
    public ResponseEntity<List<TaskDto>> getColumnTasks(@PathVariable long id) {
        List<TaskDto> allTasksInColumn = columnService.getAllTasksInColumn(id);
        return ResponseEntity.ok(allTasksInColumn);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ColumnSimpleDto> update(@PathVariable long id, @Valid @RequestBody ColumnCommand command) {
        ColumnSimpleDto dto = columnService.update(id, command);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        columnService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
