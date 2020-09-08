package com.Eragoo.UappTest.column;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ColumnRepository extends JpaRepository<Column, Long> {
    Optional<Column> findByIdAndDeletedFalse(Long id);
    List<Column> findAllByDeletedFalseOrderByPriority();
}
