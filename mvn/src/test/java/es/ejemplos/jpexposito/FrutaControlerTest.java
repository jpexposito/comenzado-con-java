package es.ejemplos.jpexposito;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.ejemplos.jpexposito.api.Fruta;
import es.ejemplos.jpexposito.controlador.FrutaController;
import es.ejemplos.jpexposito.excepcion.FrutaException;

public class FrutaControlerTest extends UtilidadesTest{
   FrutaController frutaController;
   Fruta fruta;

    @BeforeEach
    public void setUp() {
        if (fruta == null) {
            fruta = generarfruta("identificador", "nombre", 1f, 1f);
        }
        if (frutaController == null) {
           frutaController = new FrutaController();
        }
    }

    @Test
    public void validarTest() {
      try {
         frutaController.validarFruta(fruta);
      } catch (FrutaException e) {
         fail("Se ha producido un error validando la fruta no controlado");
      }
    }


    

   
}
