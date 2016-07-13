/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Julian
 */
public class NodoCaracter {

    private int freq;
    protected NodoCaracter siguiente;
    protected NodoCaracter izquierda, derecha;
    protected Caracter caracter;

    public NodoCaracter() {
    }

//Constructores de Clonacion
    
    public NodoCaracter(NodoCaracter nc) {
        this.siguiente = nc.siguiente;
        this.izquierda = nc.izquierda;
        this.derecha = nc.derecha;
        this.caracter = nc.caracter;
        this.freq = nc.freq;
    }

    public NodoCaracter(NodoCaracter nc, NodoCaracter siguiente) {
        this.izquierda = nc.izquierda;
        this.derecha = nc.derecha;
        this.caracter = nc.caracter;
        this.freq = nc.freq;
        this.siguiente = siguiente;
    }

//Constructores de Lista Simple
    //solo caracter. genera frecuencia
    public NodoCaracter(Caracter caracter) {
        this.caracter = caracter;
        this.freq = caracter.getFrecuencias();
    }

//Constructores de Arbol
    //freq, izquierda, derecha
    public NodoCaracter(int freq, NodoCaracter izquierda, NodoCaracter derecha) {
        this.freq = freq;
        this.izquierda = izquierda;
        this.derecha = derecha;
    }
    
    public Caracter getCaracter() {
        return caracter;
    }

    public int getFreq() {
        return freq;
    }

    public NodoCaracter getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCaracter siguiente) {
        this.siguiente = siguiente;
    }

    public NodoCaracter getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoCaracter izquierda) {
        this.izquierda = izquierda;
    }

    public NodoCaracter getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoCaracter derecha) {
        this.derecha = derecha;
    }
}
