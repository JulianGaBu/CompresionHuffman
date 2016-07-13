/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Caracteres;

import Controlador.Texto;

/**
 *
 * @author Julian
 */
public class ListaCar {

    protected NodoCar inicio;
    protected NodoCar ultimo;
    protected int size;
    protected ArbolCaracter arbol;

    public ListaCar() {
        
    }

    public boolean vacio() {
        return inicio == null;
    }

    public ArbolCaracter getArbol() {
        return arbol;
    }
    
    //inicializa la generacion de arboles y la codificacion de huffman
    public void superbolize() {
        
        //generando arbol desde nodos
        while (this.size > 1) {
            arbolize();
        }
        
        //transferencia de nodo(s) a arbol
        arbol = new ArbolCaracter(inicio);
        System.out.println("Arbol generado");
        System.out.println(inicio.getFreq() + " es la frecuencia total sumada");
        Texto texto= new Texto();
        //codificacion de huffman
        System.out.println("codificar");
        arbol.codificar();
        texto.comprimir(arbol);
    }
    
    //generacion de arbol desde nodo
    public void arbolize() {
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
