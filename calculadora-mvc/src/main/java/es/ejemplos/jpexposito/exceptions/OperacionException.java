package es.ejemplos.jpexposito.exceptions;

public class OperacionException extends Exception{

   /**
    * Constructor con el mensaje del error
    * @param mensaje descriptivo
    */
   public OperacionException(String mensaje) {
      super(mensaje);
   }

   
}
