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
    protected NodoCar raiz;

    public ArbolCaracter(NodoCar raiz) {
        this.raiz = raiz;
    }

    public ArbolCaracter() {
    }
    
    //ejecuta el recorrido del arbol y la busqueda del codigo
    public void codificar() {
        recorrerArbol(raiz, "");
    }
    
    //basdo en el recorrido original de Reyes(TM)
    public void recorrerArbol(NodoCar nodo, String codigo) {
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
    
    public ColaListaSimple getColaCaracteres(){
        return listCodigos;
    }
    
    
}
