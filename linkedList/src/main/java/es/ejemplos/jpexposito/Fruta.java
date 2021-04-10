package es.ejemplos.jpexposito;

/**
 * Clase Fruta que permite almacenar la informacion de la fruta
 */
public class Fruta {

   String color;
   int peso;

   public Fruta() {

   }

   /**
    * Constructor de la clase Fruta
    * @param color
    * @param peso
    */
   public Fruta(String color, int peso) {
      this.color = color;
      this.peso = peso;
   }


   /**
    * Funcion que permite obtener la informacion de la clase Fruta
    */
   @Override
   public String toString() {
      return " color='" + getColor() + "'" + ", peso='" + getPeso() + "'\n";
   }


   public String getColor() {
      return this.color;
   }

   public int getPeso() {
      return this.peso;
   }

   public void setColor(String color) {
      this.color = color;
   }
   public void setPeso(int peso) {
      this.peso = peso;
   }
   
   
}
