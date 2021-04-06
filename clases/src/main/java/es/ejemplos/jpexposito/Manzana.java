package es.ejemplos.jpexposito;

public class Manzana extends Fruta{

   public Manzana(){
      this.nombre = "Manzana";
   }
   public Manzana(float precio,String color, float peso) {
      super(precio, color, peso);
      this.nombre = "Manzana";
   }
}
