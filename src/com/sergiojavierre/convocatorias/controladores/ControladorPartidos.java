package com.sergiojavierre.convocatorias.controladores;

import com.sergiojavierre.convocatorias.modelos.Jugador;
import com.sergiojavierre.convocatorias.modelos.Participacion;
import com.sergiojavierre.convocatorias.modelos.Partido;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControladorPartidos {

    private final String partidosFile = "partidos";

    public List<Partido> getPartidos(){
        List<Partido> partidos = null;
        try{
            FileInputStream fis = new FileInputStream(partidosFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            partidos = (List<Partido>) ois.readObject();
            ois.close();
            fis.close();
        }
        catch (Exception e){
            System.out.println("Se ha producido un error leyendo del fichero "+partidosFile);
            System.out.println("Quizás sea la primera vez que se ejecuta el programa");
            partidos = new ArrayList<>();
        }
        return partidos;
    }

    public void nuevoPartido(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Datos del nuevo partido");
        System.out.print("Rival: ");
        String rival = scanner.nextLine();
        ControladorJugadores controladorJugadores = new ControladorJugadores();
        List<Jugador> jugadores = controladorJugadores.getJugadores();
        Partido partido = new Partido(rival);
        for(Jugador jugador: jugadores){
            System.out.print("Participación del jugador "+jugador.getNombre()+": ");
            Integer minutos = Integer.parseInt(scanner.nextLine());
            jugador.sumaMinutos(minutos);
            Participacion participacion = new Participacion(jugador,minutos);
            partido.addJugadorParticipacion(participacion);
        }
        List<Partido>partidos = getPartidos();
        partidos.add(partido);
        guardaPartidos(partidos);
        controladorJugadores.guardaJugadores(jugadores); //actualiza minutos de los jugadores
    }

    public void guardaPartidos(List<Partido> partidos){
        try{
            FileOutputStream fos = new FileOutputStream(partidosFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(partidos);
            oos.close();
            fos.close();
            System.out.println("Partidos actualizados");
        }
        catch (Exception c){
            System.out.println("Se ha producido un error escribiendo en el fichero "+partidosFile);
            c.printStackTrace();
        }
    }


}