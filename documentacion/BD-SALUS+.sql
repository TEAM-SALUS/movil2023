/*CREATE DATABASE SalusPlus
USE SalusPlus*/


create table Usuario
(
DNI int not null,
Nombre varchar (50),
Apellido varchar (50),
Direccion varchar (100),
Ciudad varchar (50),
Telefono int (15),
Estado boolean,
CodCondicion_CONDI int,
primary key (`DNI`),
constraint fk_UserCondicion foreign key (CodCondicion_CONDI)
references Condicion (CodCondicion)
);
create table Condicion
(
CodCondicion int,
descripcion varchar (100),
primary key (`CodCondicion`)
);

create table Servicio
(
CodServicio int,
Titulo varchar (50),
Descripcion varchar (100),
Estado boolean,
CodCategoria_CATE int,
primary key (`CodServicio`),
constraint fk_ServiCate foreign key (CodCategoria_CATE)
references Categoria (CodCategoria)
);

create table Categoria
(
CodCategoria int,
descripcion varchar (100),
primary key (`CodCategoria`)
);

create table Turno
(
CodTurno int,
Fecha datetime,
Hora datetime,
FechaAsignacion datetime,
HoraAsignacion datetime,
Estado boolean,
DNI_USER int not null,
CodServicio_SERVI int,
primary key (`CodTurno`),
constraint fk_TurnoServi foreign key (CodServicio_SERVI)
references Servicio (CodServicio),
constraint fk_TurnoUser foreign key (DNI_USER)
references Usuario (DNI)
);
