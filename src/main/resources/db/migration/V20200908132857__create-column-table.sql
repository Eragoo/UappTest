create table "column"
(
    id       BIGINT GENERATED ALWAYS AS IDENTITY,
    name     text     not null,
    priority smallint not null,
    PRIMARY KEY (id)
);
alter table task
    add column column_id BIGINT REFERENCES "column";