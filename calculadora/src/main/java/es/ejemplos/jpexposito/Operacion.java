package es.ejemplos.jpexposito;

public class Operacion {
    
   private double numero1;
   private double numero2;
   private double resultado;
   private char operando;

   /**
    * Constructori por defecto para todas las operaciones
    * @param numero1 de la operacion
    * @param numero2 de la operacion
    * @param op de la operacion
    */
   public Operacion(double numero1, double numero2, char op) {
       
       this.numero1 = numero1;
       this.numero2 = numero2;
       this.operando = op;

   }

   public double getResultado() {
      return this.resultado;
   }

   public void setResultado(double resultado) {
      this.resultado = resultado;
   }   
   
   /**
    * Funcion toString que muestra los numeros + operando + resultado
    */
   @Override    
   public String toString(){
      return this.numero1+" "+this.operando+" "+this.numero2+" = "+this.resultado;
   }
}