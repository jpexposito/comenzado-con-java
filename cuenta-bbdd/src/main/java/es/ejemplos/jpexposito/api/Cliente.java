package es.ejemplos.jpexposito.api;

public class Cliente {
   String dni;
   String nombre;
   int edad;


   public Cliente() {
   }

   public Cliente(String dni, String nombre, int edad) {
      this.dni = dni;
      this.nombre = nombre;
      this.edad = edad;
   }


   public String getDni() {
      return this.dni;
   }

   public void setDni(String dni) {
      this.dni = dni;
   }

   public String getNombre() {
      return this.nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public int getEdad() {
      return this.edad;
   }

   public void setEdad(int edad) {
      this.edad = edad;
   }




}
