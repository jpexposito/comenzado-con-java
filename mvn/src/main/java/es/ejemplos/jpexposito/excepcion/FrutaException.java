package es.ejemplos.jpexposito.excepcion;

public class FrutaException extends Exception {
   private static final long serialVersionUID = 1L;

   /**
    * Constructor con el mensaje personalizado
    * @param mensaje personalizado
    */
    public FrutaException (String mensaje) {
      super(mensaje);
   }

   /**
    * Constructor con el mensaje y la exception que se produce
    * @param mensaje de la excepcion
    * @param exception que produce el error
    */
   public FrutaException (String mensaje, Exception exception) {
      super(mensaje, exception);
   }
}
