/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;

/**
 *
 * @author German
 */
public class LigaEspañola implements Comparable <LigaEspañola>, Serializable{
    private String nameEquip;
    private int pj;
    private int pg;
    private int pe;
    private int pp;
    private int points;

    public LigaEspañola() {
    }

    public LigaEspañola(String nameEquip, int pj, int pg, int pe, int pp, int points) {
        this.nameEquip = nameEquip;
        this.pj = pj;
        this.pg = pg;
        this.pe = pe;
        this.pp = pp;
        this.points=points;
    }

    public String getNameEquip() {
        return nameEquip;
    }

    public void setNameEquip(String nameEquip) {
        this.nameEquip = nameEquip;
    }

    public int getPj() {
        return pj;
    }

    public void setPj(int pj) {
        this.pj = pj;
    }

    public int getPg() {
        return pg;
    }

    public void setPg(int pg) {
        this.pg = pg;
    }

    public int getPe() {
        return pe;
    }

    public void setPe(int pe) {
        this.pe = pe;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    
    
    
    public String getDatosFileText(){ 
        
        return this.nameEquip+";"+
               this.pj+";"+ 
               this.pg+";"+ 
               this.pe+";"+ 
               this.pp+";"+
               this.points;
    }

    @Override
    public int compareTo(LigaEspañola L) {
        return L.points - this.points;
    }

 
}
