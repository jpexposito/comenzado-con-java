package es.ejemplos.jpexposito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.ejemplos.jpexposito.modelo.Fichero;

public class FicheroTest {

   Fichero fichero;
   String cadena = "Hola soy un ejemplo";
   String nombreFichero = "ficheroEjemplo.txt";

   @BeforeEach
   public void setUp() {
      if (fichero == null) {
         fichero = new Fichero();
      }
      try {
         fichero.almacenar(nombreFichero, cadena);
      } catch (Exception e) {
         fail("Se ha producido un error almancenando informacion en el fichero");
      }
   }

   @AfterEach
   public void alfer() {
      if (fichero != null) {
         try {
            fichero.eliminar(nombreFichero);
         } catch (Exception e) {
            fail("Se ha producido un error eliminando el fichero");

         }
      }
   }

@Test
public void leerFicheroTest() {
   String informacion = null;

   try {
      informacion = fichero.leer(nombreFichero);
   } catch (Exception e) {
      fail("Se ha producido un error durante la lectura informacion en el fichero");

   }

   assertTrue(informacion.contains(cadena), "No se ha obtenido la informacion esperada");
}  
   
}
