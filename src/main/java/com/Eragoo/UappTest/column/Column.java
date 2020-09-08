package com.Eragoo.UappTest.column;

import com.Eragoo.UappTest.task.Task;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Column {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int priority;
    @OneToMany(mappedBy = "column")
    private Set<Task> tasks;
}
