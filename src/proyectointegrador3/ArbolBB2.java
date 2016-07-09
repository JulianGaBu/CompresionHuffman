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
public class ArbolBB2 {

    protected NodoBin raiz;

    public ArbolBB2(NodoBin raiz) {
        this.raiz = raiz;
    }

    public ArbolBB2(Object o) {
        raiz = new NodoBin(o);
    }

    public void inOrden() {
        if (raiz != null) {
            raiz.inOrden();
        }
    }

    public void preOrden() {
        if (raiz != null) {
            raiz.preOrden();
        }
    }

    public void posOrden() {
        if (raiz != null) {
            raiz.posOrden();
        }
    }

    public void insertar(Object o) {
        insertarOrdenado(raiz, o);
    }

    public void insertarOrdenado(NodoBin n, Object o) {
        if ((Integer) o < (Integer) n.dato) {
            if (n.izquierda == null) {
                n.setIzquierda(new NodoBin(o));
                n.izquierda.setPadre(n);
            } else {
                insertarOrdenado(n.izquierda, o);
            }
        } else {
            if ((Integer) o > (Integer) n.dato) {
                if (n.derecha == null) {
                    n.setDerecha(new NodoBin(o));
                    n.derecha.setPadre(n);
                } else {
                    insertarOrdenado(n.derecha, o);
                }
            }
        }
    }

    public Object buscar(Object ob) {
        return buscarOrdenado(raiz, ob);
    }

    private Object buscarOrdenado(NodoBin n, Object ob) {
        if (n == null) {
            return null;
        }
        if ((int) n.getDato() == (int) ob) {
            return n;
        } else if ((int) ob > (int) n.getDato()) {
            return buscarOrdenado(n.derecha, ob);
        } else {
            return buscarOrdenado(n.izquierda, ob);
        }
    }

    public void eliminar(Object o) {
        NodoBin aux = (NodoBin) buscar(o);
        if (aux == null) {
            System.out.println("No se encontro el elemento");
        } else if (aux.getDerecha() == null && aux.getIzquierda() == null) {
            eliminarHojas(o, aux);
        } else {
            if (aux.getIzquierda() != null && aux.getDerecha() != null) {
                eliminarNodoBinario(o, aux);
            } else {
                if (aux.getIzquierda() != null) {
                    eliminarNodoUnario(o, aux);
                } else {
                    if (aux.getDerecha() != null) {
                        eliminarNodoUnario(o, aux);
                    }
                }
            }
        }
    }

    private void eliminarHojas(Object o, NodoBin aux) {
        if (aux.getPadre().getDerecha() != null && aux.padre.getDerecha().getDato() == o) {
            aux.padre.derecha = null;
        }
        if (aux.getPadre().getIzquierda() != null && aux.padre.getIzquierda().getDato() == o) {
            aux.padre.izquierda = null;
        }
    }

    private void eliminarNodoUnario(Object o, NodoBin aux) {

        if (aux.padre.getIzquierda() != null && aux.padre.getIzquierda().getDato() == o) {
            if (aux.getIzquierda() != null) {
                aux.padre.izquierda = aux.izquierda;
            } else {
                if (aux.getDerecha() != null) {
                    aux.padre.izquierda = aux.derecha;
                }
            }
        } else {
            if (aux.padre.getDerecha() != null && aux.padre.getDerecha().getDato() == o) {
                if (aux.getIzquierda() != null) {
                    aux.padre.derecha = aux.izquierda;
                } else {
                    if (aux.getDerecha() != null) {
                        aux.padre.derecha = aux.derecha;
                    }
                }
            }
        }
    }

    private void eliminarNodoBinario(Object o, NodoBin aux) {

        NodoBin menor = recorrerIzquierda(o, aux.derecha);
        Object dato = menor.getDato();
        eliminar(menor.getDato());
        aux.setDato(dato);
    }

    private NodoBin recorrerIzquierda(Object o, NodoBin aux) {
//        if(aux.getIzq()==null && aux.getDer()!=null)
//        {
//            boolean isleftMost= false;
//            while(aux.getDer()!=null)
//            return recorrerIzquierda(o, aux.der);
//        }
//      
//        if(aux.getIzq()!=null)
//        {
//            return recorrerIzquierda(o, aux.izq);
//        }
//        
//        if(aux.getIzq()==null && aux.getDer()==null)
//        {
//            return aux;
//        }
//        return null;
        NodoBin nodo;
        nodo = (NodoBin) bfs(aux);

        return nodo;

    }

    public Object bfs(NodoBin aux) {
        ColaListaSimple cola = new ColaListaSimple();
        Object restaurar = aux.getDato();
        NodoBin menor;
        menor = aux;
        menor.setDato(10000000);
        if (aux == null) {
            return null;
        }
        aux.setDato(restaurar);
        cola.enqueue(aux);
        while (!cola.isEmpty()) {
            NodoBin nodo = (NodoBin) cola.dequeue();
            if ((int) nodo.getDato() < (int) menor.getDato()) {
                menor = nodo;
            }
            if (nodo.getIzquierda() != null) {
                cola.enqueue(nodo.getIzquierda());
            }
            if (nodo.getDerecha() != null) {
                cola.enqueue(nodo.getDerecha());
            }
        }

        return menor;
    }

    public static void main(String[] args) {

//        ArbolBB arbol= new ArbolBB(12);
//        arbol.insertar(4);
//        arbol.insertar(23);
//        arbol.insertar(2);
//        arbol.insertar(10);
//        arbol.insertar(15);
//        arbol.insertar(37);
//        arbol.insertar(9); 
//        arbol.insertar(21);
//        arbol.insertar(32);
//        arbol.insertar(69);
//        arbol.insertar(6);
//       
//          ArbolBB arbol= new ArbolBB(62);
//          arbol.insertar(13);
//          arbol.insertar(72);
//          arbol.insertar(13);
//          arbol.insertar(6);
//          arbol.insertar(65);
//          arbol.insertar(76);
//          arbol.insertar(4);
//          arbol.insertar(8);
//          arbol.preOrden();
//          //Ssytem.out.println(arbol.buscar(65));
//          arbol.eliminar(72);
//          System.out.println("");
//          arbol.preOrden();
//          
//            ArbolBB arbol= new ArbolBB(50);
//            arbol.insertar(94);
//            arbol.insertar(97);
//            arbol.insertar(54);
//            arbol.insertar(31);
//            arbol.insertar(91);
//            arbol.insertar(69);
//            arbol.insertar(90);
//            arbol.insertar(85);
//            arbol.insertar(68);
//            arbol.insertar(92);
//            arbol.insertar(20);
//            arbol.insertar(15);
//            arbol.insertar(44);
//            arbol.insertar(96);
//            arbol.insertar(66);
//            arbol.insertar(55);
//            arbol.insertar(65);
//            arbol.insertar(36);
//            arbol.insertar(63);
//           // arbol.preOrden();
//            arbol.eliminar(50);
//            arbol.preOrden();

//this is a new funny comment :)
//test
        ArbolBB2 arbol = new ArbolBB2(15);
        arbol.insertar(11);
        arbol.insertar(21);
        arbol.insertar(9);
        arbol.insertar(10);
        arbol.insertar(6);
        arbol.insertar(16);
        arbol.insertar(19);
        arbol.insertar(23);
        arbol.insertar(22);
        arbol.insertar(18);
        arbol.insertar(20);
        arbol.insertar(24);
        arbol.insertar(25);
        arbol.insertar(26);
        arbol.eliminar(15);
        arbol.preOrden();
    }

}
