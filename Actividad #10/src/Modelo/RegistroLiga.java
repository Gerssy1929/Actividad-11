/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Datos.*;
import Entidades.LigaEspañola;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author German
 */
public class RegistroLiga {
    private IArchivoLiga datos;

    public RegistroLiga() {
        //this.datos = new ArchivoLiga();
        this.datos = new ArchivoLigaBin();
    }

    public IArchivoLiga getDatos() {
        return datos;
    }

    public void setDatos(IArchivoLiga datos) {
        this.datos = datos;
    }

   public LigaEspañola eliminar(String name) throws IOException{
        return this.datos.eliminar(name);
    }
    
    public LigaEspañola buscar(String name) throws IOException{
        return this.datos.buscar(name);
    }
    public List<LigaEspañola> leer() throws IOException{
        return this.datos.leer();
    }
    
    public boolean escribir(LigaEspañola LE) throws IOException{
        return this.datos.escribir(LE);
    }
    
    
}
