/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidades.LigaEspañola;
import java.io.*;
import java.util.List;


/**
 *
 * @author German
 */
public class ArchivoLigaBin implements IArchivoLiga {
    private File archivo;
    private FileInputStream aLectura;
    private FileOutputStream aEscritura;

    public ArchivoLigaBin() {
        this.archivo = new File("PosicionesLigaObjetos.dat");
    }
    
    
    private void guardarList(ListEquipos lista) throws IOException{
        
        this.aEscritura = new FileOutputStream(this.archivo);
        ObjectOutputStream escritor = new ObjectOutputStream(this.aEscritura);
        escritor.writeObject(lista);
        escritor.close();
        this.aEscritura.close();
        
    }
    
    private ListEquipos leerLista()throws IOException{
        
        if(this.archivo.exists()){
            this.aLectura = new FileInputStream(this.archivo);
            ObjectInputStream lector = new ObjectInputStream(this.aLectura);
            try {
                ListEquipos lista = (ListEquipos)lector.readObject();
                return lista;
            } catch (ClassNotFoundException ex) {
                throw new IOException("Error en el contenido del achivo");
            }
            finally{
                lector.close();
                this.aLectura.close();
            }
        }
        else{
            return new ListEquipos();
        }
        
    }
    
    
    @Override
    public LigaEspañola eliminar(String name) throws IOException {
        ListEquipos lista = this.leerLista();
        LigaEspañola eliminado = lista.eliminar(name);
        this.guardarList(lista);
        return eliminado;
    }

    @Override
    public LigaEspañola buscar(String name) throws IOException {
       ListEquipos lista = this.leerLista();
       return lista.buscar(name);
    }

    @Override
    public List<LigaEspañola> leer() throws IOException {
        ListEquipos lista = this.leerLista();
        return lista.leer();
    }

    @Override
    public boolean escribir(LigaEspañola LE) throws IOException {
        ListEquipos lista = this.leerLista();
        lista.escribir(LE);
        this.guardarList(lista);
        return true;
    }

    /**
     * @return the archivo
     */
    public File getArchivo() {
        return archivo;
    }

    /**
     * @param archivo the archivo to set
     */
    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    /**
     * @return the aLectura
     */
    public FileInputStream getaLectura() {
        return aLectura;
    }

    /**
     * @param aLectura the aLectura to set
     */
    public void setaLectura(FileInputStream aLectura) {
        this.aLectura = aLectura;
    }

    /**
     * @return the aEscritura
     */
    public FileOutputStream getaEscritura() {
        return aEscritura;
    }

    /**
     * @param aEscritura the aEscritura to set
     */
    public void setaEscritura(FileOutputStream aEscritura) {
        this.aEscritura = aEscritura;
    }
}

