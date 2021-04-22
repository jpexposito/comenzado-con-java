package es.ejemplos.jpexposito.modelo;

import java.util.ArrayList;

import es.ejemplos.jpexposito.api.Fruta;
import es.ejemplos.jpexposito.excepcion.FicheroException;

public class FrutaModelo {

   Fichero fichero;

   public FrutaModelo() {
      fichero = new Fichero();
   }

   public void insertar(Fruta fruta) throws FicheroException {
      fichero.insertar(fruta);
   }

   public void eliminar(Fruta fruta) throws FicheroException {
      fichero.eliminar(fruta);
   }

   /**
    * Funcion que busca una fruta a traves del identificar
    * @param identificador de la fruta
    * @return Fruta con el identificador especificado
    */
   public Fruta buscar(String identificador) {
     Fruta fruta = null;
     ArrayList<Fruta> listado;
     listado = fichero.obtenerListado();
     int i = 0;
     while(i < listado.size() && fruta == null) {
        if (identificador.equals(listado.get(i).getIdentificador())) {
           fruta = listado.get(i);
        }
        i++;
     }

     return fruta;
   }

   public void modificar(Fruta fruta) {
      //lo que sea
   }
   
}
