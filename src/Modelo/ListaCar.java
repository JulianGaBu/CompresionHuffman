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
public class ListaCar {

    protected NodoCar inicio;
    protected NodoCar ultimo;
    protected int size;

    public ListaCar() {
    }
    
    /**
     * inicializa la generacion de arboles y la codificacion de huffman
     * <p>
     * genera los arboles dentro de la lista misma, con cada nodo siendo una raiz
     */
    public void arbolize() {
        //generando arbol desde nodos
        while (this.size > 1) {
            NodoCar smallest, smaller, ncAux;
            int aux;
            smallest = new NodoCar(inicio);
            smaller = new NodoCar(inicio.siguiente);
            aux = smallest.getFreq() + smaller.getFreq();
            this.eliminaInicio();
            this.eliminaInicio();
            ncAux = new NodoCar(aux, smallest, smaller);
            insertaOrdenado(ncAux);
        }
        
        //transferencia de nodo(s) a arbol
        System.out.println("Arbol generado");
        System.out.println(inicio.getFreq() + " es la frecuencia total sumada");
    }
    
    /**
     * devuelve la raiz del arbol generado
     * @return el inicio de la lista
     */
    public NodoCar getArbolRaiz() {
        return inicio;
    }
    
//Inserciones a la lista
    public boolean vacio() {
        return inicio == null;
    }
    
    public void insertaInicio(NodoCar dato) {
        if (vacio()) {
            inicio = ultimo = new NodoCar(dato);
            size++;
        } else {
            inicio = new NodoCar(dato, inicio);
            size++;
        }
    }

    public void insertaOrdenado(NodoCar dato) {
        if (vacio()) {
            inicio = ultimo = new NodoCar(dato);
            size++;
        } else if (inicio == ultimo) {
            if (dato.getFreq() < inicio.getFreq()) {
                insertaInicio(dato);
            } else {
                insertaFinal(dato);
            }
        } else {

            NodoCar antes = null, actual = inicio;
            while (actual != null && dato.getFreq() > actual.getFreq()) {
                antes = actual;
                actual = actual.siguiente;
            }
            if (antes == null) {
                insertaInicio(dato);
            } else if (actual == null) {
                insertaFinal(dato);
            } else {
                NodoCar nuevo = new NodoCar(dato, actual);
                antes.setSiguiente(nuevo);
                size++;
            }
        }
    }

    public void insertaFinal(NodoCar dato) {
        if (vacio()) {
            inicio = ultimo = new NodoCar(dato);
            size++;
        } else {
            NodoCar temp = new NodoCar(dato);
            ultimo.setSiguiente(temp);
            ultimo = temp;
            size++;
        }
    }

    public NodoCar eliminaInicio() {
        NodoCar eliminado = null;
        if (vacio()) {
            System.out.println("Lista vacia");
        } else {
            eliminado = inicio;
            inicio = inicio.siguiente;
            size--;
        }
        return eliminado;
    }
}
