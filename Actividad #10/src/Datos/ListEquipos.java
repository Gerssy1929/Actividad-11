/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidades.LigaEspañola;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author German
 */
public class ListEquipos implements IArchivoLiga, Serializable {

   private List<LigaEspañola> lista;

    public ListEquipos() {
        this.lista = new ArrayList();
    }
    
    
    
    @Override
    public LigaEspañola eliminar(String name) throws IOException {
        
        Iterator<LigaEspañola> i = this.lista.iterator();
        while(i.hasNext()){
            LigaEspañola LE = i.next();
            if(LE.getNameEquip().equals(name)){
                i.remove();
                return LE;
            }
        }
        return null;
    }

    @Override
    public LigaEspañola buscar(String name) throws IOException {
        
        for(LigaEspañola LE : this.lista){
            if(LE.getNameEquip().equals(name)){
                return LE;
            }
        }
        return null;
    }

    @Override
    public List<LigaEspañola> leer() throws IOException {
        return this.lista;
    }

    @Override
    public boolean escribir(LigaEspañola LE) throws IOException {
        
        return this.lista.add(LE);
    }
}

