
package linkedlist;

import excepciones.ListaException;
import java.io.Serializable;

/**
 *
 * @author yenni
 * @param <T>
 */
public class LinkedListY<T> implements Serializable{
    private NodoGenerico<T> inicio, ultimo;
    private int size = 0;
    
    public void add(T dato){
        NodoGenerico<T> nuevo = new NodoGenerico<>(dato);
        if (estaVacia()) {
            inicio = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
        size++;
    }
    //ARREGLAR ESTOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
    public void add(T dato, int indice) throws ListaException{
        /*if (indice < 0 || indice >= size) {
            throw new ListaException("Indice fuera de rango");
        }
        if (size == 1 || indice == size - 1) {
            eliminarUltimo();
        } else if (indice == 0) {
            inicio = inicio.getSiguiente();
            size--;
        } else {
            NodoGenerico nodoAnterior = obtenerNodo(indice - 1);
            NodoGenerico nodoAEliminar = nodoAnterior.getSiguiente();
            nodoAnterior.setSiguiente(nodoAEliminar.getSiguiente());
            size--;
        }*/
    }
    
    
    public void eliminarUltimo() throws ListaException {
    if (estaVacia()) {
        throw new ListaException("La lista está vacía");
    }
    if (size == 1) {
        inicio = null;
        ultimo = null;
        size = 0;
    } else {
        int penultimoIndice = size - 2;
        NodoGenerico<T> penultimo = obtenerNodo(penultimoIndice);
        penultimo.setSiguiente(null);
        ultimo = penultimo;
        size--;
    }
    }

    public T getContenido(int indice) throws ListaException {
        return obtenerNodo(indice).getContenido();
    }
    
    public boolean estaVacia() {
        return inicio == null;
    }
    
    public int getSize() {
        return size;
    }

    public void eliminar(int indice) throws ListaException {
        if (indice < 0 || indice >= size) {
            throw new ListaException("Indice fuera de rango");
        }
        if (size == 1 || indice == size - 1) {
            eliminarUltimo();
        } else if (indice == 0) {
            inicio = inicio.getSiguiente();
            size--;
        } else {
            NodoGenerico nodoAnterior = obtenerNodo(indice - 1);
            NodoGenerico nodoAEliminar = nodoAnterior.getSiguiente();
            nodoAnterior.setSiguiente(nodoAEliminar.getSiguiente());
            size--;
        }
    }
    
    private NodoGenerico<T> obtenerNodo(int indice) throws ListaException {
        if (estaVacia()) {
            throw new ListaException("La lista está vacía");
        }
        
        if (indice < 0 || indice >= size) {
            throw new ListaException("Indice fuera de rango");
        }
        
        NodoGenerico<T> nodoActual = inicio;
        for (int i = 0; i < indice; i++) {
            NodoGenerico siguiente = nodoActual.getSiguiente();
            nodoActual = siguiente;
        }
        return nodoActual;
    }
    public void verContent(){
        System.err.println(getSize() + "elementos guardados");
        for (int i = 0; i < this.getSize(); i++) {
            try {
                System.err.println(this.getContenido(i).toString());
            } catch (Exception e) {
                
            }
        }
    }
    
}
