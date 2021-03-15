package es.ejemplos.jpexposito;

public class Suma extends Operacion{

   /**
    * Constructor de la clase 
    * @param numero1 de la operacion
    * @param numero2 de la operacion
    */
   public Suma(double numero1, double numero2) {
      super(numero1, numero2, '+');
      setResultado(numero1+numero2);
   }

   
}
