package es.ejemplos.jpexposito.modelo;

import es.ejemplos.jpexposito.api.Fruta;
import es.ejemplos.jpexposito.excepcion.PersistenciaException;
public class FrutaModelo {

   //BerbyBbdd persistencia;
   MySqlBdDd persistencia;

   public FrutaModelo() {
      //persistencia = new BerbyBbdd("org.apache.derby.jdbc.EmbeddedDriver", "mem:derby.db", null, null);
      persistencia = new MySqlBdDd("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/test"
      , "minty", "greatsqldb");

   }

   public void insertar(Fruta fruta) throws PersistenciaException {
      persistencia.insertar(fruta);
   }

   public void eliminar(Fruta fruta) throws PersistenciaException {
      persistencia.eliminar(fruta);
   }

   /**
    * Funcion que busca una fruta a traves del identificar
    * @param identificador de la fruta
    * @return Fruta con el identificador especificado
    * @throws PersistenciaException
    */
   public Fruta buscar(String identificador) throws PersistenciaException {

     return persistencia.obtenerFruta(identificador);
    /**
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
     **/
   }

   public void modificar(Fruta fruta) throws PersistenciaException {
      persistencia.modificar(fruta);
   }
   
}
