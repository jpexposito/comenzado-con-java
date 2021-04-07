package es.ejemplos.jpexposito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.ejemplos.jpexposito.elementos.Alumno;
import es.ejemplos.jpexposito.exception.AlumnoException;
import es.ejemplos.jpexposito.exception.FicheroException;


public class ClaseHasMapTest {

    private static final String NOMBRE_FICHERO_TXT = "nombreFichero.txt";
    ClaseHasMap clase;
    Fichero fichero;

    @BeforeEach
    public void setUp() {
        if (fichero == null) {
            fichero = new Fichero();
        }
        if (clase == null) {
            clase = new ClaseHasMap();
        }
        
        try {
            //fichero.eliminar(NOMBRE_FICHERO_TXT);
            clase.insertar(crearAlumnoTest());
        } catch (Exception e) {
            fail("Se ha producido un error en la inicializacion del test");
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
            clase.volcarAfichero(NOMBRE_FICHERO_TXT);
            String contenido = fichero.leer(NOMBRE_FICHERO_TXT);
            assertTrue(contenido.contains("test,test2"), "El fichero no contiene el alumno");
        } catch (FicheroException e) {
            fail("Error guardando el fichero de test");
        }
    }

    private Alumno crearAlumnoTest() {
        return new Alumno("test", "test2", 1);
    }
}
