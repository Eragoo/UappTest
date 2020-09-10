package com.Eragoo.UappTest.column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ColumnCommand {
    @NotBlank(message = "Name must be not blank")
    private String name;
    @NotNull(message = "Priority must be specified")
    private Integer priority;
}
