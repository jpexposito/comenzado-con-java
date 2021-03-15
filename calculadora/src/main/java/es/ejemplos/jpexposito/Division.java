package es.ejemplos.jpexposito;

public class Division extends Operacion{
   double cero = 0.0;
   /**
    * Constructor de la clase 
    * @param numero1 de la operacion
    * @param numero2 de la operacion
    */
   public Division(double numero1, double numero2) {
      super(numero1, numero2, '/');
      if (numero2 == cero) {
         throw new ArithmeticException("Se ha intentado realizar una division por 0");
      }
      setResultado(numero1/numero2);
   }

   
}
