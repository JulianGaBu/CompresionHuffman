/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Julian
 */
public final class ListaCaracter {

    private NodoCaracter inicio;
    private NodoCaracter ultimo;
    protected int size;

    public ListaCaracter(ArrayList<Caracter> caracteres) {
        this.enlistar(caracteres);
    }
    
    //convierte de arraylist de Caracteres a ListaCaracteres
    private void enlistar(ArrayList<Caracter> caracteres){
        for (int i = 0; i < caracteres.size(); i++) {
            insertaOrdenado(new NodoCaracter((Caracter) caracteres.get(i)));
        }
    }
    
    /**
     * inicializa la generacion de arboles y la codificacion de huffman
     * <p>
     * genera los arboles dentro de la lista misma, con cada nodo siendo una raiz
     */
    public void arbolize() {
        //generando arbol desde nodos
        while (this.size > 1) {
            NodoCaracter smallest, smaller, ncAux;
            int aux;
            smallest = new NodoCaracter(inicio);
            smaller = new NodoCaracter(inicio.siguiente);
            aux = smallest.getFreq() + smaller.getFreq();
            this.eliminaInicio();
            this.eliminaInicio();
            ncAux = new NodoCaracter(aux, smallest, smaller);
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
    public NodoCaracter getArbolRaiz() {
        return inicio;
    }
    
//Inserciones a la lista
    public boolean vacio() {
        return inicio == null;
    }
    
    public void insertaInicio(NodoCaracter dato) {
        if (vacio()) {
            inicio = ultimo = new NodoCaracter(dato);
            size++;
        } else {
            inicio = new NodoCaracter(dato, inicio);
            size++;
        }
    }

    public void insertaOrdenado(NodoCaracter dato) {
        if (vacio()) {
            inicio = ultimo = new NodoCaracter(dato);
            size++;
        } else if (inicio == ultimo) {
            if (dato.getFreq() < inicio.getFreq()) {
                insertaInicio(dato);
            } else {
                insertaFinal(dato);
            }
        } else {

            NodoCaracter antes = null, actual = inicio;
            while (actual != null && dato.getFreq() > actual.getFreq()) {
                antes = actual;
                actual = actual.siguiente;
            }
            if (antes == null) {
                insertaInicio(dato);
            } else if (actual == null) {
                insertaFinal(dato);
            } else {
                NodoCaracter nuevo = new NodoCaracter(dato, actual);
                antes.setSiguiente(nuevo);
                size++;
            }
        }
    }

    public void insertaFinal(NodoCaracter dato) {
        if (vacio()) {
            inicio = ultimo = new NodoCaracter(dato);
            size++;
        } else {
            NodoCaracter temp = new NodoCaracter(dato);
            ultimo.setSiguiente(temp);
            ultimo = temp;
            size++;
        }
    }

    public NodoCaracter eliminaInicio() {
        NodoCaracter eliminado = null;
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
