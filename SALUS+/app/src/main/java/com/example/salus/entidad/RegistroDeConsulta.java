package com.example.salus.entidad;

public class RegistroDeConsulta {
    private int id;
    private String fecha;
    private String hora;
    private String sintomas;
    private String diagnostico;
    private String tratamiento;
    private int id_turno;
    public RegistroDeConsulta() {
    }
    public RegistroDeConsulta(int id, String fecha, String hora, String sintomas, String diagnostico, String tratamiento, int id_turno) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.sintomas = sintomas;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.id_turno = id_turno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public int getId_turno() {
        return id_turno;
    }

    public void setId_turno(int id_turno) {
        this.id_turno = id_turno;
    }

    @Override
    public String toString() {
        return "RegistroDeConsulta{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", sintomas='" + sintomas + '\'' +
                ", diagnostico='" + diagnostico + '\'' +
                ", tratamiento='" + tratamiento + '\'' +
                ", id_turno=" + id_turno +
                '}';
    }
}
