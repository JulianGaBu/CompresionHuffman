/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectointegrador3;

/**
 *
 * @author Julian
 */
public class NodoCar {
    
    

    
    protected int freq;
    protected NodoCar siguiente;
    
    protected NodoCar izquierda, derecha, padre;
    
    protected Caracter caracter;

    public NodoCar(){
    }
    public NodoCar(NodoCar nc){
        this.siguiente = nc.siguiente;
        this.izquierda = nc.izquierda;
        this.derecha = nc.derecha;
        this.padre = nc.padre;
        this.caracter = nc.caracter;
        this.freq = nc.freq;
    }
    
    public NodoCar(NodoCar nc, NodoCar siguiente){
        this.izquierda = nc.izquierda;
        this.derecha = nc.derecha;
        this.padre = nc.padre;
        this.caracter = nc.caracter;
        this.freq = nc.freq;
        this.siguiente = siguiente;
    }
    
    public void preOrden() {
        System.out.println(freq);
        if (izquierda != null) {
            izquierda.preOrden();
        }
        if (derecha != null) {
            derecha.preOrden();
        }
    }
    
//Constructores de Lista Simple
        //solo frecuencia
        public NodoCar(int freq) {
            this.freq = freq;
        }

        //solo caracter. genera frecuencia
        public NodoCar(Caracter caracter){
            this.caracter = caracter;
            this.freq = caracter.getFrecuencias();
        }

        //frecuencia y NodoCar siguiente
        public NodoCar(int freq, NodoCar siguiente) {
            this.freq = freq;
            this.siguiente = siguiente;
        }

        //caracter y NodoCar siguiente. genera frecuencia
        public NodoCar(Caracter caracter, NodoCar siguiente){
            this.caracter = caracter;
            this.freq = caracter.getFrecuencias();
            this.siguiente = siguiente;
        }
    
//Constructores de Arbol
        //caracter, izquierda, derecha
        public NodoCar(Caracter caracter, NodoCar izquierda, NodoCar derecha) {
            this.caracter = caracter;
            this.freq = caracter.getFrecuencias();
            this.izquierda = izquierda;
            this.derecha = derecha;
        }
        
        //caracter, izquierda, derecha, padre
        public NodoCar(Caracter caracter, NodoCar izquierda, NodoCar derecha, NodoCar padre) {
            this.caracter = caracter;
            this.freq = caracter.getFrecuencias();
            this.izquierda = izquierda;
            this.derecha = derecha;
            this.padre = padre;
        }
        
        //freq, izquierda, derecha
        public NodoCar(int freq, NodoCar izquierda, NodoCar derecha) {
            this.freq = freq;
            this.izquierda = izquierda;
            this.derecha = derecha;
        }

        //freq, izquierda, derecha, padre
        public NodoCar(int freq, NodoCar izquierda, NodoCar derecha, NodoCar padre) {
            this.freq = freq;
            this.izquierda = izquierda;
            this.derecha = derecha;
            this.padre = padre;
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

    public NodoCar getPadre() {
        return padre;
    }

    public void setPadre(NodoCar padre) {
        this.padre = padre;
    }
}
