package com.Eragoo.UappTest.column;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        columnService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
