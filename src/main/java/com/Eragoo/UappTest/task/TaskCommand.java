package com.Eragoo.UappTest.task;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Getter
@Setter
@Builder
@JsonDeserialize(builder = TaskCommand.TaskCommandBuilder.class)
public class TaskCommand {
    @NotBlank(message = "Name must be not blank")
    private String name;
    @NotBlank(message = "Description bust be not blank")
    private String description;
    @NotNull(message = "Priority must be specified")
    private Integer priority;
    @NotNull
    private Instant creationDate;
    private Long columnId;
}
