package es.ejemplos.jpexposito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.ejemplos.jpexposito.elementos.Destino;
import es.ejemplos.jpexposito.elementos.Pasajero;
import es.ejemplos.jpexposito.exception.PasajeroExeption;



/**
 * Unit test for simple App.
 */
public class AgenciaTest 
{
    Agencia agencia;
    Pasajero pasajero;
    Destino destino;

    @BeforeEach
    public void setUp(){
        if (agencia == null) {
            agencia = new Agencia();
        }
        pasajero = crearPasajero("nombre", "apellidos", "00000000H");
        try {
            agencia.insertar(pasajero);
        } catch (PasajeroExeption e) {
            fail("Se ha inicializado de forma incorrecta la lista");
        }
    } 


    @Test
    public void existeTest(){
        assertTrue( agencia.existePasaje(pasajero), "No se ha encontrado el pasajero en la lista");
    }

    @Test
    public void noExistePasajeroTest(){
        assertFalse( agencia.existePasaje(new Pasajero("nombre", "apellidos", "11111111A")), "No se ha encontrado el pasajero en la lista");
    }

    public void existeDestinoTest(){
        assertTrue( agencia.existePasaje(pasajero), "No se ha encontrado el pasajero en la lista");
    }

    @Test
    public void noExisteDestinoTest(){
        assertFalse( agencia.existePasaje(new Pasajero("nombre", "apellidos", "11111111A")), "No se ha encontrado el pasajero en la lista");
    }

    private void insertarPasajero(Pasajero pasajero) throws PasajeroExeption {
        agencia.insertar(pasajero);
    }

    private Pasajero crearPasajero(String nombre, String apellidos, String dni) {
        return new Pasajero(dni, nombre, apellidos);
    }
}
