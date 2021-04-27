package es.ejemplos.jpexposito.api;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Clase Usuario que pertence a la API
 */
public class Usuario {
  
   String identificador;
   String nombre;
   String apellidos;
   int edad;

   /**
    * Constructor por defecto
    */
   public Usuario() {
   }

   /**
    * Constructor con propiedades
    * @param identificador del usuario
    * @param nombre del usuario
    * @param apellidos del usuario
    * @param edad del usuario
    */
   public Usuario(String identificador, String nombre, String apellidos, int edad) {
      this.identificador = identificador;
      this.nombre = nombre;
      this.apellidos = apellidos;
      this.edad = edad;
   }

   /**
    * Copnstructor de la clase con una linea de texto
    * @param linea a parsear
    */
   public Usuario(String linea) { 
    ArrayList<Object> elementos = new ArrayList<>();
    StringTokenizer tokenizer = new StringTokenizer(linea, ",");
    while (tokenizer.hasMoreElements()) {
       elementos.add(tokenizer.nextToken());
    }
    this.identificador = (String) elementos.get(0);
    this.nombre = (String) elementos.get(1);
    this.apellidos = (String) elementos.get(2);
    this.edad = Integer.parseInt((String) elementos.get(3));
   }

   /**
    * GETTERS AND SETTERS
    */

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

   public String getApellidos() {
      return this.apellidos;
   }

   public void setApellidos(String apellidos) {
      this.apellidos = apellidos;
   }

   public int getEdad() {
      return this.edad;
   }

   public void setEdad(int edad) {
      this.edad = edad;
   }


   @Override
   public String toString() {
      return getIdentificador() + "," + getNombre() + ","
       +getApellidos() + "," + getEdad();
   }



   
}
