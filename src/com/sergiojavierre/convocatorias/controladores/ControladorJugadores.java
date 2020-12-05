package com.sergiojavierre.convocatorias.controladores;

import com.sergiojavierre.convocatorias.modelos.Jugador;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControladorJugadores {

    private final String jugadoresFile = "jugadores";

    public List<Jugador> getJugadores(){
        List<Jugador> jugadores = null;
        try{
            FileInputStream fis = new FileInputStream(jugadoresFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            jugadores = (List<Jugador>) ois.readObject();
            ois.close();
            fis.close();
        }
        catch (Exception e){
            System.out.println("Se ha producido un error leyendo del fichero "+jugadoresFile);
            System.out.println("Quizás sea la primera vez que se ejecuta el programa");
            jugadores = new ArrayList<>();
        }
        return jugadores;
    }

    public void nuevoJugador(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Datos del nuevo jugador");
        System.out.print("Dorsal: ");
        Integer dorsal = Integer.parseInt(scanner.nextLine());
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        Jugador jugador = new Jugador(dorsal,nombre,0);
        List<Jugador> jugadores = getJugadores();
        jugadores.add(jugador);
        guardaJugadores(jugadores);
    }

    public void guardaJugadores(List<Jugador> jugadores){
        try{
            FileOutputStream fos = new FileOutputStream(jugadoresFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(jugadores);
            oos.close();
            fos.close();
            System.out.println("Jugadores actualizados");
        }
        catch (Exception c){
            System.out.println("Se ha producido un error escribiendo en el fichero "+jugadoresFile);
            c.printStackTrace();
        }
    }


}
