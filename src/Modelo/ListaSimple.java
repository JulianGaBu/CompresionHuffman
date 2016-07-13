/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 */
public class ListaSimple extends Lista {

    @Override
    public void insertaInicio(Object dato) {

        if (vacio()) {
            inicio = ultimo = new Nodo(dato);
        } else {
            inicio = new Nodo(dato, inicio);
        }

    }

    @Override
    public void insertaFinal(Object dato) {

        if (vacio()) {
            inicio = ultimo = new Nodo(dato);
        } else {
            Nodo temp = new Nodo(dato);
            ultimo.setSiguiente(temp);
            ultimo = temp;
        }

    }

    @Override
    public Object eliminaInicio() {

        Object eliminado = null;
        if (vacio()) {
            System.out.println("Lista vacia");
        } else {
            eliminado = inicio;
            inicio = inicio.siguiente;
        }

        return eliminado;

    }

    @Override
    public Object eliminaFinal() {

        Object eliminado = null;
        Nodo anterior = null;
        Nodo actual = inicio;

        if (vacio()) {
            System.out.println("La lista esta vacia");
        } else if (actual.siguiente == null) {
            eliminado = inicio;
            inicio = null;

        } else {
            while (actual.siguiente != null) {
                anterior = actual;
                actual = actual.siguiente;
            }
            eliminado = anterior.getSiguiente();
            anterior.setSiguiente(null);
        }
        return eliminado;
    }

    public void insertaOrdenado(Object dato) {

        if (vacio()) {
            inicio = ultimo = new Nodo(dato);
        } else if (inicio == ultimo) {
            if (((Caracter) dato).getFrecuencias() < (int) ((Caracter) (inicio.getDato())).getFrecuencias()) {
                insertaInicio(dato);
            } else {
                insertaFinal(dato);
            }

        } else {
            Nodo antes = null, actual = inicio;
            while (actual != null && ((Caracter) dato).getFrecuencias() > ((Caracter) actual.getDato()).getFrecuencias()) {
                antes = actual;
                actual = actual.siguiente;
            }
            if (antes == null) {
                insertaInicio(dato);
            } else if (actual == null) {
                insertaFinal(dato);
            } else {
                Nodo nuevo = new Nodo(dato, actual);
                antes.setSiguiente(nuevo);
            }
        }
    }

    public boolean buscarElemento(Object dato) {
        if (vacio()) {
            return false;
        } else {
            Nodo actual = inicio;
            while (actual.siguiente != null) {

                if ((int) dato == (int) actual.dato) {
                    return true;

                }

                actual = actual.siguiente;
            }
            return false;
        }
    }

    public boolean eliminar(Object dato) {
        if (vacio()) {
            return false;
        } else if (inicio == ultimo && (int) dato == (int) inicio.getDato()) { //Solo hay un eleento dentro de la lista
            inicio = ultimo = null;
            return true;
        } else {
            Nodo antes = null, actual = inicio;
            while (actual != null && (int) dato != (int) actual.getDato()) {
                antes = actual;
                actual = actual.siguiente;
            }
            if (antes == null) {
                eliminaInicio();
                return true;
            } else if (actual == null && (int) antes.getDato() == (int) dato) {
                eliminaFinal();
                return true;
            } else if (actual == null) {
                return false;
            } else {
                antes.setSiguiente(actual.siguiente);
                return true;
            }
        }
    }

}
