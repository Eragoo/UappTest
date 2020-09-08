package com.Eragoo.UappTest.task;

import com.Eragoo.UappTest.column.Column;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int priority;
    private Instant creationDate;
    @ManyToOne
    private Column column;
    private boolean deleted;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return priority == task.priority &&
                Objects.equals(id, task.id) &&
                name.equals(task.name) &&
                Objects.equals(description, task.description) &&
                creationDate.equals(task.creationDate) &&
                column.equals(task.column);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, priority, creationDate, column);
    }
}
