package com.Eragoo.UappTest.task;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Getter
@Setter
public class TaskCommand {
    @NotBlank(message = "Name must be not blank")
    private String name;
    @NotBlank(message = "Description bust be not blank")
    private String description;
    @NotNull(message = "Priority must be specified")
    private Integer priority;
    private Instant creationDate;
    private Long columnId;
}
