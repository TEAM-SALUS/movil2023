package com.example.salus.entidad;

public class Servicio {
    private int codServicio;
    private String titulo;
    private String descripcion;
    private boolean estado;
    private Categoria categoria;
    public Servicio() {
    }
    public Servicio(int codServicio, String titulo, String descripcion, boolean estado, Categoria categoria) {
        this.codServicio = codServicio;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.categoria = categoria;
    }
    public int getCodServicio() {
        return codServicio;
    }
    public void setCodServicio(int codServicio) {
        this.codServicio = codServicio;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public boolean getEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    @Override
    public String toString() {
        return "Servicio{" +
                "codServicio=" + codServicio +
                ", titulo='" + titulo + '\'' +
                ", Descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", categoria=" + categoria +
                '}';
    }
}
