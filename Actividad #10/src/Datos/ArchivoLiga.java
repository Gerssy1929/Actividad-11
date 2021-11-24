/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidades.LigaEspañola;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author German
 */
public class ArchivoLiga implements IArchivoLiga {
    private File archivoLiga;
    private FileWriter aEscritura;
    private Scanner aLectura;

    public ArchivoLiga() {
        this.archivoLiga = new File("liga.dat");
    }
    
    public ArchivoLiga(String name){
        this.archivoLiga = new File(name);
    }

    public File getArchivoLiga() {
        return archivoLiga;
    }

    public void setArchivoLiga(File archivoLiga) {
        this.archivoLiga = archivoLiga;
    }

    public FileWriter getaEscritura() {
        return aEscritura;
    }

    public void setaEscritura(FileWriter aEscritura) {
        this.aEscritura = aEscritura;
    }

    public Scanner getaLectura() {
        return aLectura;
    }

    public void setaLectura(Scanner aLectura) {
        this.aLectura = aLectura;
    }
    
    public LigaEspañola leerDatosLiga(String linea[]){
        LigaEspañola LE = new LigaEspañola();
        LE.setNameEquip(linea[0]);
        LE.setPj(Integer.valueOf(linea[1]));
        LE.setPg(Integer.valueOf(linea[2]));
        LE.setPe(Integer.valueOf(linea[3]));
        LE.setPp(Integer.valueOf(linea[4]));
        LE.setPoints(Integer.valueOf(linea[5]));
        return LE;
    }
    
    @Override
    public List<LigaEspañola> leer(){
       List<LigaEspañola> lista = null;
        try {
            
            this.aLectura = new Scanner(this.archivoLiga);
            lista = new ArrayList();
            while(this.aLectura.hasNext()){
                String linea[] = this.aLectura.nextLine().split(";");
                LigaEspañola LE = this.leerDatosLiga(linea);
                lista.add(LE);
            }
            return lista;
            
        } catch (FileNotFoundException exc) {
                System.out.println("EL archivo no se encuentra o no pueder ser leido");
                return null;
        }
        finally{
            if(this.aLectura!=null)
                this.aLectura.close();
        }
        
    }
    
    @Override
    public boolean escribir(LigaEspañola LE){
        PrintWriter escritor = null;
        boolean error=false;
        try{
            this.aEscritura = new FileWriter(this.archivoLiga, true); // edicio
            escritor = new PrintWriter(this.aEscritura);
            escritor.println(LE.getDatosFileText());
            error = true;
        }catch(IOException ioe){
            System.out.println("Error al abrir el archivo para escritura...");
           
        }
        finally{
            if(escritor!=null)
                escritor.close();
            
            if(this.aEscritura!=null){
                try{
                    this.aEscritura.close();
                }catch(IOException ioe){
                    System.out.println(ioe);
                }    
            }    
           
        }
         return error;
    }

    @Override
    public LigaEspañola eliminar(String name) throws IOException {
        
    List<LigaEspañola> listadoInicial =  this.leer();
        ArchivoLiga archivoAux = new ArchivoLiga("ligatemp.dat");
        LigaEspañola eliminado = null;
        for(LigaEspañola L: listadoInicial){
            if(L.getNameEquip().equals(name)){ // elemento a eliminar
                eliminado = L;
            }
            else{
                archivoAux.escribir(L);
            }
        }
        
        if(this.archivoLiga.delete()){
            if(archivoAux.getArchivoLiga().exists()){
                if(!archivoAux.getArchivoLiga().renameTo(this.archivoLiga)){
                    throw new IOException("El archivo temporal no pudo ser renombrado");
                }

            }
            else
               this.archivoLiga.createNewFile();
        }
        else{
            throw new IOException("El archivo original no pudo ser elimiando");
        }
            
        
        
        return eliminado;
    }

    @Override
    public LigaEspañola buscar(String name) throws IOException {
        LigaEspañola buscado = null;
        try {
            this.aLectura = new Scanner(this.archivoLiga);
            while(this.aLectura.hasNext()){
                String linea[] = this.aLectura.nextLine().split(";");
                LigaEspañola L = this.leerDatosLiga(linea);
                if(L.getNameEquip().equals(name)){
                    buscado = L;
                    break;
                }
            }
            return buscado;
            
        } catch (FileNotFoundException ex) {
                throw new IOException("EL archivo no se encuentra o no pueder ser leido");
        }
        finally{
            if(this.aLectura!=null)
                this.aLectura.close();
        }
    }
    }
    

