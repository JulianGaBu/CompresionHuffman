/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Caracteres;

/**
 *
 * @author Julian
 */
public class NodoCar {

    protected int freq;
    protected NodoCar siguiente;
    protected NodoCar izquierda, derecha;
    protected Caracter caracter;

    public NodoCar() {
    }

//Constructores de Clonacion
    
    public NodoCar(NodoCar nc) {
        this.siguiente = nc.siguiente;
        this.izquierda = nc.izquierda;
        this.derecha = nc.derecha;
        this.caracter = nc.caracter;
        this.freq = nc.freq;
    }

    public NodoCar(NodoCar nc, NodoCar siguiente) {
        this.izquierda = nc.izquierda;
        this.derecha = nc.derecha;
        this.caracter = nc.caracter;
        this.freq = nc.freq;
        this.siguiente = siguiente;
    }

//Constructores de Lista Simple
    //solo caracter. genera frecuencia
    public NodoCar(Caracter caracter) {
        this.caracter = caracter;
        this.freq = caracter.getFrecuencias();
    }

//Constructores de Arbol
    //freq, izquierda, derecha
    public NodoCar(int freq, NodoCar izquierda, NodoCar derecha) {
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

    public NodoCar getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCar siguiente) {
        this.siguiente = siguiente;
    }

    public NodoCar getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoCar izquierda) {
        this.izquierda = izquierda;
    }

    public NodoCar getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoCar derecha) {
        this.derecha = derecha;
    }
}
