package es.ejemplos.jpexposito;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.ejemplos.jpexposito.api.Operacion;


public class OperacionTest extends UtilidadesTest{

    Operacion operacion;


    @BeforeEach
    public void setUp() {
        if (operacion == null) {
            operacion = new Operacion(numero1, numero2, operando);
        }
    }

    @Test
    public void contructorTest(){
        assertNotNull(operacion);
    }

    @Test
    public void toStringTest(){
        String cadena = operacion.toString();
        assertTrue(cadena.contains(String.valueOf(numero1)), "La cadena no continen el numero 1");
        assertTrue(cadena.contains(String.valueOf(numero2)), "La cadena no continen el numero 2");
        assertTrue(cadena.contains(String.valueOf(operando)), "La cadena no continen el operando");
    }
}
