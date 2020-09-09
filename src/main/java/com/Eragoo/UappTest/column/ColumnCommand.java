package com.Eragoo.UappTest.column;

import com.Eragoo.UappTest.task.TaskCommand;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@Builder
@JsonDeserialize(builder = ColumnCommand.ColumnCommandBuilder.class)
public class ColumnCommand {
    @NotBlank(message = "Name must be not blank")
    private String name;
    @NotNull(message = "Priority must be specified")
    private Integer priority;
}
