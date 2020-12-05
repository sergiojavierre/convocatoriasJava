package com.sergiojavierre.convocatorias.controladores;

import java.util.Scanner;

public class Menu {

    public void menuPrincipal(){
        System.out.print("1) Jugadores\n2) Partidos\nOtro) Salir\nOpción: ");
        Scanner scanner = new Scanner(System.in);
        String opcion = scanner.nextLine();
        if(opcion.equals("1")){
            menuJugadores();
        }
        else if(opcion.equals("2")){
            menuPartidos();
        }
    }

    public void menuJugadores(){
        ControladorJugadores controladorJugadores = new ControladorJugadores();
        System.out.print("1) Listado\n2) Nuevo jugador\nOpción: ");
        Scanner scanner = new Scanner(System.in);
        String opcion = scanner.nextLine();
        if(opcion.equals("1")){
            System.out.println(controladorJugadores.getJugadores());
        }
        else if(opcion.equals("2")){
            controladorJugadores.nuevoJugador();
        }
        menuPrincipal();
    }

    public void menuPartidos(){
        ControladorPartidos controladorPartidos = new ControladorPartidos();
        System.out.print("1) Listado\n2) Nuevo partido\nOpción: ");
        Scanner scanner = new Scanner(System.in);
        String opcion = scanner.nextLine();
        if(opcion.equals("1")){
            System.out.println(controladorPartidos.getPartidos());
        }
        else if(opcion.equals("2")){
            controladorPartidos.nuevoPartido();
        }
        menuPrincipal();
    }

}
