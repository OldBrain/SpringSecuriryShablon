-- CREATE DATABASE awp OWNER postgres ENCODING 'UTF8';

-- DROP DATABASE IF EXISTS awp;
-- CREATE SCHEMA awp;


create table if not exists users
(
    id         bigserial primary key,
    username   varchar(30)  not null,
    password   varchar(200) not null,
    email      varchar(50) unique,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);
-- admin:admin
-- manager:1234
-- main_manager:1234
insert into users (username, password, email)
values ('admin', '$2a$12$SpBu8mutcZOxdRJ1uB7K6.gJvohkIh4eG4KbM4YKI.cHt3/Oje3Sq', 'admin@gmail.com'),
       ('manager', '$2a$12$5LFojdj.ByfyOyO13ziCP.3S.UIezgdPKdiDQriDub1zChxtnZi9u', 'manager@gmail.com'),
       ('main_manager', '$2a$12$5LFojdj.ByfyOyO13ziCP.3S.UIezgdPKdiDQriDub1zChxtnZi9u', 'main_manager@gmail.com');

create table if not exists roles
(
    id         bigserial primary key,
    name       varchar(50) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

insert into roles (name)
values ('ROLE_ADMIN'),
       ('ROLE_MANAGER'),
       ('ROLE_MAIN_MANAGER'),
       ('ROLE_EMPTY');

CREATE TABLE if not exists users_roles
(
    id      bigserial,
    user_id bigint not null references users (id),
    role_id bigint not null references roles (id),
    primary key (user_id, role_id)
);

INSERT INTO users_roles(user_id, role_id)
VALUES (1,1),
       (2,2),
       (3,3);

