package es.ejemplos.jpexposito;

public class ProfesorException extends Exception {

   private static final long serialVersionUID = 1L;
   
   /**
    * Constructor por defecto
    * @param mensaje de error
    */
   public ProfesorException(String mensaje) {
      super(mensaje);
   }
   /**
    * Constructur con mensaje y causa
    * @param mensaje del error
    * @param causa del error
    */
   public ProfesorException(String mensaje, Exception causa) {
      super(mensaje, causa);
   }

}
