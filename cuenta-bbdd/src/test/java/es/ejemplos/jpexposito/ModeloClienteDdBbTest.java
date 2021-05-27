package es.ejemplos.jpexposito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.ejemplos.jpexposito.api.Cliente;
import es.ejemplos.jpexposito.api.Cuenta;
import es.ejemplos.jpexposito.exception.PersistenciaException;
import es.ejemplos.jpexposito.modelo.ClienteModelo;
import es.ejemplos.jpexposito.modelo.CuentaModelo;

public class ModeloClienteDdBbTest {

    static ClienteModelo clienteModelo;
    Cliente cliente = null;

    @BeforeAll 
    public static void beforeAll() {
        if (clienteModelo == null) {
            try {
                clienteModelo = new ClienteModelo();
            } catch (Exception e) {
                fail("Se ha producido un error en el indicio de la BBDD");
            }
           
        }
    }

    @BeforeEach
    public void crearCuenta() {
        try {
        cliente = new Cliente("11111111T","Juan",1);
            clienteModelo.insertar(cliente);
        } catch (PersistenciaException e) {
            fail("Se ha producido un error insertando la cliente");
        }
    }

    @AfterEach
    public void eliminarCuenta() {
        if (cliente != null) {
            try {
                clienteModelo.eliminar(cliente);
            } catch (PersistenciaException e) {
                fail("Se ha producido un error eliminando la cliente");
            }
        }
    }

    @Test
    public void buscarCuentaTest(){
        try {
            Cliente clienteEncontrado = clienteModelo.buscar(cliente.getDni());
            assertNotNull(clienteEncontrado, "No se debe de obtener un elemento nulo");
            assertEquals(cliente, clienteEncontrado, "No se ha encontrado lo esperado");
        } catch (PersistenciaException e) {
           fail("Se ha producido un error en la consulta del la cliente,e:"+e.getMessage());
        }
    }

    @Test
    public void actualizarCuentaTest(){
        try {
            Cliente clienteEncontrado = clienteModelo.buscar(cliente.getDni());
            assertNotNull(clienteEncontrado, "No se debe de obtener un elemento nulo");
            clienteEncontrado.setNombre("Pepe 2");
            clienteModelo.actualizar(clienteEncontrado);
            Cliente clienteActualziado = clienteModelo.buscar(clienteEncontrado.getDni());
            assertEquals(clienteActualziado, clienteEncontrado, "No se ha encontrado lo esperado");
        } catch (PersistenciaException e) {
           fail("Se ha producido un error en la consulta del la cliente,e:"+e.getMessage());
        }
    }
}
