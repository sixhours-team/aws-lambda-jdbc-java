CREATE TABLE IF NOT EXISTS employee (
    id int not null auto_increment primary key,
    last_name varchar(255),
    first_name varchar(255),
    address varchar(255),
    city varchar(255)
);
