package com.sergiojavierre.convocatorias.modelos;

import java.io.Serializable;

public class Jugador implements Serializable {

    private Integer dorsal;
    private String nombre;
    private Integer minutos;

    public Jugador(Integer dorsal, String nombre, Integer minutos) {
        this.dorsal = dorsal;
        this.nombre = nombre;
        this.minutos = minutos;
    }

    public Integer getDorsal() {
        return dorsal;
    }

    public void setDorsal(Integer dorsal) {
        this.dorsal = dorsal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getMinutos() {
        return minutos;
    }

    public void setMinutos(Integer minutos) {
        this.minutos = minutos;
    }

    public void sumaMinutos(Integer minutos){
        this.minutos+=minutos;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "dorsal=" + dorsal +
                ", nombre='" + nombre + '\'' +
                ", minutos=" + minutos +
                '}';
    }
}
