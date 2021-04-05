package es.ejemplos.jpexposito.elementos;

public class Persona {
   String nombre;
   String apellido;

   public Persona() {
   }
    
   public Persona (String nombre, String apellido) {
      this.nombre = nombre;
      this.apellido = apellido;
   }


   public String getNombre() {
      return this.nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getApellido() {
      return this.apellido;
   }

   public void setApellido(String apellido) {
      this.apellido = apellido;
   }

}
