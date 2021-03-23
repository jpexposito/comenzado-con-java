package es.ejemplos.jpexposito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.ejemplos.jpexposito.elementos.Destino;
import es.ejemplos.jpexposito.elementos.Pasajero;
import es.ejemplos.jpexposito.exception.DestinoException;
import es.ejemplos.jpexposito.exception.PasajeroExeption;


public class AgenciaTest 
{
    Agencia agencia;
    Pasajero pasajero;
    Destino destino;
    String ciudad1;
    String ciudad2;
    String pais;
    @BeforeEach
    public void setUp(){
        if (agencia == null) {
            agencia = new Agencia();
        }
        ciudad1 = "Liverpool";
        ciudad2 = "Manchester";
        pais = "Inglaterra";
        try {
            pasajero = crearPasajero("00000000H", "nombre", "apellidos", ciudad1);
            agencia.insertar(pasajero);
        } catch (PasajeroExeption e) {
            fail("Se ha inicializado de forma incorrecta la lista Pasajeros");
        }
        destino = crearDestino(pais, ciudad1);
        try {
            agencia.insertar(destino);
        } catch (DestinoException e) {
            fail("Se ha inicializado de forma incorrecta la lista destinos");
        }
    } 


    @Test
    public void existeTest(){
        assertTrue( agencia.existePasaje(pasajero), "No se ha encontrado el pasajero en la lista");
    }

    @Test
    public void noExistePasajeroTest(){
        try {
            Pasajero  pasajeroNoExiste = crearPasajero("11111111A", "nombre", "apellidos", "ciudad");
            assertFalse( agencia.existePasaje(pasajeroNoExiste), "Se ha encontrado el pasajero en la lista");
        } catch (PasajeroExeption e) {
            fail("Se ha producido un error generando el pasajero");
        }
    }

    @Test
    public void existeDestinoTest(){
        assertTrue( agencia.existeDestino(destino), "No se ha encontrado el destino en la lista");
    }

    @Test
    public void noExisteDestinoTest(){
        assertFalse( agencia.existeDestino(crearDestino(pais, ciudad2)), "Se ha encontrado el destino en la lista");
    }

    @Test
    public void listaCiudadesTest() {
        ArrayList<String> listaCiudades;
        
        try {
            Pasajero pasajero2 = crearPasajero("00000000H", "nombre", "apellidos", ciudad2);
            agencia.insertar(pasajero2);
            listaCiudades = agencia.listaCiudadas(pasajero.getDni());
            assertEquals(2, listaCiudades.size(), "La lista no contiene la tamanio correcto");

        } catch (PasajeroExeption e) {
            fail("Se ha producido un error generando el pasajero");
        }
    }

    @Test
    public void paisesViajaPasajeroTest() {
        
        try {
            Destino destino2 = crearDestino("Irlanda", "Dublin");
            agencia.insertar(destino2);
            Pasajero pasajero2 = crearPasajero("00000000H", "nombre", "apellidos", "Dublin");
            agencia.insertar(pasajero2);
            ArrayList<String> paises = agencia.paisesPasajero("00000000H");
            assertEquals(2,paises.size(), "El numero de paises es incorrecto");

        } catch (PasajeroExeption e) {
            fail("Se ha producido un error generando el pasajero");
        } catch (DestinoException e) {
            fail("Se ha producido un error generando el destino");
        } 
    }

    @Test
    public void viajerosEnPaisTest() {
        int cantidad = 0;
        try {
            Destino destino2 = crearDestino(pais, ciudad2);
            agencia.insertar(destino2);
            Pasajero pasajero2 = crearPasajero("00000000H", "nombre", "apellidos", ciudad2);
            agencia.insertar(pasajero2);
            cantidad = agencia.pasajetosEnPais(pais);
            assertEquals(2,cantidad, "El numero de pasajeros/viajero es incorrecto");

        } catch (PasajeroExeption e) {
            fail("Se ha producido un error generando el pasajero");
        } catch (DestinoException e) {
            fail("Se ha producido un error generando el destino");
        } 
    }

    private Pasajero crearPasajero( String dni, String nombre, String apellidos, String ciudad) throws PasajeroExeption {
        return new Pasajero(dni, nombre, apellidos, ciudad);
    }

    private Destino crearDestino(String pais, String ciudad) {
        return new Destino(pais, ciudad);
    }
}
