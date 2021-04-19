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

   /**
    * Metodo encargado de insertar
    * @param fruta a insertar
    * @throws FrutaException con mensaje controlado
    */
   public void insertar(Fruta fruta) throws FrutaException {
      validarFruta(fruta);
      if (existe(fruta)) {
         throw new FrutaException("La fruta indicada ya existe");
      }
      frutaModelo.insertar(fruta); 
   }

   /**
    * Metodo encargado de eliminar
    * @param fruta a eliminar
    * @throws FrutaException
    */
   public void eliminar(Fruta fruta) throws FrutaException {
      validarFruta(fruta);
      if (!existe(fruta)) {
         throw new FrutaException("La fruta indicada NO existe");
      }
      frutaModelo.eliminar(fruta); 
   }

   /**
    * Meotod encargado de realiza la eliminacion de una fruta
    * @param identificador del elemento a eliminar
    * @throws FrutaException controlada con el error
    */
   public void eliminar(String identificador) throws FrutaException {
      Fruta fruta;
      fruta = buscar(identificador);
      if (fruta == null) {
         throw new FrutaException("La fruta indicada NO existe");
      }
      frutaModelo.eliminar(fruta); 
   }

   /**
    * Metodo encargado de buscar por identificador
    * @param identificador para localizar la fruta
    * @return fruta a traves del identificador
    */
   public Fruta buscar(String identificador) {
      Fruta fruta = null;
      fruta = frutaModelo.buscar(identificador);
      return fruta;
   }

   /**
    * Metodo encargado de realizar la modificacion de una fruta
    * @param fruta a modficar
    * @throws FrutaException controlada en caso de error
    */
   public void modificar(Fruta fruta) throws FrutaException {
      Fruta frutaAlmacenada;
      validarFruta(fruta);
      frutaAlmacenada = buscar(fruta.getIdentificador());
      if (frutaAlmacenada == null) {
         throw new FrutaException("La fruta indicada NO existe");
      }
      frutaModelo.modificar(fruta);
   }

   /**
    * Funcion encargada de verificar si existe la fruta
    * @param fruta a encontrar
    * @return true/false
    */
   private boolean existe(Fruta fruta) {
     boolean encontrada = false;
     Fruta frutaEncontrada;

     frutaEncontrada = buscar(fruta.getIdentificador());
     if (frutaEncontrada != null) {
        encontrada = true;
     }  
     return encontrada;
   }


   

}
