package es.ejemplos.jpexposito.controlador;

import es.ejemplos.jpexposito.api.Fruta;
import es.ejemplos.jpexposito.excepcion.FrutaException;
import es.ejemplos.jpexposito.modelo.FrutaModelo;

/**
 * Controlador de la clase Fruta
 */
public class FrutaController {

   FrutaModelo frutaModelo;

   public FrutaController() {
      frutaModelo = new FrutaModelo();
   }

   /**
    * Metodo encargado de realizar la validacion del objeto fruta
    * 
    * @param fruta a validar
    * @throws FrutaException con el mensaje descriptivo de lo que sucede
    */
   public void validarFruta(Fruta fruta) throws FrutaException {
      String mensaje = "";

      if (fruta == null) {
         mensaje = "Se esta validando un objeto nulo de fruta";
         throw new FrutaException(mensaje);
      }
      if (fruta.getIdentificador() == null || fruta.getIdentificador().isEmpty()) {
         mensaje = "El identidicador de la fruta es nulo o vacio, ";
      }

      if (fruta.getNombre() == null || fruta.getNombre().isEmpty()) {
         mensaje += "El nombre de la fruta es nulo o vacio, ";
      }

      if (fruta.getCoste() < 0) {
         mensaje += "El coste de la fruta es 0 o menor, ";
      }
      if (fruta.getPrecio() < 0) {
         mensaje += "El precio de la fruta es 0 o menor.";
      }
      if (!mensaje.isEmpty()) {
         throw new FrutaException(mensaje);
      }
   }

   public void insertar(String identificador, String nombre, String color, float coste, float precio) {
     frutaModelo.insertar(identificador, nombre, color, coste, precio);
   }

   public void insertar(String identificador, String nombre, String color, float coste, float precio, String textura) {
      frutaModelo.insertar(identificador, nombre, color, coste, precio, textura);
    }

}
