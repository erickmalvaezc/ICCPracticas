// Lista.java - mi propia implementacion de lista
public class Lista<T> {
    private Nodo<T> cabeza;
    private int tamaño;
    
    private class Nodo<T> {
        T dato;
        Nodo<T> siguiente;
        
        Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }
    
    public Lista() {
        this.cabeza = null;
        this.tamaño = 0;
    }
    
    public void agregar(T elemento) {
        Nodo<T> nuevo = new Nodo<>(elemento);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        tamaño++;
    }
    
    public T obtener(int indice) {
        if (indice < 0 || indice >= tamaño) {
            throw new IndexOutOfBoundsException("Indice esta fuera de rango");
        }
        
        Nodo<T> actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }
    
    public T eliminar(int indice) {
        if (indice < 0 || indice >= tamaño) {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
        
        if (indice == 0) {
            T dato = cabeza.dato;
            cabeza = cabeza.siguiente;
            tamaño--;
            return dato;
        }
        
        Nodo<T> actual = cabeza;
        for (int i = 0; i < indice - 1; i++) {
            actual = actual.siguiente;
        }
        
        T dato = actual.siguiente.dato;
        actual.siguiente = actual.siguiente.siguiente;
        tamaño--;
        return dato;
    }
    
    public int tamaño() {
        return tamaño;
    }
    
    public boolean estaVacia() {
        return tamaño == 0;
    }
    
    public void limpiar() {
        cabeza = null;
        tamaño = 0;
    }
}
