package es.ejemplos.jpexposito.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Clase fruta de la aplicacion
 */
public class Fruta implements Serializable {
   private static final long serialVersionUID = 1L;

   String identificador;
   String nombre;
   float precio;
   float coste;
   

   /**
    * Constructor por defecto
    */
   public Fruta() {
   
   }
   /**
    * Constructor con todas las propiedades de la fruta
    * @param identificador de la fruta
    * @param nombre de la fruta
    * @param precio de la fruta
    * @param coste de la fruta
    */
   public Fruta(String identificador, String nombre, float precio, float coste) {
      this.identificador = identificador;
      this.nombre = nombre;
      this.precio = precio;
      this.coste = coste;
   }


   /**
    * Constructo que recibe una cadena de text
    * @param cadena con la informacion
    */

   public Fruta(String cadena) {
      ArrayList<Object> elementos = new ArrayList<>();
      StringTokenizer tokenizer = new StringTokenizer(cadena, ",");
      while (tokenizer.hasMoreElements()) {
         elementos.add(tokenizer.nextToken());
      }
      this.identificador = (String) elementos.get(0);
      this.nombre = (String) elementos.get(1);
      this.precio = Float.parseFloat((String)elementos.get(2));
      this.coste = Float.parseFloat((String)elementos.get(3));
   }


   public String getIdentificador() {
      return this.identificador;
   }

   public void setIdentificador(String identificador) {
      this.identificador = identificador;
   }

   public String getNombre() {
      return this.nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public float getPrecio() {
      return this.precio;
   }

   public void setPrecio(float precio) {
      this.precio = precio;
   }

   public float getCoste() {
      return this.coste;
   }

   public void setCoste(float coste) {
      this.coste = coste;
   }

   /**
    * Funcion que realiza el calculo de una fruta
    * @return beneficio por friuta
    */
   public float beneficio() {
      return precio - coste;
   }


   @Override
   public String toString() {
      return getIdentificador() + "," + getNombre() + "," + getPrecio() + "," + getCoste();
   }
   



}
