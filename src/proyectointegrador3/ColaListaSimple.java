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
public class ColaListaSimple implements Queue{
    
    protected ListaSimple queuelista;
    protected int cont;
    public ColaListaSimple(){
        queuelista = new ListaSimple();
    }

    @Override
    public void enqueue(Object dato) {
        queuelista.insertaFinal(dato);
        cont++;
    }

    @Override
    public Object dequeue() {
             Object eliminado;
        eliminado = queuelista.eliminaInicio();
        if(eliminado!=null){
            cont--;
            eliminado = ((Nodo)eliminado).getDato();
        }
        return eliminado;
    }

    @Override
    public int size() {
       return cont;
    }

    @Override
    public Object front() {
         Object frente = queuelista.getInicio();
        if(frente != null){
            frente = ((Nodo)frente).getDato();
        }
        return frente;
    }

    @Override
    public boolean isEmpty() {
        return queuelista.vacio();
    }
    
}
