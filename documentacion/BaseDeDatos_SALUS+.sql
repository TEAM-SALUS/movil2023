CREATE DATABASE IF NOT EXISTS SalusPlus;
USE SalusPlus;
/* TABLAS */
-- TABLA Condicion
CREATE TABLE IF NOT EXISTS Condicion (
CodCondicion_Con INT NOT NULL AUTO_INCREMENT,
Descripcion_Con varchar (100),
CONSTRAINT PK_Condicion PRIMARY KEY (`CodCondicion_Con`)
);
-- TABLA Usuario
CREATE TABLE IF NOT EXISTS Usuario (
DNI_Us INT NOT NULL,
Nombre_Us VARCHAR (50),
Apellido_Us VARCHAR (50),
Direccion_Us VARCHAR (100),
Ciudad_Us VARCHAR (50),
Telefono_Us VARCHAR (50),
Estado BOOLEAN DEFAULT true,
CodCondicion_Us INT,
CONSTRAINT PK_Usuario PRIMARY KEY (`DNI_Us`),
CONSTRAINT FK_Usuario_Condicion FOREIGN KEY (CodCondicion_Us) REFERENCES Condicion (CodCondicion_Con)
);
-- TABLA Categoria
CREATE TABLE IF NOT EXISTS Categoria (
CodCategoria_Cat INT NOT NULL AUTO_INCREMENT,
Descripcion_Cat VARCHAR (100),
CONSTRAINT PK_Categoria PRIMARY KEY (`CodCategoria_Cat`)
);
-- TABLA Servicio --
CREATE TABLE IF NOT EXISTS Servicio (
CodServicio_Ser INT NOT NULL,
Titulo_Ser VARCHAR (50),
Descripcion_Ser VARCHAR (100),
Estado BOOLEAN DEFAULT true,
CodCategoria_Ser INT,
CONSTRAINT PK_Servicio PRIMARY KEY (`CodServicio_Ser`),
CONSTRAINT FK_Servicio_Categoria FOREIGN KEY (CodCategoria_Ser) REFERENCES Categoria (CodCategoria_Cat)
);
-- TABLA ServicioXProfesional
CREATE TABLE IF NOT EXISTS ServicioXProfesional (
CodServicio_SerXPro int,
DNI_SerXPro int,
CONSTRAINT PK_ServicioXProfesional PRIMARY KEY (`CodServicio_serXPro`, `DNI_SerXPro`),
CONSTRAINT FK_ServicioXProfesional_Servicio foreign key (`CodServicio_SerXPro`) REFERENCES Servicio (`CodServicio_Ser`),
CONSTRAINT FK_ServicioXProfesional_Usuario FOREIGN KEY (`DNI_SerXPro`) REFERENCES Usuario (`DNI_Us`)
);
-- TABLA Truno
CREATE TABLE IF NOT EXISTS Turno (
CodTurno_Tur INT NOT NULL AUTO_INCREMENT,
Fecha_Tur DATETIME DEFAULT CURRENT_TIMESTAMP,
FechaAsignacion_Tur DATETIME,
Estado BOOLEAN DEFAULT true,
DNI_CliTur INT NOT NULL,
CodServicio_Tur INT NOT NULL,
DNI_ProTur INT NOT NULL,
CONSTRAINT PRIMARY KEY (`CodTurno_Tur`),
CONSTRAINT FK_Turno_Usuario FOREIGN KEY (DNI_CliTur)
	REFERENCES Usuario (DNI_Us),
CONSTRAINT FK_Turno_ServicioxProfesional FOREIGN KEY (`CodServicio_Tur`,`DNI_ProTur`)
	REFERENCES ServicioXProfesional (`CodServicio_SerXPro`,`DNI_SerXPro`)
);