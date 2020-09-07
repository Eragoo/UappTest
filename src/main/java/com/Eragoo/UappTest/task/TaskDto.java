package com.Eragoo.UappTest.task;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class TaskDto {
    private Long id;
    private String name;
    private String description;
    private Instant creationDate;
}
