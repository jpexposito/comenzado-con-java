package es.ejemplos.jpexposito.elementos;

public class Alumno extends Persona {
  int posicion;
  

   public Alumno(String nombre, String apellido,int posicion) {
      super(nombre, apellido);
      this.posicion = posicion;
   }


   public int getPosicion() {
      return this.posicion;
   }

   public void setPosicion(int posicion) {
      this.posicion = posicion;
   }


   @Override
   public String toString() {
      return this.nombre+"," +this.apellido+","+this.posicion+"\n";
   }

/*
   @Override
    public String toString() {
        return nombre+" "+apellido;
    }
    */

   @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Alumno)) {
            return false;
        }
        Alumno alumno = (Alumno) o;
        return posicion == alumno.posicion;
   }

   

  
}
