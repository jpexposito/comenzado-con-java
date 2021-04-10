package es.ejemplos.jpexposito;

import java.util.LinkedList;

import es.ejemplos.jpexposito.excepcion.FrutaException;


public class GestionLinkedList {

    private static final String LA_LISTA_SE_ENUENTRA_VACIA = "La lista se enuentra vacia";
    LinkedList<Fruta> lista;

    public GestionLinkedList() {
        lista = new LinkedList<>();
    }


    public LinkedList<Fruta> getLista() {
        return this.lista;
    }

    /**
     * Metodo que permite insertar al principio de la lista
     * @param fruta a insertar
     */
    public void insertarPrimera(Fruta fruta) {
        lista.addFirst(fruta);
    }

     /**
     * Metodo que permite insertar al final de la lista
     * @param fruta a insertar
     */
    public void insertarUltimo(Fruta fruta) {
        lista.addLast(fruta);
    }

    /**
     * Metodo que permite eliminar al final de la lista
     * @param fruta a eliminar
     * @throws FrutaException controlada
     */
    public void eliminarUltimo() throws FrutaException {
        if (lista.isEmpty()) {
            throw new FrutaException(LA_LISTA_SE_ENUENTRA_VACIA);
        }
        lista.removeLast();
    }

     /**
     * Metodo que permite eliminar al final de la lista
     * @param fruta a eliminar
     * @throws FrutaException controlada
     */
    public void eliminarPrimero() throws FrutaException {
        if (lista.isEmpty()) {
            throw new FrutaException(LA_LISTA_SE_ENUENTRA_VACIA);
        }
        lista.removeFirst();
    }

    @Override
    public String toString() {
        return lista.toString();
    }


}
