package com.gurzelai.deseostemporales;

import java.io.Serializable;
import java.util.Calendar;

public class Deseo implements Serializable {

    String nombre, descripcion;
    String diaAviso, diaCreacion;
    double precio;

    public Deseo(String nombre, String descripcion, String diaAviso, double precio){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.diaAviso = diaAviso;
        this.diaCreacion = diaActual();
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String diaActual() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return day + " / " + (month+1) + " / " + year;
    }

    public String getDiaAviso() {
        return diaAviso;
    }
}
