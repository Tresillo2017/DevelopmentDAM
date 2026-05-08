create database ebanca;
use ebanca;

create table clientes(
	id int auto_increment primary key,
    nombre varchar(20),
    apellido varchar(20),
    email varchar(30),
    telefono int
);

insert into clientes(nombre, apellido, email, telefono) values ("Pepe", "Ruiz", "pepe@gmail.com", 968112233);
insert into clientes(nombre, apellido, email, telefono) values ("Maria", "López", "maria@gmail.com", 968445566);
insert into clientes(nombre, apellido, email, telefono) values ("Luis", "Ros", "luis@gmail.com", 968778899);

select * from clientes;