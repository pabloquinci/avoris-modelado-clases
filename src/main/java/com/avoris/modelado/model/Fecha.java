package com.avoris.modelado.model;

import java.time.LocalDate;

public final class Fecha {

    private final LocalDate fecha;

    public Fecha(LocalDate fecha) {
        this.fecha=fecha;
    }


    public String getDiaYMes() {
        return String.valueOf("Dia: "+fecha.getDayOfMonth())+ " " +"Mes: " + String.valueOf(fecha.getMonthValue());
    }


}
