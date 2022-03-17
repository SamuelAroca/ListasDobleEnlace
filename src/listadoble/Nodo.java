package listadoble;

public class Nodo {
    private final int dato;
    Nodo anterior;
    Nodo siguiente;

    public Nodo(int elemento){
        dato = elemento;
        anterior = siguiente = null;
    }

    public int getDato() {
        return dato;
    }
}