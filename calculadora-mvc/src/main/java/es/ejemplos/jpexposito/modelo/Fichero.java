package es.ejemplos.jpexposito.modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import es.ejemplos.jpexposito.exceptions.FicheroException;


public class Fichero {
   
   private static final String SE_HA_PRODUCIDO_UN_ERROR_EN_EL_VOLCADO_DEL_FICHERO = "Se ha producido un error en el volcado del fichero";
   private static final String RETORNO_CARRO = "\n";
   private static final String NOMBRE_FICHERO = "fichero-operaciones.txt";
   
   
   /**
    * Funcion encargada de leer un ficher
    * 
    * @param nombre nombre del fichero a leer
    * @throws FicheroException Error controlado en la lectura del fichero
    */
   public String leer(String nombre) throws FicheroException {
      StringBuilder informacion = null;
      File fichero = null;
      Scanner scanner = null;

      try {
         fichero = new File(nombre);
         if (!validarFichero(fichero)) {
            throw new FicheroException("El fichero a leer no existe");
         }
         informacion = new StringBuilder();
         scanner = new Scanner(fichero);

         while (scanner.hasNextLine()) {
            String linea = scanner.nextLine();
            informacion.append(linea + RETORNO_CARRO);
         }
      } catch (FicheroException e) {  
            throw e;
      }catch (Exception e) {
            throw new FicheroException("Se ha producido un error en la lectura del fichero", e);
      } finally {
         if (scanner != null) {
            scanner.close();
         }
      }
      return informacion.toString();
   }

   /**
    * Metodo encargado de crear un fichero
    * @param nombre del fichero a crear
    * @throws FicheroException
    */
   public void almacenar(String nombre, String cadenaTexto) throws FicheroException {
      FileWriter fichero = null;
      try {
			fichero = new FileWriter(nombre, true);
         fichero.write(cadenaTexto);
		} catch (Exception ex) {
			throw new FicheroException(SE_HA_PRODUCIDO_UN_ERROR_EN_EL_VOLCADO_DEL_FICHERO, ex);
		} finally {
         if (fichero != null) {
            try {
               fichero.close();
            } catch (IOException e) {
               throw new FicheroException(SE_HA_PRODUCIDO_UN_ERROR_EN_EL_VOLCADO_DEL_FICHERO, e);
            }
         }
      }

   }

   /**
    * Funcion que verifica si el fichero existo
    * @param fichero
    * @return
    */
   public boolean validarFichero(File fichero) {
      return fichero.exists();
   }

    /**
    * Metodo encargado de elimianr un fichero/directorio
    * @param nombre del fichero/directorio a elimina
    * @throws FicheroException error controlado
    */
    public void eliminar(String nombre) throws FicheroException {
      File fichero = new File(nombre);
      if (validarFichero(fichero)) {
         fichero.delete();
      } else {
         throw new FicheroException("No se puede eliminar un fichero que no existe");
      }
      
   }

}
