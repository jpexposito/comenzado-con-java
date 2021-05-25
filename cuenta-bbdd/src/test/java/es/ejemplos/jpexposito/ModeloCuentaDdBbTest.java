package es.ejemplos.jpexposito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.ejemplos.jpexposito.api.Cuenta;
import es.ejemplos.jpexposito.exception.PersistenciaException;
import es.ejemplos.jpexposito.modelo.CuentaModelo;

public class ModeloCuentaDdBbTest {

    static CuentaModelo cuentaModelo;
    Cuenta cuenta = null;

    @BeforeAll 
    public static void beforeAll() {
        if (cuentaModelo == null) {
            try {
                cuentaModelo = new CuentaModelo();
            } catch (Exception e) {
                fail("Se ha producido un error en el indicio de la BBDD");
            }
           
        }
    }

    @BeforeEach
    public void crearCuenta() {
        cuenta = new Cuenta("1", "1", "aaa@gmail.com", 5.0);
        try {
            cuentaModelo.insertar(cuenta);
        } catch (PersistenciaException e) {
            fail("Se ha producido un error insertando la cuenta");
        }
    }

    @AfterEach
    public void eliminarCuenta() {
        if (cuenta != null) {
            try {
                cuentaModelo.eliminar(cuenta);
            } catch (PersistenciaException e) {
                fail("Se ha producido un error eliminando la cuenta");
            }
        }
    }

    @Test
    public void buscarCuentaTest(){
        try {
            Cuenta cuentaEncontrada = cuentaModelo.buscar(cuenta.getCodigo());
            assertNotNull(cuentaEncontrada, "No se debe de obtener un elemento nulo");
            assertEquals(cuenta, cuentaEncontrada, "No se ha encontrado lo esperado");
        } catch (PersistenciaException e) {
           fail("Se ha producido un error en la consulta del la cuenta,e:"+e.getMessage());
        }
    }

    @Test
    public void actualizarCuentaTest(){
        try {
            Cuenta cuentaEncontrada = cuentaModelo.buscar(cuenta.getCodigo());
            assertNotNull(cuentaEncontrada, "No se debe de obtener un elemento nulo");
            cuentaEncontrada.setCliente("Pepe");
            cuentaModelo.actualizar(cuentaEncontrada);
            Cuenta cuentaActualziada = cuentaModelo.buscar(cuentaEncontrada.getCodigo());
            assertEquals(cuentaActualziada, cuentaEncontrada, "No se ha encontrado lo esperado");
        } catch (PersistenciaException e) {
           fail("Se ha producido un error en la consulta del la cuenta,e:"+e.getMessage());
        }
    }
}
