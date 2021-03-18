package es.ejemplos.jpexposito.elementos;

import java.util.Objects;

public class Profesor {
   String nombre;
   String apellidos;
   String dni; 
   
   /**
    * Constructor por defecto
    */
   public Profesor() {
   }

   /**
    * Constructor con parametros
    * @param nombre del profesor
    * @param apellidos del profesor
    * @param dni del profesor
    */
   public Profesor(String nombre, String apellidos, String dni) {
      this.nombre = nombre;
      this.apellidos = apellidos;
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

   public String getDni() {
      return this.dni;
   }

   public void setDni(String dni) {
      this.dni = dni;
   }

   /**
    * Funcion encargada de comparar dos elementos
    */
   @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Profesor)) {
            return false;
        }
        Profesor profesor = (Profesor) o;
        return Objects.equals(nombre, profesor.nombre)
         && Objects.equals(apellidos, profesor.apellidos)
          && Objects.equals(dni, profesor.dni);
   }



   @Override
   public String toString() {
      return getDni()+ ";" + getNombre() + ";" + getApellidos() + "\n";
   }

   

}
