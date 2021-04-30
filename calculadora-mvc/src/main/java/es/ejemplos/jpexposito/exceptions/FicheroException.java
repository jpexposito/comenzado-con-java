package es.ejemplos.jpexposito.exceptions;

public class FicheroException  extends Exception{
   private static final long serialVersionUID = 1L;   
   
   /**
    * Constructor con el mensaje personalizado
    * @param mensaje personalizado
    */
    public FicheroException (String mensaje) {
      super(mensaje);
   }

   /**
    * Constructor con el mensaje y la exception que se produce
    * @param mensaje de la excepcion
    * @param exception que produce el error
    */
   public FicheroException (String mensaje, Exception exception) {
      super(mensaje, exception);
   }

   
}
