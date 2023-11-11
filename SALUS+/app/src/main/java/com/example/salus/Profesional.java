package com.example.salus;

public class Profesional {
    private Integer id;
    private String nombre;
    private String apellido;

    private String usuarioCustom;

    public Profesional(){

    }

    public Profesional(Integer id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public Profesional(Integer id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString(){
        this.usuarioCustom = this.usuarioCustom = id+" "+nombre+" "+apellido;
        return usuarioCustom;
    }

}
