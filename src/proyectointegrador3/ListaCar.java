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
    protected int size;

    public ListaCar() {
    }

    public boolean vacio() {
        return inicio == null;
    }

    public void bfs(NodoCar node) {
        ColaListaSimple cola = new ColaListaSimple();
        if (node == null) {
            return;
        }
        cola.enqueue(node);
        while (!cola.isEmpty()) {
            NodoCar nodo = (NodoCar) cola.dequeue();
            System.out.print(nodo.getFreq() + " ");
            if (nodo.getIzquierda() != null) {
                cola.enqueue(nodo.getIzquierda());
            }
            if (nodo.getDerecha() != null) {
                cola.enqueue(nodo.getIzquierda());
            }
        }
    }

    public void superbolize() {
        System.out.println("probando");
        int cont = 0;
        System.out.println("best" + this.size);
        while (this.size > 1) {
            arbolize();
            cont++;
        }
        System.out.println("Size:"+this.size);
        
        System.out.println(cont);
        System.out.println("Arbol generado");
        System.out.println(inicio.getFreq() + " es la frecuencia total sumada");
    }

    public void arbolize() {
        NodoCar smallest, smaller, ncAux;
        int aux;
        smallest = inicio;
        smaller = inicio.getSiguiente();
        aux = smallest.getFreq() + smaller.getFreq();
        System.out.println("freq: "+aux);
        ncAux = new NodoCar(aux, smallest, smallest);

        this.eliminaInicio();
        this.eliminaInicio();

        smallest.setPadre(ncAux);
        smaller.setPadre(ncAux);

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

    public void preorden() {
        inicio.preOrden();
    }

    public void insertaOrdenado(NodoCar dato) {

        if (vacio()) {
            inicio = ultimo = new NodoCar(dato);
            size++;
        } else if (inicio == ultimo) {
            if (dato.getFreq() < inicio.getFreq()) {
                System.out.println(dato.getFreq() + " <-In(Dato) " + inicio.getFreq());
                insertaInicio(dato);
            } else {
                System.out.println(inicio.getFreq() + " <-In " + dato.getFreq());
                insertaFinal(dato);
            }
        } else {

            NodoCar antes = null, actual = inicio;
            while (actual != null && dato.getFreq() > actual.getFreq()) {
                antes = actual;
                actual = actual.siguiente;
            }
            if (antes == null) {
                System.out.println("null " + dato.getFreq() + " " + actual.getFreq());
                insertaInicio(dato);
            } else if (actual == null) {
                System.out.println(antes.getFreq() + " " + dato.getFreq() + " null");
                insertaFinal(dato);
            } else {
                System.out.println(antes.getFreq() + " " + dato.getFreq() + " " + actual.getFreq());
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

    public NodoCar eliminaFinal() {

        NodoCar eliminado = null;
        NodoCar anterior = null;
        NodoCar actual = inicio;

        if (vacio()) {
            System.out.println("La lista esta vacia");
        } else if (actual.siguiente == null) {
            eliminado = inicio;
            inicio = null;
            size--;

        } else {
            while (actual.siguiente != null) {
                anterior = actual;
                actual = actual.siguiente;
            }
            eliminado = anterior.getSiguiente();
            anterior.setSiguiente(null);
            size--;
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
