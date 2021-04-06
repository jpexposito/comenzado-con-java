package es.ejemplos.jpexposito;

public class Peras extends Fruta{

   public Peras(){
      this.nombre = "Pera";
   }
   public Peras(float precio,String color, float peso) {
      super(precio, color, peso);
      this.nombre = "Pera";
   }

}
