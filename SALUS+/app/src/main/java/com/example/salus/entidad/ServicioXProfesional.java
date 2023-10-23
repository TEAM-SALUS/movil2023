package com.example.salus.entidad;

public class ServicioXProfesional {
    private Servicio servicio_SXP;
    private Usuario usuario_SXP;
    public ServicioXProfesional() {
    }
    public ServicioXProfesional(Servicio servicio_SXP, Usuario usuario_SXP) {
        this.servicio_SXP = servicio_SXP;
        this.usuario_SXP = usuario_SXP;
    }
    public Servicio getServicio_SXP() {
        return servicio_SXP;
    }
    public void setServicio_SXP(Servicio servicio_SXP) {
        this.servicio_SXP = servicio_SXP;
    }
    public Usuario getUsuario_SXP() {
        return usuario_SXP;
    }
    public void setUsuario_SXP(Usuario usuario_SXP) {
        this.usuario_SXP = usuario_SXP;
    }
    @Override
    public String toString() {
        return "ServicioXProfesional{" +
                "servicio_SXP=" + servicio_SXP +
                ", usuario_SXP=" + usuario_SXP +
                '}';
    }
}
