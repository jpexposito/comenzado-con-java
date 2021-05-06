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
    * 
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
    * 
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
         closeConecction(connection, statement, resultSet);
      }
      return usuario;
   }

    public ArrayList<Usuario> buscarTodos() throws BbddException {
      ArrayList<Usuario> lista = new ArrayList<>();
      
      Statement statement = null;
      String sql = "SELECT * FROM usuario ";
      ResultSet resultSet = null;

      try {

         statement = getConnection().prepareStatement(sql);
         resultSet = statement.executeQuery();

         while(resultSet.next()) {
            Usuario usuario;
            usuario.setIdentificador(resultSet.getString("identificador"));
            usuario.setNombre(resultSet.getString("nombre"));
            usuario.setApellidos(resultSet.getString("apellidos"));
            usuario.setEdad(resultSet.getInt("edad"));
            lista.add(usuario);
         }
      } catch (SQLException exception) {
         throw new BbddException("Se ha producido un error en la busqueda", exception);
      } finally {
         closeConecction(connection, statement, resultSet);
      }
      return lista;
   }

   /**
    * Metodo encargado de realizar la insercion en la BBDD
    * 
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
         statement.setIngeter(4, usuario.getEdad());
         statement.executeUpdate();
      } catch (SQLException exception) {
         throw new BbddException("Se ha producido un error en la busqueda", exception);
      } finally {
         closeConecction(connection, statement, null);
      }
   }

   /**
    * Metodo encargado de realizar la actualizacion en la BBDD
    * 
    * @param usuario a actualizar
    * @throws BbddException
    */
   /*
    * public void update(Usuario usuario) throws BbddException { Statement
    * statement = null;
    * 
    * String sql = "UPDATE usuario set nombre = "+usuario.getNombre() +
    * ",  apellidos = " + usuario.getApellidos() + ",  edad = " + usuario.getEdad()
    * + " WHERE identificador = " + usuario.getIdentificador();
    * 
    * try { statement = getConnection().prepareStatement(sql);
    * statement.executeUpdate(sql); } catch (SQLException exception) { throw new
    * BbddException("Se ha producido un error en la busqueda", exception); }
    * finally { closeConecction(connection, statement, null); } }
    */
   public void update(Usuario usuario) throws BbddException {

      String sql = "UPDATE usuario set nombre = " + usuario.getNombre() + ",  apellidos = " + usuario.getApellidos()
            + ",  edad = " + usuario.getEdad() + " WHERE identificador = " + usuario.getIdentificador();

      update(sql);
   }

   /**
    * Metodo encargado de realizar la actualizacion en la BBDD
    * 
    * @param usuario a actualizar
    * @throws BbddException
    */
   public void eliminar(String identificador) throws BbddException {

      String sql = "DELETE FROM usaurio WHERE identificador = '" + identificador + "'";
      update(sql);

   }

   public void update(String sql) throws BbddException {
      Statement statement = null;

      try {
         statement = getConnection().prepareStatement(sql);
         statement.executeUpdate(sql);
      } catch (SQLException exception) {
         throw new BbddException("Se ha producido un error en la busqueda", exception);
      } finally {
         closeConecction(connection, statement, null);
      }
   }

   /**
    * Metodo encargado de realizar el cierre de la conexion con la BBDD
    * 
    * @param connection contra la BBDD
    * @param statement  de la operacion
    * @param resultSet  resultado
    * @throws BbddException error controlado
    */
   private void closeConecction(Connection connection, Statement statement, ResultSet resultSet) throws BbddException {
      try {
         if (resultSet != null) {
            resultSet.close();
         }
         if (statement != null) {
            statement.close();
         }
         if (connection != null) {
            connection.close();
         }
      } catch (Exception e) {
         throw new BbddException("Se ha producido un error cerrando la sesion con la BBDD");
      }

   }

}
