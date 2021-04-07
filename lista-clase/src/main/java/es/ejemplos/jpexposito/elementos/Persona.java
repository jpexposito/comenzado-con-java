package es.ejemplos.jpexposito.elementos;

import es.ejemplos.jpexposito.enumerados.TipoPersona;

public class Persona {
   String nombre;
   String apellido;
   TipoPersona tipo;

   public Persona() {
   }
    
   public Persona (String nombre, String apellido) {
      this.nombre = nombre;
      this.apellido = apellido;
   }

   public Persona(String nombre, String apellido, TipoPersona tipo) {
      this.nombre = nombre;
      this.apellido = apellido;
      if (tipo == null) {
         tipo = TipoPersona.ALUMNO;
      }
      this.tipo = tipo;
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
