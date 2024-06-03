package com.example.salus.entidad;

import java.time.LocalDateTime;

public class Turno {
    private int codTurno;
    private LocalDateTime fecha;
    private LocalDateTime fechaAsignacion;
    private boolean estado;
    private Usuario usuarioCli;
        private ServicioXProfesional servicioXProfesional;
    public Turno() {}
    public Turno(int codTurno, LocalDateTime fecha, LocalDateTime fechaAsignacion, boolean estado, Usuario usuarioCli, ServicioXProfesional servicioXProfesional) {
        this.codTurno = codTurno;
        this.fecha = fecha;
        this.fechaAsignacion = fechaAsignacion;
        this.estado = estado;
        this.usuarioCli = usuarioCli;
        this.servicioXProfesional = servicioXProfesional;
    }
    public int getCodTurno() {
        return codTurno;
    }
    public void setCodTurno(int codTurno) {
        this.codTurno = codTurno;
    }
    public LocalDateTime getFecha() {
        return fecha;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    public LocalDateTime getFechaAsignacion() {
        return fechaAsignacion;
    }
    public void setFechaAsignacion(LocalDateTime fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }
    public boolean getEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public Usuario getUsuarioCli() {
        return usuarioCli;
    }
    public void setUsuarioCli(Usuario usuarioCli) {
        this.usuarioCli = usuarioCli;
    }
    public ServicioXProfesional getServicioXProfesional() {
        return servicioXProfesional;
    }
    public void setServicioXProfesional(ServicioXProfesional servicioXProfesional) {
        this.servicioXProfesional = servicioXProfesional;
    }
    @Override
    public String toString() {
        return "Turno{" +
                "codTurno=" + codTurno +
                ", fecha=" + fecha +
                ", fechaAsignacion=" + fechaAsignacion +
                ", estado=" + estado +
                ", usuarioCli=" + usuarioCli +
                ", servicioXProfesional=" + servicioXProfesional +
                '}';
    }
}
