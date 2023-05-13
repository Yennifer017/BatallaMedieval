
package linkedlist;

import java.io.Serializable;

/**
 *
 * @author yenni
 * @param <T>
 */
public class NodoGenerico<T> implements Serializable {
    private T contenido;
    private NodoGenerico<T> siguiente;
    
    public NodoGenerico(T contenido){
        this.contenido = contenido;
    }

    public T getContenido() {
        return contenido;
    }

    public void setContenido(T contenido) {
        this.contenido = contenido;
    }

    public NodoGenerico<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoGenerico<T> siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
}
