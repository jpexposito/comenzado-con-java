package es.ejemplos.jpexposito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.ejemplos.jpexposito.elementos.Alumno;
import es.ejemplos.jpexposito.exception.AlumnoException;
import es.ejemplos.jpexposito.exception.FicheroException;

/**
 * Unit test for simple App.
 */
public class ClaseTest {

    Clase clase;

    @BeforeEach
    public void setUp() {
        if (clase == null) {
            clase = new Clase();
        }
        try {
            clase.insertar(crearAlumnoTest());
        } catch (AlumnoException e) {
            fail("Se ha producido un error al crear la lista de inicio");
        }
    }

    @Test
    public void insertarTestAlumno(){
        assertEquals(1, clase.alumnos.size(),
        "No se ha insertado correctamente el alumno" );
    }

    @Test
    public void insertarTestErrorAlumno(){
        try {
            clase.insertar(crearAlumnoTest());
        } catch (AlumnoException e) {
            assertTrue(e.getMessage().contains("ya se encuentra en la lista")); 
        }
    }

    @Test
    public void eliminarAlumnoTest(){
        clase.eliminar(1);
        assertTrue(clase.alumnos.isEmpty(), "No se ha eliminado correctamente");
    }

        @Test
    public void mostrarAlumnoTest(){
        assertTrue(clase.mostrarLista().contains("test"), "La lista no contiene el alumno correcto");
    }

    @Test
    public void volcarAficheroTest() {
        try {
            clase.volcarAfichero("nombreFichero.txt");
        } catch (FicheroException e) {
            fail("Error guardando el fichero de test");
        }
    }

    private Alumno crearAlumnoTest() {
        return new Alumno("test", "test", 1);
    }
}
