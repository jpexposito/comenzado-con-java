package es.ejemplos.jpexposito;

import es.ejemplos.jpexposito.api.Fruta;

public class UtilidadesTest {
   
   public static final String NARANJA = "naranja";
   public static final String AA221 = "aa221";

   public Fruta generarfruta(String identificador, String nombre, float precio, float coste) {
      Fruta fruta = null;
      if (identificador != null && nombre != null && precio > 0 && coste > 0) {
          fruta = new Fruta(identificador, nombre, precio, coste);
      } else {
          fruta = new Fruta();
          fruta.setIdentificador(AA221);
          fruta.setNombre(NARANJA);
          fruta.setPrecio(1.5f);
          fruta.setCoste(0.90f);
      }
      return fruta;
  }
}
