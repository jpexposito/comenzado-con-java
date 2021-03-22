package es.ejemplos.jpexposito.elementos;

import java.util.Objects;

public class Destino {
   String ciudad;
   String pais;


   public Destino(String ciudad, String pais) {
      this.ciudad = ciudad;
      this.pais = pais;
   }

   public String getCiudad() {
      return this.ciudad;
   }

   public void setCiudad(String ciudad) {
      this.ciudad = ciudad;
   }

   public String getPais() {
      return this.pais;
   }

   public void setPais(String pais) {
      this.pais = pais;
   }


   public Destino() {
   }

   public Destino ciudad(String ciudad) {
      setCiudad(ciudad);
      return this;
   }

   public Destino pais(String pais) {
      setPais(pais);
      return this;
   }

   @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Destino)) {
            return false;
        }
        Destino destino = (Destino) o;
        return Objects.equals(ciudad, destino.ciudad) && Objects.equals(pais, destino.pais);
   }

   @Override
   public int hashCode() {
      return Objects.hash(ciudad, pais);
   }

   @Override
   public String toString() {
      return "{" +
         " ciudad='" + getCiudad() + "'" +
         ", pais='" + getPais() + "'" +
         "}";
   }

}
