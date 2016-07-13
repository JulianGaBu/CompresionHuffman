/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author rodrigopeniche
 */
public class Caracter {
    String codigo;
    char caracter;
    int frecuencias;

    public Caracter() {
        
    }
    
    public Caracter(String codigo, char caracter, int frecuencias) {
        this.codigo = codigo;
        this.caracter = caracter;
        this.frecuencias = frecuencias;
    }
    
    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    public int getFrecuencias() {
        return frecuencias;
    }

    public void setFrecuencias(int frecuencias) {
        this.frecuencias = frecuencias;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
