package es.ejemplos.jpexposito;

public class Naranja extends Fruta{

   public Naranja(){
      this.nombre = "Naranja";
   }
   public Naranja(float precio,String color, float peso) {
      super(precio, color, peso);
      this.nombre = "Naranja";
   }

}
