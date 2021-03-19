package es.ejemplos.jpexposito;

import java.util.ArrayList;

public class Lista {

   ArrayList<String> elementos = null;

   /**
    * Constructor por defecto de la clase
    */
   public Lista() {
      elementos = new ArrayList<>();
   }

   /**
    * Metodo encargado de insertar un elemento en el arrayList
    * @param dato elemento a insertar
    */
   public void insertar(String dato) {
      elementos.add(dato);
   }

   /**
    * Funcion que verifica si la lista contiene el dato
    * @param dato a encontrar
    * @return boolean con encontrado si/no
    */
   public boolean existe(String dato) {
      return elementos.contains(dato);
   }

   /**
    * Metodo encargado de realizar la eliminacion de un elemenos
    * @param dato a eliminar
    */
   public void eliminar(String dato) {
      elementos.remove(dato);
   }

   /**
    * Funcion encargada de realizar la busqueda de un elemento
    * @param dato a buscar
    * @return dato encontrado
    */
   public String buscar(String dato) {
      String elemento = null;
      /** Solucion 1 */
      /*
      int posicion = -1;
      
      posicion = elementos.indexOf(dato);
      if (posicion != -1) {
         elemento = elementos.get(posicion);
      }
      */
      /** Solucion 2 */
      for (String elem : elementos) {
         if (elem.equals(dato)) {
            elemento = elem;
            break;
         }
      }
      return elemento; 
   }
   
}
