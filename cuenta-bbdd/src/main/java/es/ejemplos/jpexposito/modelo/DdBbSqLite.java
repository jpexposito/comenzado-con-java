package es.ejemplos.jpexposito.modelo;

import es.ejemplos.jpexposito.exception.PersistenciaException;

public class DdBbSqLite extends DdBbRefactorizado {
   private static final String DRIVER = "org.sqlite.JDBC";
   private static final String URL  = "jdbc:sqlite:test.db";
   
   public DdBbSqLite(String nombreTabla, String clave, String driver, String urlConexion, String usuario, String password, String sqlCretate) throws PersistenciaException {
      super(nombreTabla, clave, driver, urlConexion, usuario, password, sqlCretate);
   }

   public DdBbSqLite(String nombreTabla, String clave, String usuario, String password, String sqlCreate) throws PersistenciaException {
      super(nombreTabla, clave,DRIVER, URL, usuario, password, sqlCreate);
   }

  


}
