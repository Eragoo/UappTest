package com.Eragoo.UappTest.column;

import com.Eragoo.UappTest.task.TaskDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ColumnDto {
    private long id;
    private String name;
    private int priority;
    private Set<TaskDto> tasks;
}
