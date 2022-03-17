package listadoble;

import java.util.*;

public class ListasDobles {

    public static void main(String[] args) {
        Random r = new Random(1);

        int cantidad = Math.abs(r.nextInt(50));

        ListaDoble ld = new ListaDoble();

        for(int i=1; i<cantidad; i++)
            ld.insertarOrdenado(r.nextInt(200));

        ld.visualizar();

        IteradorLista il = new IteradorLista(ld);
        for (Nodo nodo = il.siguiente(); nodo != null; nodo = il.siguiente()) {
            int valor = nodo.getDato();
            if ( valor >= 50 && valor <= 150   ) {
                ld.eliminar(valor);
            }
        }
        ld.visualizar();
    }
}