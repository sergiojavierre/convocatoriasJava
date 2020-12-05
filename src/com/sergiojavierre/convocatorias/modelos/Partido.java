package com.sergiojavierre.convocatorias.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Partido implements Serializable {

    private final String rival;
    private final List<Participacion> participaciones;

    public Partido(String rival) {
        this.rival = rival;
        participaciones = new ArrayList<>();
    }

    public void addJugadorParticipacion(Participacion participacion){
        this.participaciones.add(participacion);
    }

    @Override
    public String toString() {
        return "Partido{" +
                "rival='" + rival + '\'' +
                ", participaciones=" + participaciones +
                '}';
    }
}
