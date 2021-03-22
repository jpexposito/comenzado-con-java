package es.ejemplos.jpexposito.exception;

public class PasajeroExeption extends Exception {

   private static final long serialVersionUID = 1L;

   public PasajeroExeption(String mensaje) {
      super(mensaje);
   }

   public PasajeroExeption(String mensaje, Exception causa) {
      super(mensaje, causa);
   }

}
