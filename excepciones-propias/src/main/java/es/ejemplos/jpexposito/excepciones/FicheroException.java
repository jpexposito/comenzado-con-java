package es.ejemplos.jpexposito.excepciones;

public class FicheroException extends Exception {

   private static final long serialVersionUID = 1L;

   public FicheroException (String mensaje) {
      super(mensaje);
   }
   
   public FicheroException (String mensaje, Exception exception) {
      super(mensaje, exception);
   }

}
