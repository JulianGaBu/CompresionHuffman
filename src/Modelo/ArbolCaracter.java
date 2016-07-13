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
public class ArbolCaracter {
    ColaListaSimple listCodigos = new ColaListaSimple();
    protected NodoCaracter raiz;

    public ArbolCaracter(NodoCaracter raiz) {
        this.raiz = raiz;
    }

    public ArbolCaracter() {
    }
    
    /**
     * Ejecuta el recorrido del arbol recorrerArbol() y busca el codigo
     * 
     */
    public void codificar() {
        recorrerArbol(raiz, "");
    }
    
    /**
     * Recorre el arbol de izquierda a derecha
     * y guarda los codigos en Caracteres con su frecuencia y caracter
     * <p>
     * basado en el recorrido original de Reyes(TM)
     * @param nodo la raiz del arbol a recorrer
     * @param codigo el codigo que se va acumulando al recorrer el arbol recursivamente
     */
    public void recorrerArbol(NodoCaracter nodo, String codigo) {
        if (nodo.izquierda != null) {
            if (nodo.izquierda.caracter != null) {
                //si la hoja es caracter, la guarda
                listCodigos.enqueue(new Caracter(codigo+"0",nodo.izquierda.getCaracter().getCaracter(),nodo.izquierda.getFreq()));
            }
            recorrerArbol(nodo.izquierda, codigo+"0");
        }
        if (nodo.derecha != null) {
            if (nodo.derecha.caracter != null) {
                //si la hoja es caracter, la guarda
                listCodigos.enqueue(new Caracter(codigo+"1",nodo.derecha.getCaracter().getCaracter(),nodo.derecha.getFreq()));
            }
            recorrerArbol(nodo.derecha, codigo+"1");
        }
    }
    
    /**
     * @return la cola de Caracteres que contiene el codigo
     */
    public ColaListaSimple getColaCaracteres(){
        return listCodigos;
    }
    
    
}
