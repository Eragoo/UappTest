package com.Eragoo.UappTest.column;

import com.Eragoo.UappTest.error.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ColumnFinder {
    private ColumnRepository columnRepository;

    public Column findColumn(Long columnId) {
        return columnRepository
                .findById(columnId)
                .orElseThrow(() -> new NotFoundException("Column with id " + columnId + " not found"));
    }
}
