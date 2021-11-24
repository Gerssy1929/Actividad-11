/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Entidades.LigaEspañola;
import Modelo.RegistroLiga;
import java.io.IOException;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author German
 */
public class MenuEjecutable {
    
    private static RegistroLiga registro = new RegistroLiga();
 
    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner (System.in);
       
        boolean salir = false;
        int opcion;
        
        while (!salir){
            System.out.println("\nPrograma de la Liga de Fútbol ~ Menú de Opciones");
            System.out.println("1. Registrar Equipo");
            System.out.println("2. Tabla de posiciones");
            System.out.println("3. Buscar Equipo");
            System.out.println("4. Borrar Equipo");
            System.out.println("5. Modificar Equipo");
            System.out.println("6. Salir");
            try {
                
            
            System.out.println("Introduzca una opción: ");
            opcion = entrada.nextInt();
            
            switch (opcion){
                case 1:
                    RegistrarEquipos();
                    break;
                case 2:
                    tabla();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    eliminar();
                    break;
                case 5:
                    modificar();
                    break;
                case 6:   
                    salir=true;
                default:
                    System.out.println("Las opciones son entre 1 y 6");
        }
    }catch(InputMismatchException e){
           System.out.println("Debe escribir un número");
           entrada.next();
    }
    catch(IOException ioe){
            System.out.println(ioe);
}
        
}
        System.out.println("Fin del menú");
    }
    
public static void RegistrarEquipos() throws IOException{
       System.out.println("~~~Registro de Equipos~~~");
        String name = Lector.leerString("Nombre del Equipo: ");
        int jug = Lector.leerEntero("Ingrese el total de partidos jugados: ");
        int gan = Lector.leerEntero("Ingrese el total de partidos ganados: ");
        int emp = Lector.leerEntero("Ingrese el total de partidos empatados: ");
        int per = Lector.leerEntero("Ingrese el total de partidos perdidos: ");
        int pts = (gan * 3) + (emp * 1);
        
        LigaEspañola LIGAE = new LigaEspañola(name, jug, gan, emp, per, pts);
        registro.escribir(LIGAE);
    }

public static void tabla() throws IOException{
    List<LigaEspañola> lista = registro.leer();
        imprimirLista(lista);
}


public static void buscar() throws IOException{
    String name = Lector.leerString("Ingrese el nombre a buscar: ");
    LigaEspañola buscado = registro.buscar(name);
            if(buscado!=null){ // 
                System.out.println("El nombre de equipo fue encontrado en el archivo");
                System.out.println("Datos: ");
                System.out.println("Equipo   Jugados   Ganados   Empatados   Perdidos    Puntos");
                imprimirEquipo(buscado);
            }
            else{
                System.out.println("El Equipo con nombre "+name+" no se encuentra en el archivo");
            }
}


public static void eliminar() throws IOException{
    String name = Lector.leerString("Ingrese el nombre de equipo a eliminar: ");
    LigaEspañola eliminado = registro.eliminar(name);
            if(eliminado!=null){ // 
                System.out.println("El equipo fue encontrado y eliminado satisfactoriamente");
                System.out.println("Datos: ");
                System.out.println("Equipo   Jugados   Ganados   Empatados   Perdidos    Puntos");
                imprimirEquipo(eliminado);
            }
            else{
                System.out.println("El Equipo de nombre "+name+" no se encuentra en el archivo");
            }
}

public static void modificar() throws IOException{
    String nombre = Lector.leerString("Ingrese el nombre de equipo a modificar: ");
    LigaEspañola eliminado = registro.eliminar(nombre);
            if(eliminado!=null){ // 
                System.out.println("Datos: ");
                System.out.println("Equipo   Jugados   Ganados   Empatados   Perdidos    Puntos");
                imprimirEquipo(eliminado);
                
                System.out.println("Ingrese los nuevos datos del equipo:");
                String name = Lector.leerString("Nombre del Equipo: ");
        int jug = Lector.leerEntero("Ingrese el total de partidos jugados: ");
        int gan = Lector.leerEntero("Ingrese el total de partidos ganados: ");
        int emp = Lector.leerEntero("Ingrese el total de partidos empatados: ");
        int per = Lector.leerEntero("Ingrese el total de partidos perdidos: ");
        int pts = (gan * 3) + (emp * 1);
        
        LigaEspañola LIGAE = new LigaEspañola(name, jug, gan, emp, per, pts);
        registro.escribir(LIGAE);
            }
            else{
                System.out.println("El Equipo con nombre "+nombre+" no se encuentra en el archivo");
                
            }
}


public static void imprimirEquipo(LigaEspañola LE){
        
        System.out.printf("%-10s %-10d %-10d %-10d %-10d %-10d %n", LE.getNameEquip(), LE.getPj(), LE.getPg(), 
                LE.getPe(), LE.getPp(), LE.getPoints());
    }
    
    public static void imprimirLista(List<LigaEspañola> lista){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~Liga Española~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Equipo   Jugados   Ganados   Empatados   Perdidos    Puntos");
        Collections.sort(lista);
        for(LigaEspañola LE: lista){
            imprimirEquipo(LE);
        }
    }  
}

