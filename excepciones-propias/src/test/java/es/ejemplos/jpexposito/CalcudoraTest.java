package es.ejemplos.jpexposito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CalcudoraTest {

    Calculadora calculadora;

    @BeforeEach
    public void setUp() {
        if (calculadora == null) {
            calculadora = new Calculadora();
        }
    }

    @Test
    public void divisionOkTest(){
        int dividendo = 4;
        int divisor = 2;

        int resultado = calculadora.division(dividendo, divisor);
        assertEquals(2, resultado, "No se ha obtenido el valor esperado de la division");
    }

    @Test
    public void divisionPorCeroTest(){
        int dividendo = 4;
        int divisor = 0;

        int resultado = calculadora.division(dividendo, divisor);
        assertEquals(2, resultado, "No se ha obtenido el valor esperado de la division");
    }
}
