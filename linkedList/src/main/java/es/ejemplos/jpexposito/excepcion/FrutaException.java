package es.ejemplos.jpexposito.excepcion;

public class FrutaException extends Exception {

   private static final long serialVersionUID = 1L;
   
   /**
    * Constructor de la exception con mensaje
    * @param mensaje descriptivo
    */
   public FrutaException(String mensaje) {
      super(mensaje);
   }

   /**
    * Constructor de la exception con mensaje
    * @param mensaje descriptivo
    * @param exception descriptiva
    */
   public FrutaException(String mensaje, Exception exception) {
      super(mensaje, exception);
   }


}
