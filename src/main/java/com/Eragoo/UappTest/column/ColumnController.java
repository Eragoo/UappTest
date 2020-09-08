package com.Eragoo.UappTest.column;

import com.Eragoo.UappTest.task.TaskCommand;
import com.Eragoo.UappTest.task.TaskDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/column")
@AllArgsConstructor
public class ColumnController {
    private ColumnService columnService;

    @PostMapping
    public ResponseEntity<ColumnSimpleDto> create(@RequestBody ColumnCommand command) {
        ColumnSimpleDto dto = columnService.create(command);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ColumnDto> get(@PathVariable long id) {
        ColumnDto dto = columnService.get(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ColumnSimpleDto> update(@PathVariable long id, @RequestBody ColumnCommand command) {
        ColumnSimpleDto dto = columnService.update(id, command);
        return ResponseEntity.ok(dto);
    }
}
