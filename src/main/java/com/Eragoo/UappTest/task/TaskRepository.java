package com.Eragoo.UappTest.task;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findByIdAndDeletedFalse(Long aLong);
    List<Task> findAllByColumn_IdAndDeletedFalseOrderByPriority(Long columnId);
}
