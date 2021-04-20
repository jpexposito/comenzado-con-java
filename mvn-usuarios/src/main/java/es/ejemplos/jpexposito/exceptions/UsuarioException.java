package es.ejemplos.jpexposito.exceptions;

public class UsuarioException extends Exception {

   /**
    * Constructor de la exception con el parametro mensaje
    * @param mensaje descriptivo del error
    */
   public UsuarioException(String mensaje) {
      super(mensaje);
   }
}
