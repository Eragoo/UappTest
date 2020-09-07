create table task
(
    id BIGINT GENERATED ALWAYS AS IDENTITY,
    name text not null,
    description text,
    creation_date timestamp not null,
    PRIMARY KEY (id)
)
