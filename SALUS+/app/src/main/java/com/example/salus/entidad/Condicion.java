package com.example.salus.entidad;

public class Condicion {
    private int codCondicion;
    private String descripcion;

    public Condicion() {
    }
    public Condicion(int codCondicion, String descripcion) {
        this.codCondicion = codCondicion;
        this.descripcion = descripcion;
    }
    public int getCodCondicion() {
        return codCondicion;
    }
    public void setCodCondicion(int codCondicion) {
        this.codCondicion = codCondicion;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "id " + codCondicion +" - " + descripcion;
    }
}
