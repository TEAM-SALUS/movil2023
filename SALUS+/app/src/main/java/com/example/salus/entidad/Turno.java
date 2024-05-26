package com.example.salus.entidad;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class Turno {
    private int codTurno;
    private LocalDateTime fechaH;
    private LocalDateTime fechaAsignacion;
    private boolean estado;
    private Usuario usuarioCli;
    private ServicioXProfesional servicioXProfesional;

    public Turno() {
    }

    public Turno(int codTurno, LocalDateTime fecha, LocalDateTime fechaAsignacion, boolean estado, Usuario usuarioCli, ServicioXProfesional servicioXProfesional) {
        this.codTurno = codTurno;
        this.fechaH = fecha;
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

    public LocalDateTime getFechaH() {
        return fechaH;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fechaH = fecha;
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
                ", fecha=" + fechaH +
                ", fechaAsignacion=" + fechaAsignacion +
                ", estado=" + estado +
                ", usuarioCli=" + usuarioCli +
                ", servicioXProfesional=" + servicioXProfesional +
                '}';
    }


    // MODELO DE LA BD
    private Date fecha;
    private Time horario;
    private Boolean pagado;
    private Integer id_medico;

    public java.util.Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public CharSequence getHorario() {
        return (CharSequence) this.horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    public Boolean getPagado() {
        return pagado;
    }

    public void setPagado(Boolean pagado) {
        this.pagado = pagado;
    }

    public Integer getId_medico() {
        return id_medico;
    }

    public void setId_medico(Integer id_medico) {
        this.id_medico = id_medico;
    }


    // Convertir fecha y horario
    public Time convertirHora(Time horario) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = dateFormat.parse(String.valueOf(horario));
            this.fecha = new Date(parsedDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return horario;
    }

    public Date convertirFecha(Date fecha) {
        try {
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            java.util.Date parsedTime = timeFormat.parse(String.valueOf(fecha));
            this.horario = new Time(parsedTime.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return fecha;
    }
}
