package es.ejemplos.jpexposito.modelo;

import es.ejemplos.jpexposito.api.Usuario;

public class DerbyBddd extends Bbdd {
   
   public DerbyBddd(String driver, String urlConexion, String usuario, String password) {
      super(driver, urlConexion, usuario, password);
      
   }
   
}