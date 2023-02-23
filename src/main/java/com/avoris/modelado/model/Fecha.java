package com.avoris.modelado.model;

import java.time.LocalDate;

public final class Fecha {

    private final LocalDate fecha;

    public Fecha(LocalDate fecha) {
        this.fecha=fecha;
    }


    public String getDiaYMes() {
        StringBuilder mensaje= new StringBuilder();
        mensaje.append("Dia: ")
                .append(String.valueOf(fecha.getDayOfMonth()))
                .append(" ")
                .append("Mes: ")
                .append(String.valueOf(fecha.getMonthValue()));
        return String.valueOf(mensaje);
    }


}
