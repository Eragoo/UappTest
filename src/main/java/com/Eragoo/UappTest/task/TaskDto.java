package com.Eragoo.UappTest.task;

import com.Eragoo.UappTest.column.ColumnSimpleDto;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class TaskDto {
    private Long id;
    private String name;
    private String description;
    private int priority;
    private Instant creationDate;
    private ColumnSimpleDto column;
}