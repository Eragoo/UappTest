package com.Eragoo.UappTest.column;

import com.Eragoo.UappTest.error.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ColumnFinder {
    private ColumnRepository columnRepository;

    public Column find(Long columnId) {
        return columnRepository
                .findByIdAndDeletedFalse(columnId)
                .orElseThrow(() -> new NotFoundException("Column with id " + columnId + " not found"));
    }
}
