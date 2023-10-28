package com.example.salus.entidad;

public class Usuario {
    private int dni;
    private String nombre;
    private String apellido;
    private String direccion;
    private String ciudad;
    private String telefono;
    private String email;
    private String usuario;
    private String clave;
    private String descripcion;
    private boolean estado;
    private Condicion condicion;
    public Usuario() {}

    public Usuario(int dni, String nombre, String apellido, String direccion, String ciudad, String telefono, String email, String usuario, String clave, String descripcion, boolean estado, Condicion condicion) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.email = email;
        this.usuario = usuario;
        this.clave = clave;
        this.descripcion = descripcion;
        this.estado = estado;
        this.condicion = condicion;
    }

    public int getDni() {
        return dni;
    }
    public void setDni(int dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public boolean getEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public Condicion getCondicion() {
        return condicion;
    }
    public void setCondicion(Condicion condicion) {
        this.condicion = condicion;
    }
    @Override
    public String toString() {
        return "Usuario{" +
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", usuario='" + usuario + '\'' +
                ", clave='" + clave + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", condicion=" + condicion +
                '}';
    }
}
