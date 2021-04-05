package es.ejemplos.jpexposito.exception;

public class AlumnoException extends Exception {

   private static final long serialVersionUID = 1L;
   public AlumnoException(String mensaje) {
      super(mensaje);
      }
   public AlumnoException(String mensaje, Exception causa) {
   super(mensaje, causa);
   } 
   
}
