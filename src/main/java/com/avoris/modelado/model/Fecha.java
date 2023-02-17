package com.avoris.modelado.model;

import java.time.LocalDate;

public class Fecha {

    private final LocalDate fecha;

    public Fecha(LocalDate fecha) {
        this.fecha=fecha;
    }


    public String getDiaYMes() {
        return String.valueOf("Dia: "+fecha.getDayOfMonth())+ " " +"Mes: " + String.valueOf(fecha.getMonthValue());
    }


    @Override
    public String toString() {
        return "Fecha [fecha=" + fecha + ", getDiaYMes()=" + getDiaYMes() + ", getClass()=" + getClass()
                + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

}
