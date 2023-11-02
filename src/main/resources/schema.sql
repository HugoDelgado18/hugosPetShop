create table pet
(
    id bigint not null,
    name varchar(255) not null,
    age smallint not null,
    breed varchar(255),
    price smallint not null,
    available boolean not null,
    primary key (id)
);