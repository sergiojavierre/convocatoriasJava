package com.sergiojavierre.convocatorias.modelos;

import java.io.Serializable;

public class Participacion implements Serializable {

    private Jugador jugador;
    private Integer minutos;

    public Participacion(Jugador jugador, Integer minutos) {
        this.jugador = jugador;
        this.minutos = minutos;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Integer getMinutos() {
        return minutos;
    }

    public void setMinutos(Integer minutos) {
        this.minutos = minutos;
    }

    @Override
    public String toString() {
        return "Participacion{" +
                "jugador=" + jugador +
                ", minutos=" + minutos +
                '}';
    }
}
