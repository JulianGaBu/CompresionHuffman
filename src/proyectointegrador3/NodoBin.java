
package proyectointegrador3;

/**
 *Fecha de creacion: Lunes 27 de Junio de 2016
 * @author Rolando
 */
public class NodoBin {
    protected Object dato;
    protected NodoBin izquierda;
    protected NodoBin derecha;
    protected NodoBin padre;

    public NodoBin getPadre() {
        return padre;
    }

    public void setPadre(NodoBin padre) {
        this.padre = padre;
    }
    
    public NodoBin(Object dato, NodoBin izquierda, NodoBin derecha, NodoBin padre) {
        this.dato = dato;
        this.izquierda = izquierda;
        this.derecha = derecha;
        this.padre = padre;
    }
    
    public NodoBin(Object dato, NodoBin izquierda, NodoBin derecha) {
        this.dato = dato;
        this.izquierda = izquierda;
        this.derecha = derecha;
    }
 
    public NodoBin(Object dato) {
        this.dato = dato;
    } 
    
    public NodoBin() {
    }
        
        
//Metodos de busqueda
    public void inOrden() {
        if (izquierda != null) {
            izquierda.inOrden();
        }
        System.out.println(dato);
        if (derecha != null) {
            derecha.inOrden();
        }
    }

    public void preOrden() {
        System.out.println(dato);
        if (izquierda != null) {
            izquierda.preOrden();
        }
        if (derecha != null) {
            derecha.preOrden();
        }
    }

    public void posOrden() {
        if (izquierda != null) 
            izquierda.posOrden();
        
        if (derecha != null) 
            derecha.posOrden();
        
        System.out.println(dato);
    }
   
   
   
    /**
     * @return the dato
     */
    public Object getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(Object dato) {
        this.dato = dato;
    }

    /**
     * @return the izquierda
     */
    public NodoBin getIzquierda() {
        return izquierda;
    }

    /**
     * @param izquierda the izquierda to set
     */
    public void setIzquierda(NodoBin izquierda) {
        this.izquierda = izquierda;
    }

    /**
     * @return the derecha
     */
    public NodoBin getDerecha() {
        return derecha;
    }

    /**
     * @param derecha the derecha to set
     */
    public void setDerecha(NodoBin derecha) {
        this.derecha = derecha;
    }

        
    
}
