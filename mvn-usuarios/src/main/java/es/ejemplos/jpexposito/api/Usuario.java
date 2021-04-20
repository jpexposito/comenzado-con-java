package es.ejemplos.jpexposito.api;

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


   
}
