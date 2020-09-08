package com.Eragoo.UappTest.column;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class ColumnCommand {
    @NotBlank(message = "Name must be not blank")
    private String name;
    @NotNull(message = "Priority must be specified")
    private Integer priority;
}
