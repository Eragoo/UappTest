package com.Eragoo.UappTest.task;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Entity
@Getter
@Setter
public class Task {
    @Id
    private Long id;
    private String name;
    private String description;
    private Instant creationDate;
}
