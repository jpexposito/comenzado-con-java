package es.ejemplos.jpexposito.elementos;

import java.util.Objects;

public class Persona extends Validacion {

   String dni;
   String nombre;
   String apellidos;

   /**
    * Constructor por defecto
    */
   public Persona() {
   }

   /**
    * Constructor con parametros
    * @param dni del pasajero
    * @param nombre del pasajero
    * @param apellidos del pasajero
    */
   public Persona(String dni, String nombre, String apellidos) {
      this.dni = dni;
      this.nombre = nombre;
      this.apellidos = apellidos;
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

   public String getApellidos() {
      return this.apellidos;
   }

   public void setApellidos(String apellidos) {
      this.apellidos = apellidos;
   }


   @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pasajero)) {
            return false;
        }
        Pasajero pasajero = (Pasajero) o;
        return Objects.equals(dni, pasajero.dni) && Objects.equals(nombre, pasajero.nombre) && Objects.equals(apellidos, pasajero.apellidos);
   }
}
