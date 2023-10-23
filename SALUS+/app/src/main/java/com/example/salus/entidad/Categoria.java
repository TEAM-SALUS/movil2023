package com.example.salus.entidad;

public class Categoria {
    private int codCategoria;
    private String descripcion;
    public Categoria() {
    }
    public Categoria(int codCategoria, String descripcion) {
        this.codCategoria = codCategoria;
        this.descripcion = descripcion;
    }
    public int getCodCategoria() {
        return codCategoria;
    }
    public void setCodCategoria(int codCategoria) {
        this.codCategoria = codCategoria;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    @Override
    public String toString() {
        return "Categoria{" +
                "codCategoria=" + codCategoria +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
