package es.ejemplos.jpexposito.api;

public class Operacion {
   private static final String DELIMINARTOR = " ";
   private double numero1;
   private double numero2;
   private double resultado;
   private char operando;

   /**
    * Constructor por defecto
    */
   public Operacion() {}

   /**
    * Constructori por defecto para todas las operaciones
    * @param numero1 de la operacion
    * @param numero2 de la operacion
    * @param operando de la operacion
    */
   public Operacion(double numero1, double numero2, char operando) {
       
       this.numero1 = numero1;
       this.numero2 = numero2;
       this.operando = operando;

   }

   public double getResultado() {
      return this.resultado;
   }

   public void setResultado(double resultado) {
      this.resultado = resultado;
   }   
   

   public double getNumero1() {
      return this.numero1;
   }

   public void setNumero1(double numero1) {
      this.numero1 = numero1;
   }

   public double getNumero2() {
      return this.numero2;
   }

   public void setNumero2(double numero2) {
      this.numero2 = numero2;
   }

   public char getOperando() {
      return this.operando;
   }

   public void setOperando(char operando) {
      this.operando = operando;
   }



   /**
    * Funcion toString que muestra los numeros + operando + resultado
    */
   @Override    
   public String toString(){
      return getNumero1()+DELIMINARTOR+getOperando()+DELIMINARTOR+getNumero2()+
      DELIMINARTOR+getResultado();
   }

}
