package es.ejemplos.jpexposito.elementos;

import java.util.Objects;

import es.ejemplos.jpexposito.exception.PasajeroExeption;


public class Pasajero extends Validacion { 
   String dni;
   String nombre;
   String apellidos;
   private String ciudad; 

/**
 * Constructor con parametros
 * @param dni del pasajero
 * @param nombre del pasajero
 * @param apellidos del pasajero
 * @param ciudad
 * @throws PasajeroExeption error controlado
 */
   public Pasajero (String dni, String nombre, String apellidos, String ciudad) throws PasajeroExeption {
      validarDni(dni);
      this.dni = dni;
      this.nombre = nombre;
      this.apellidos = apellidos;
      this.ciudad = ciudad;
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


   public String getCiudad() {
      return this.ciudad;
   }

   @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pasajero)) {
            return false;
        }
        Pasajero pasajero = (Pasajero) o;
        return Objects.equals(dni, pasajero.dni) && Objects.equals(nombre, pasajero.nombre) && Objects.equals(apellidos, pasajero.apellidos) && Objects.equals(ciudad, pasajero.ciudad);
   }

   /**
    * Funcion que obtiene el nombre del pasajero
    * @return String formateado con el nombre del pasajero 
    */
   public String obtenerViajero() {
      return getDni() +"," + getNombre() + ", " + getApellidos();
   }

}
