/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author German
 */
public class Lector {
    private static Scanner lector = new Scanner(System.in);
    
    public static int leerEntero(String read){
        int var=0;
        boolean error;
        do{
            try{
                System.out.print(read);
                var = lector.nextInt();
                error = false;
                return var;
            }
            catch(InputMismatchException ime){
                System.out.println("Error de lectura: se requiere un valor entero" );
                lector.nextLine();
                error = true;
            }
        }while(error);    
        return var;
    }
    
     public static String leerString(String read){
        System.out.print(read);
        return lector.next();
    }
}
