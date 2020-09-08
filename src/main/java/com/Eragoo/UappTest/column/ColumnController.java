package com.Eragoo.UappTest.column;

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
}
