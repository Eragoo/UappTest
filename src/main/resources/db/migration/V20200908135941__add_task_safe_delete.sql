alter table task
    add column deleted boolean not null default false;