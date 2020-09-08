create table "column"
(
    id       BIGINT GENERATED ALWAYS AS IDENTITY,
    name     text     not null,
    priority smallint not null,
    deleted boolean not null default false,
    PRIMARY KEY (id)
);
alter table task
    add column column_id BIGINT REFERENCES "column";