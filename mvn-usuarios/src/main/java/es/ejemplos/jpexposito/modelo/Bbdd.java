package es.ejemplos.jpexposito.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import es.ejemplos.jpexposito.api.Usuario;
import es.ejemplos.jpexposito.excepcion.BbddException;

public class Bbdd {
   
   private String driver;
   private String urlConexion;
   private String usuario;
   private String password;
   private Connection connection;

   public Bbdd(String driver, String urlConexion, String usuario, String password) {
      this.driver = driver;
      this.urlConexion = urlConexion;
      this.usuario = usuario;
      this.password = password;
   }

   /**
    * Funcion encargada de realizar la conexion con la BBDD
    * @return conexion abierta
    * @throws BbddException
    */
   public Connection getConnection() throws BbddException {
      if (connection == null) {
         try {
            Class.forName(driver);
            connection = DriverManager.getConnection(urlConexion, usuario, password);
         } catch (ClassNotFoundException | SQLException exception) {
            throw new BbddException("No se ha podido estabalecer la conexion", exception);
         } 
      }
      return connection;
   }

   /**
    * Funcion encargada de obtener un usuario
    * @param identificador del usuario
    * @return Objeto usuario
    * @throws BbddException
    */
    public Usuario buscar(String identificador) throws BbddException {
      Usuario usuario = null;
      Statement statement = null; 
      String sql = "SELECT * FROM usuario WHERE identificador=?";
      ResultSet resultSet = null;
      
      try {

         statement = getConnection().prepareStatement(sql);
         statement.setString(1, identificador);
         resultSet = statement.executeQuery();

         if (resultSet.next()) { 
            usuario = new Usuario();
            usuario.setIdentificador(identificador);
            usuario.setNombre(resultSet.getString("nombre"));
            usuario.setApellidos(resultSet.getString("apellidos"));
            usuario.setEdad(resultSet.getInt("edad"));
         }
      } catch (SQLException exception) {
         throw new BbddException("Se ha producido un error en la busqueda", exception);
      } finally {
         if (resultSet != null) {
            resultSet.close();
         }
         if (statement != null) {
            statement.close();
         }
         if (connection != null ) {
            connection.close();
         }
      }
      return usuario;
   }

   /**
    * Metodo encargado de realizar la insercion en la BBDD
    * @param usuario a insertar
    */
   public void insertar(Usuario usuario) {
      Statement statement = null; 
      String sql = "INSERT INTO usuario VALUES (?,?,?,?)";
      try {
         statement = getConnection().prepareStatement(sql); 
         statement.setString(1, usuario.getIdentificador());
         statement.setString(2, usuario.getNombre());
         statement.setString(3, usuario.getApellidos());
         statement.setIngeter (4, usuario.getEdad());
         statement.executeUpdate();
      } catch (SQLException exception) {
         throw new BbddException("Se ha producido un error en la busqueda", exception);
      } finally {
         if (statement != null) {
            statement.close();
         }
         if (connection != null ) {
            connection.close();
         }
      }
      
   }




   
}
