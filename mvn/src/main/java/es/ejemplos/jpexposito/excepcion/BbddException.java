package es.ejemplos.jpexposito.excepcion;

public class BbddException extends Exception {
   private static final long serialVersionUID = 1L;

   /**
    * Constructor con el mensaje personalizado
    * @param mensaje personalizado
    */
    public BbddException (String mensaje) {
      super(mensaje);
   }

   /**
    * Constructor con el mensaje y la exception que se produce
    * @param mensaje de la excepcion
    * @param exception que produce el error
    */
   public BbddException (String mensaje, Exception exception) {
      super(mensaje, exception);
   }
}
