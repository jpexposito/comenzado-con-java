package es.ejemplos.jpexposito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.ejemplos.jpexposito.exception.FicheroException;

public class FicheroTest {
   Fichero fichero = null;
   String nombreFichero = "ficheroPrueba.txt";
   String mensaFichero = "Esto es una prueba de contenido de fichero";

   @BeforeEach
   public void sepUp() {
      if (fichero == null) {
         fichero = new Fichero();
      }
      crearFichero();
   }

   @AfterEach
   public void after() {
      eliminar();
   }
   
   @Test
   public void ficheroNoExisteTest() {
      String nombreFichero = "ficheroNoExiste.txt";
      String texto = null;
      try {
         texto = fichero.leer(nombreFichero);
      } catch (FicheroException e) {
         boolean validar = e.getMessage().contains("El fichero a leer no existe");
         assertTrue(validar, "El programa no genera el error correcto");
      }catch (Exception e) {
         fail("El test (ficheroNoExisteTest) ha generado un error no controlado");
      }
   }

   @Test
   public void eliminarNoExisteTest() {
      String nombreFichero = "ficheroNoExiste.txt";
     
      try {
         fichero.eliminar(nombreFichero);
      } catch (FicheroException e) {
         boolean validar = e.getMessage().contains("No se puede eliminar un fichero que no existe");
         assertTrue(validar, "El programa no genera el error correcto");
      }catch (Exception e) {
         fail("El test (eliminarNoExisteTest) ha generado un error no controlado");
      }
   }

   @Test
   public void leerFicheroTest() {
      String texto = null;
      try {
         texto = fichero.leer(nombreFichero);
         boolean validar = texto.contains(mensaFichero);
         assertTrue(validar, "El programa no lee correctamente el fichero");
      } catch (Exception e) {
         fail("Se ha producido un error en el test leer fichero");
      }
   }

   @Test
   public void noEsDirectorioTest() {
      boolean directorio = fichero.esDirectorio(nombreFichero);
      assertFalse(directorio, "No funciona correctamente dado que es un fichero:"+nombreFichero);
   }

   @Test
   public void esDirectorioTest() {
      String nombreDirectorio = "src";
      boolean directorio = fichero.esDirectorio(nombreDirectorio);
      assertTrue(directorio, "No funciona correctamente dado que es un directorio:"+nombreDirectorio);
   }


 
   private void crearFichero() {
      try {
         fichero.crear(nombreFichero, mensaFichero);
      } catch (FicheroException e) {
         fail("Se ha producido un error en la escritura del fichero");
      }
   }

   private void eliminar() {
      try {
         fichero.eliminar(nombreFichero);
      } catch (FicheroException e) {
         fail("Se ha producido un error en la escritura del fichero");
      }
   }
}
