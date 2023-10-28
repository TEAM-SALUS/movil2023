package com.example.salus.negocioImpl;

import android.widget.Button;

public class ServicioModelo {
    private int imgServicio;
    private String servicio;
    private Button btnServicio;


    public ServicioModelo(int img_servicios, String medicinaGeneral) {
    }

    public ServicioModelo(int imgServicio, String servicio, Button btnServicio) {
        this.imgServicio = imgServicio;
        this.servicio = servicio;
        this.btnServicio = btnServicio;
    }

    public int getImgServicio() {
        return imgServicio;
    }

    public void setImgServicio(int imgServicio) {
        this.imgServicio = imgServicio;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public Button getBtnServicio() {
        return btnServicio;
    }

    public void setBtnServicio(Button btnServicio) {
        this.btnServicio = btnServicio;
    }

}