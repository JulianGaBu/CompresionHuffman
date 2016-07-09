/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectointegrador3;

/**
 *
 * @author rodrigopeniche
 */
public abstract class Lista {
    
    protected Nodo inicio;
    protected Nodo ultimo;
    protected String nombre;
    
    public Lista()
    {
        this("lista");
    }
    
    public Lista(String nombre)
    {
        this.nombre= nombre;
    }
    
    public boolean vacio()
    {
        return inicio== null;
    }
    
    public abstract void insertaInicio(Object dato);
    public abstract void insertaFinal(Object dato);
    public abstract Object eliminaInicio();
    public abstract Object eliminaFinal();
    
    public void imprimir()
    {
        Nodo actual= inicio;
        while(actual!= null)
        {
            System.out.print(((Caracter)actual.getDato()).getCaracter()+ "->");
            actual= actual.siguiente;
        }
    }

    public Nodo getInicio() {
        return inicio;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
 }
