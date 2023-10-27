package com.example.salus.entidad;

public class Base {
    private final static String nombreBase = "SalusPlus";
    private static int versionBase = 1;
    private final static String sqlCreateTableCondicion = "CREATE TABLE IF NOT EXISTS Condicion (" +
            "CodCondicion_Con INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "Descripcion_Con varchar (100)" +
            ");";
    private final static String sqlDropTableCondicion = "DROP TABLE IF EXISTS Condicion;";
    private final static String sqlCreateTableUsuario = "CREATE TABLE IF NOT EXISTS Usuario (" +
            "DNI_Us INTEGER NOT NULL," +
            "Nombre_Us VARCHAR (50)," +
            "Apellido_Us VARCHAR (50)," +
            "Direccion_Us VARCHAR (100)," +
            "Ciudad_Us VARCHAR (50)," +
            "Telefono_Us VARCHAR (50)," +
            "Email_Us VARCHAR (50)," +
            "Usuario_Us VARCHAR (50)," +
            "Clave_uS VARCHAR (50)," +
            "Estado BOOLEAN DEFAULT true," +
            "CodCondicion_Us INT," +
            "CONSTRAINT PK_Usuario PRIMARY KEY (`DNI_Us`)," +
            "CONSTRAINT FK_Usuario_Condicion FOREIGN KEY (CodCondicion_Us)" +
                "REFERENCES Condicion (CodCondicion_Con)" +
            ");";
    private final static String sqlDropTableUsuario = "DROP TABLE IF EXISTS Usuario;";
    private final static String sqlCreateTableCategoria = "CREATE TABLE IF NOT EXISTS Categoria (" +
            "CodCategoria_Cat INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "Descripcion_Cat VARCHAR (100)" +
            ");";
    private final static String sqlDropTableCategoria = "DROP TABLE IF EXISTS Categoria;";
    private final static String sqlCreateTableServicio ="CREATE TABLE IF NOT EXISTS Servicio (" +
            "CodServicio_Ser INTEGER NOT NULL," +
            "Titulo_Ser VARCHAR (50)," +
            "Descripcion_Ser VARCHAR (100)," +
            "Estado BOOLEAN DEFAULT true," +
            "CodCategoria_Ser INT," +
            "CONSTRAINT PK_Servicio PRIMARY KEY (`CodServicio_Ser`)," +
            "CONSTRAINT FK_Servicio_Categoria FOREIGN KEY (CodCategoria_Ser)" +
                "REFERENCES Categoria (CodCategoria_Cat)" +
            ");";
    private final static String sqlDropTableServicio ="DROP TABLE IF EXISTS Servicio;";
    private final static String sqlCreateTableServicioXProfesional = "CREATE TABLE IF NOT EXISTS ServicioXProfesional (" +
            "CodServicio_SerXPro INTEGER," +
            "DNI_SerXPro INTEGER," +
            "CONSTRAINT PK_ServicioXProfesional PRIMARY KEY (CodServicio_serXPro, DNI_SerXPro)," +
            "CONSTRAINT FK_ServicioXProfesional_Servicio FOREIGN KEY (CodServicio_SerXPro)" +
                "REFERENCES Servicio (CodServicio_Ser)," +
            "CONSTRAINT FK_ServicioXProfesional_Usuario FOREIGN KEY (DNI_SerXPro)" +
                "REFERENCES Usuario (DNI_Us)" +
            ");";
    private final static String sqlDropTableServicioXProfesional = "DROP TABLE IF EXISTS ServicioXProfesional;";
    private final static String sqlCreateTableTurno = "CREATE TABLE IF NOT EXISTS Turno (" +
            "CodTurno_Tur INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "Fecha_Tur DATETIME DEFAULT CURRENT_TIMESTAMP," +
            "FechaAsignacion_Tur DATETIME," +
            "Estado BOOLEAN DEFAULT true," +
            "DNI_CliTur INT NOT NULL," +
            "CodServicio_Tur INT NOT NULL," +
            "DNI_ProTur INT NOT NULL," +
            "CONSTRAINT FK_Turno_Usuario FOREIGN KEY (DNI_CliTur)" +
                "REFERENCES Usuario (DNI_Us)," +
            "CONSTRAINT FK_Turno_ServicioxProfesional FOREIGN KEY (CodServicio_Tur,DNI_ProTur)" +
                "REFERENCES ServicioXProfesional (CodServicio_SerXPro,DNI_SerXPro)" +
            ");";
    private final static String sqlDropTableTurno = "DROP TABLE IF EXISTS Turno;";
    public Base() {
    }
    public static String getNombreBase() {
        return nombreBase;
    }
    public static int getVersionBase() {
        return versionBase;
    }
    public static void setVersionBase(int versionBase) {
        Base.versionBase = versionBase;
    }
    public static String getSqlCreateTableCondicion() {
        return sqlCreateTableCondicion;
    }
    public static String getSqlDropTableCondicion() {
        return sqlDropTableCondicion;
    }
    public static String getSqlCreateTableUsuario() {
        return sqlCreateTableUsuario;
    }
    public static String getSqlDropTableUsuario() {
        return sqlDropTableUsuario;
    }
    public static String getSqlCreateTableCategoria() {
        return sqlCreateTableCategoria;
    }
    public static String getSqlDropTableCategoria() {
        return sqlDropTableCategoria;
    }
    public static String getSqlCreateTableServicio() {
        return sqlCreateTableServicio;
    }
    public static String getSqlDropTableServicio() {
        return sqlDropTableServicio;
    }
    public static String getSqlCreateTableServicioXProfesional() {
        return sqlCreateTableServicioXProfesional;
    }
    public static String getSqlDropTableServicioXProfesional() {
        return sqlDropTableServicioXProfesional;
    }
    public static String getSqlCreateTableTurno() {
        return sqlCreateTableTurno;
    }
    public static String getSqlDropTableTurno() {
        return sqlDropTableTurno;
    }
}
