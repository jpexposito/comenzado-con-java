package es.ejemplos.jpexposito.excepciones;

public class NumeroExpcetion extends Exception {

   private static final long serialVersionUID = 1L;

   public NumeroExpcetion (String mensaje) {
      super(mensaje);
   }
   
   public NumeroExpcetion (String mensaje, Exception exception) {
      super(mensaje, exception);
   }

}
