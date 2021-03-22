package es.ejemplos.jpexposito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class TallerTest {

    Taller taller;
    String matricula;

    @BeforeEach
    public void SetUp() {
        if (taller ==  null) {
            taller = new Taller();
        }
        matricula = "1234FNI";
        taller.insertar(matricula);
    }


    @Test
    public void existeMatriculaTest(){

        boolean existe = taller.existe(matricula);
        assertTrue( existe, "La matricula no existe en la lista" );
    }

    @Test
    public void noExisteMatriculaTest(){
        matricula = "1111ABC";
        boolean existe = taller.existe(matricula);
        assertFalse( existe, "La matricula SI existe en la lista" );
    }

    @Test
    public void encontrarMatriculaTest(){
        String matriculaEncontrada = taller.buscar(matricula);
        assertEquals( matricula, matriculaEncontrada, "La matricula encontrada no es la esperada" );
    }

    @Test
    public void matriculaNoExontradaTest(){
        matricula = "1111ABC";
        String matriculaEncontrada = taller.buscar(matricula);
        assertNotEquals( matricula, matriculaEncontrada, "La matricula encontrada es igual" );
    }

}
