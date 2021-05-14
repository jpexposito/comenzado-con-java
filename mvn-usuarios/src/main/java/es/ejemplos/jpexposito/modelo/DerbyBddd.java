package es.ejemplos.jpexposito.modelo;


public class DerbyBddd extends Bbdd {
   
   static String driverDerby = "org.apache.derby.jdbc.EmbeddedDriver";
   static String url = "derby.db";

   public DerbyBddd(String driver, String urlConexion, String usuario, String password) {
      super(driver, urlConexion, usuario, password); 
   }

   public DerbyBddd(String urlConexion, String usuario, String password) {
      super(driverDerby, urlConexion, usuario, password); 
   }

   public DerbyBddd(String usuario, String password) {
      super(driverDerby, url, usuario, password); 
   }
   
}
