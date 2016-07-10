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
public class ListaCar {

    protected NodoCar inicio;
    protected NodoCar ultimo;

    public ListaCar() {
    }

    public boolean vacio() {
        return inicio == null;
    }
    
    public void superbolize(){
        System.out.println("probando");
        int cont = 0;
        while(!(inicio == ultimo)){
            arbolize();
            cont++;
        }
        System.out.println(cont);
        System.out.println("Arbol generado");
        System.out.println(inicio.getFreq()+" es la frecuencia total sumada");
    }
    
    public void arbolize(){
        NodoCar smallest, smaller, ncAux;
        int aux;
        if(vacio()){
            System.out.println("Lista de nodos vacia. Arbol no generado");
        } else if(inicio == ultimo) {
            System.out.println("Arbol generado");
            System.out.println(inicio.getFreq()+" es la frecuencia total sumada");
        }else{
            smallest = inicio;
            smaller = inicio.getSiguiente();
            aux = smallest.getFreq()+smaller.getFreq();
            ncAux = new NodoCar(aux,smallest,smaller);
            
            this.eliminaInicio();
            this.eliminaInicio();
            
            smallest.setPadre(ncAux);
            smaller.setPadre(ncAux);
            
            insertaOrdenado(new NodoCar(aux,smallest,smaller));
        }
    }

    public void insertaInicio(NodoCar dato) {

        if (vacio()) {
            inicio = ultimo = new NodoCar(dato);
        } else {
            inicio = new NodoCar(dato, inicio);
        }

    }

    public void insertaOrdenado(NodoCar dato) {
        
        if (vacio()) {
            inicio = ultimo = new NodoCar(dato);
        } else if (inicio == ultimo) {
            if (dato.getFreq() < inicio.getFreq()) {
                insertaInicio(dato);
            } else {
                insertaFinal(dato);
            }
        } else {
            System.out.println(inicio.getFreq()+" "+dato.getFreq());
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
            }
        }
    }

    public void insertaFinal(NodoCar dato) {

        if (vacio()) {
            inicio = ultimo = new NodoCar(dato);
        } else {
            NodoCar temp = new NodoCar(dato);
            ultimo.setSiguiente(temp);
            ultimo = temp;
        }

    }

    public NodoCar eliminaInicio() {

        NodoCar eliminado = null;
        if (vacio()) {
            System.out.println("Lista vacia");
        } else {
            eliminado = inicio;
            inicio = inicio.siguiente;
        }

        return eliminado;

    }

    public NodoCar eliminaFinal() {

        NodoCar eliminado = null;
        NodoCar anterior = null;
        NodoCar actual = inicio;

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

    public NodoCar getInicio() {
        return inicio;
    }

    public NodoCar getUltimo() {
        return ultimo;
    }

    public void setInicio(NodoCar inicio) {
        this.inicio = inicio;
    }

    public void setUltimo(NodoCar ultimo) {
        this.ultimo = ultimo;
    }

}
