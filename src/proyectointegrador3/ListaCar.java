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
    protected ArbolCaracter arbol;

    public ListaCar() {
        
    }

    public boolean vacio() {
        return inicio == null;
    }

    //busqueda por anchura
    public void bfs(NodoCar node) {
        int power =0;
        String binario="";
        ColaListaSimple str = new ColaListaSimple();
        ColaListaSimple cola = new ColaListaSimple();
        if (node == null) {
            return;
        }
        cola.enqueue(node);
        str.enqueue(binario);
        while (!cola.isEmpty()) {
            NodoCar nodo = (NodoCar)cola.dequeue();
            binario = (String)str.dequeue();
            System.out.print(nodo.getFreq());
            if (nodo.caracter != null)
                System.out.print("("+nodo.caracter.getCaracter()+"_"+binario+"_) ");
            else
                System.out.print("_");
            if (nodo.izquierda != null) {
                binario = binario+"0";
                cola.enqueue(nodo.izquierda);
                str.enqueue(binario);
            }
            if (nodo.derecha != null) {
                binario = binario+"1";
                cola.enqueue(nodo.derecha);
                str.enqueue(binario);
            }
            power++;
            
        }
    }
    
    //inicializa la generacion de arboles y la codificacion de huffman
    public void superbolize() {
        int cont = 0;
        
        //generando arbol desde nodos
        while (this.size > 1) {
            arbolize();
            cont++;
        }
        
        //transferencia de nodo(s) a arbol
        arbol = new ArbolCaracter(inicio);
        System.out.println(cont);
        System.out.println("Arbol generado");
        System.out.println(inicio.getFreq() + " es la frecuencia total sumada");
        Texto texto= new Texto();
        //codificacion de huffman
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
}
