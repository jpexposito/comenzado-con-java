package es.ejemplos.jpexposito;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.ejemplos.jpexposito.excepcion.FrutaException;

public class GestionLinkedListTest {
    private String colorDefecto = "Rojo";
    private int pesoDefecto = 17;

    private Fruta fruta1;
    private Fruta fruta2;

    GestionLinkedList gestionLinkedList;

    @BeforeEach
    public void setUp() {
        if (gestionLinkedList == null) {
            gestionLinkedList = new GestionLinkedList();
        }
        fruta1 = generarFruta("Verde", 15);
        fruta2 = generarFruta(null, 0);

        gestionLinkedList.insertarPrimera(fruta1);
        gestionLinkedList.insertarUltimo(fruta2);
    }

    @AfterEach
    public void after() {
        try {
            if (!gestionLinkedList.getLista().isEmpty()) {
                gestionLinkedList.eliminarUltimo();
                gestionLinkedList.eliminarPrimero();
            }

        } catch (FrutaException e) {
            fail("Se producido un error eliminando el contenido de la lista");
        }
        
    }


    @Test
    public void eliminarPrimerElementoListaVaciaTest() {
        gestionLinkedList.lista.clear();
        try {
            gestionLinkedList.eliminarPrimero();
        } catch (FrutaException e) {
            assertTrue(e.getMessage().contains("vacia"));
        }
    }

    @Test
    public void eliminarElementosTest() {
        
        try {
            gestionLinkedList.eliminarPrimero();
            gestionLinkedList.eliminarUltimo();
        } catch (FrutaException e) {
            fail("La lista no debe de estar vacia, debe de contener elementos");
        }
    }

    @Test
    public void eliminarUltimiElementoListaVaciaTest() {
        gestionLinkedList.getLista().clear();
        try {
            gestionLinkedList.eliminarUltimo();
        } catch (FrutaException e) {
            assertTrue(e.getMessage().contains("vacia"));
        }
    }

    @Test
    public void obtenerElementosTest() {
        String contenido = gestionLinkedList.toString();
        assertTrue(contenido.contains("15"),
         "No se ha obtenido la informacion de un elemento");
         assertTrue(contenido.contains("17"),
         "No se ha obtenido la informacion de un elemento");
    }

    /**
     * Funcion que permite generar una fruta por defecto
     * @param color de la fruta
     * @param peso de la fruta
     * @return Fruta con los valores por defecto o indicados
     */
    private Fruta generarFruta(String color, int peso) {
        Fruta fruta = null;

        if (color != null && peso > 0) {
            fruta = new Fruta(color, peso);
        } else {
            fruta = new Fruta();
            fruta.setColor(colorDefecto);
            fruta.setPeso(pesoDefecto);
        }
        return fruta;

    }
}
