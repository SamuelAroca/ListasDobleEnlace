package listadoble;

public class ListaDoble {
    Nodo cabeza;

    public ListaDoble() {
        cabeza = null;
    }

    public void insertarCabeza(int elemento) {
        Nodo nuevo = new Nodo(elemento);
        nuevo.siguiente = cabeza;
        if (cabeza != null) {
            cabeza.anterior = nuevo;
        }
        cabeza = nuevo;
    }

    public void insertarOrdenado(int elemento) {
        Nodo actual = cabeza;
        if (actual != null) {
            if (actual.getDato() == elemento)
                return;
            if (actual.getDato() > elemento) {
                insertarCabeza(elemento);
                return;
            }
            for (; actual.siguiente != null; actual=actual.siguiente) {
                if (actual.siguiente.getDato() == elemento)
                    return;
                if (actual.siguiente.getDato() > elemento)
                    break;
            }
            Nodo nuevo = new Nodo(elemento);
            nuevo.siguiente = actual.siguiente;
            nuevo.anterior = actual;
            if (actual.siguiente != null)
                actual.siguiente.anterior = nuevo;
            actual.siguiente = nuevo;
        } else {
            insertarCabeza(elemento);
        }
    }

    public void eliminar(int elemento) {
        for (Nodo actual = cabeza; actual != null && actual.getDato() <= elemento; actual=actual.siguiente){
            if (elemento == actual.getDato()){
                if (actual.anterior != null) {
                    actual.anterior.siguiente = actual.siguiente;
                    //actual.siguiente.anterior = actual.anterior;
                    //return;
                }else {//Es el primero de la lista
                    cabeza = actual.siguiente;
                }
                if (actual.siguiente != null){//no es el ultimo
                    actual.siguiente.anterior = actual.anterior;
                }
                return;
            }
        }
    }

    public void visualizar() {
        int k = 0;
        for (Nodo actual = cabeza; actual != null; actual=actual.siguiente) {
            if (k++ % 15 == 0) {
                System.out.println();
            }
            System.out.printf(" %3d", actual.getDato());
        }
    }
}