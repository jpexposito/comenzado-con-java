package es.ejemplos.jpexposito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.ejemplos.jpexposito.api.Fruta;

public class FrutaTest extends UtilidadesTest{

    Fruta fruta;

    @BeforeEach
    public void setUp() {
        if (fruta == null) {
            fruta = generarfruta("identificador", "nombre", 1f, 1f);
        }
    }


    @Test
    public void generarFrutaVacia() {
        Fruta fruta2 = generarfruta(null, null, 0, 0);
        assertNotNull( fruta2, "El objeto fruta no se ha generado correctament");
        assertTrue(fruta2.getIdentificador().contains(AA221), "Los valores del objeto fruta no son los adecuados");
        assertTrue(fruta2.getNombre().contains(NARANJA), "Los valores del objeto fruta no son los adecuados");
        assertEquals(fruta2.getCoste(), 0.90f, "Los valores del objeto fruta no son los adecuados");
        assertEquals(fruta2.getPrecio(), 1.5f, "Los valores del objeto fruta no son los adecuados");
    }

    @Test
    public void beneficioTest() {
        float resultado = 0f;
        resultado = fruta.beneficio();
        assertEquals(0f, resultado, "El resultado obtenido no es el");

    }
 
}
