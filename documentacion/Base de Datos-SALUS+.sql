/*CREATE DATABASE SalusPlus2*/
/*use SalusPlus2*/

create table Condicion
(
CodCondicion int,
descripcion varchar (100),
primary key (`CodCondicion`)
);

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

create table Categoria
(
CodCategoria int,
descripcion varchar (100),
primary key (`CodCategoria`)
);

create table Servicio
(
CodServicio int,
Titulo varchar (50),
Descripcion varchar (100),
Estado boolean,
CodCategoria_CATE int,
DNI_pro_sxp int,
primary key (`CodServicio`),
constraint fk_ServiCate foreign key (CodCategoria_CATE)
references Categoria (CodCategoria)
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
CodServicio int,
DNI_PRO int,
primary key (`CodTurno`),
constraint fk_Turno_SxP foreign key (`CodServicio`,`DNI_PRO`)
references ServicioXProfesional (`CodServicio`,`DNI_PRO`),
constraint fk_Turno_User foreign key (DNI_USER)
references Usuario (DNI)
);

create table ServicioXProfesional
(
CodServicio int,
DNI_PRO int,
primary key (`CodServicio`, `DNI_PRO`),
constraint fk_SxP_User foreign key (`DNI_PRO`)
references Usuario (`DNI`),
constraint fk_SxP_Servicio foreign key (`CodServicio`)
references Servicio (`CodServicio`)
);





