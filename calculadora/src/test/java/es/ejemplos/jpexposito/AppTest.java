package es.ejemplos.jpexposito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    
    Suma suma;
    Resta resta;
    Division division;
    Multiplicacion multiplicacion;
    double numero1 = 2.0;
    double numero2 = 3.0;
    double resultado = 0.0;


    @BeforeEach
    public void setUp() {
        if (suma == null) {
            suma = new Suma(numero1,numero2);
        }
        if (resta == null) {
            resta = new Resta(numero1,numero2);
        }
        if (division == null) {
            division = new Division(numero1,numero2);
        }
        if (multiplicacion == null) {
            multiplicacion = new Multiplicacion(numero1,numero2);
        }
    }

    @Test
    public void SumaTest(){
        resultado = 5.0;
        assertEquals( suma.getResultado(), resultado, "El resultado de la operacion suma no es el esperado" );
    }

    @Test
    public void RestaTest(){
        resultado = -1.0;
        assertEquals( resta.getResultado(), resultado, "El resultado de la operacion resta no es el esperado" );
    }

    @Test
    public void MultiplicacionTest(){
        resultado = 6.0;
        assertEquals( multiplicacion.getResultado(), resultado, "El resultado de la operacion multiplicacion no es el esperado" );
    }

    @Test
    public void DivisionTest(){
        resultado = 0.6666666666666666;
        assertEquals( division.getResultado(), resultado, "El resultado de la operacion division no es el esperado" );
    }

    @Test
    public void DivisionPorCeroTest(){
        try {
            double cero = 0.0;
            division = new Division(numero1, cero);
            assertEquals(division.getResultado(), resultado, "El resultado de la operacion divion no es el esperado" );
        }catch(Exception e) {
            if (e instanceof ArithmeticException) {
                assertTrue(e.getMessage().contains("division por 0"));
            } else {
                fail("Se ha producido un error no esperado realizando la division");
            }
        }
        
    }
}
