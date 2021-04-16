package es.ejemplos.jpexposito;

import java.io.File;
import java.io.IOException;

import es.ejemplos.jpexposito.excepciones.FicheroException;

public class Fichero {

   /**
    * Funcion encargada de verificar si un fichero existe
    * @param nombre del fichero
    * @return true/false
    */
   public boolean existe(String nombre) {
      boolean existeFichero = false;
      File file;

      file = new File(nombre);  
      existeFichero = file.exists();
      return existeFichero;
   }

   /**
    * Metodo encargado de crear un fichero
    * @param nombre del fichero
    * @throws FicheroException con error controlado
    */
    public void crearFichero(String nombre) throws FicheroException {
      File file;
      if (existe(nombre)) {
         throw new FicheroException("No se puede crear un fichero que ya existe");
      }
      file = new File(nombre);
      try {
         file.createNewFile();
      } catch (IOException exception) {
         throw new FicheroException("Se ha producido un error creando el fichero", exception);
      }
   }

   /**
    * Metodo encargado de borrar un fichero
    * @param nombre del fichero
    * @throws FicheroException con error controlado
    */
    public void borrarFichero(String nombre) throws FicheroException {
      File file;
      if (!existe(nombre)) {
         throw new FicheroException("No se puede borrar un fichero que no existe");
      }
      file = new File(nombre);
      file.delete();
   }
   
}
