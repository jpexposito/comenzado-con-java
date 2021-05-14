package es.ejemplos.jpexposito.modelo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import es.ejemplos.jpexposito.api.Usuario;
import es.ejemplos.jpexposito.exceptions.PersistenciaException;

public abstract class Bbdd {

   private static final String TABLE = "TABLE";
   private static final String TABLE_USUARIOS= "USUARIOS";

   protected String driver;
   protected String urlConexion;
   protected String usuario;
   protected String password;
   private Connection connection;

   public Bbdd(String driver, String urlConexion, String usuario, String password) {
      this.driver = driver;
      this.urlConexion = urlConexion;
      this.usuario = usuario;
      this.password = password;
   }

   private void crearTablas() {
      DatabaseMetaData databaseMetaData;
      Connection connection = null;
      ResultSet resultSet = null;
      ArrayList<String> listaTablas = new ArrayList<>();
      try {
         connection = getConnection();
         databaseMetaData = connection.getMetaData();
         resultSet = databaseMetaData.getTables(null, null, null, new String[] {TABLE});
         while (resultSet.next()) {
            listaTablas.add(resultSet.getString("TABLE_NAME"));
        }
        if (!listaTablas.contains(TABLE_USUARIOS)) {
           //Crear tabla usuario
           String sqlCrearTabla = null;
           update(sqlCrearTabla);
           //Extraer de fichero las sentencias sql para insertar en la BBDD
           String sqlInsertarDatos = null;
           update(sqlInsertarDatos);
           //Insertar datos
        }

      } catch (Exception e) {
         //TODO: handle exception
      }

   }

   /**
    * Funcion encargada de realizar la conexion con la BBDD
    * @return conexion abierta
    * @throws PersistenciaException
    */
   public Connection getConnection() throws PersistenciaException {
      if (connection == null) {
         try {
            Class.forName(driver);
            if (usuario != null && password != null) {
               connection = DriverManager.getConnection(urlConexion, usuario, password);
            } else {
               connection = DriverManager.getConnection(urlConexion);
            }
         } catch (ClassNotFoundException | SQLException exception) {
            throw new PersistenciaException("No se ha podido estabalecer la conexion", exception);
         }
      }
      return connection;
   }

   /**
    * Funcion encargada de obtener un usuario
    * 
    * @param identificador del usuario
    * @return Objeto usuario
    * @throws PersistenciaException
    */
   public Usuario buscarUsuario(String identificador) throws PersistenciaException {
      Usuario usuario = null;
      String sql = "SELECT * FROM usuario WHERE identificador='"+identificador+"'";
      ArrayList<Usuario> lista = buscar(sql);
      if (!lista.isEmpty()) {
         usuario = lista.get(0);
      }
      return usuario;
   }

   /**
    * Funcion que obtiene todos los usuarios de la BBDD
    * @return lista usuarios
    * @throws PersistenciaException error controlado
    */
    public ArrayList<Usuario> buscarTodos() throws PersistenciaException {
      String sql = "SELECT * FROM usuario ";
      return buscar(sql);
   }
   /**
    * Funcion que realiza una consulta sobre una sentencia sql dada
    * @param sql de la consulta
    * @return lista resultados (0..n) Usuasios
    * @throws PersistenciaException error controlado
    */
   private ArrayList<Usuario> buscar(String sql) throws PersistenciaException {
      ArrayList<Usuario> lista = new ArrayList<>();
      Statement statement = null;
      ResultSet resultSet = null;

      try {
         connection = getConnection();
         statement = connection.prepareStatement(sql);
         resultSet = statement.executeQuery(sql);

         while(resultSet.next()) {
            Usuario usuario = new Usuario();
            usuario.setIdentificador(resultSet.getString("identificador"));
            usuario.setNombre(resultSet.getString("nombre"));
            usuario.setApellidos(resultSet.getString("apellidos"));
            usuario.setEdad(resultSet.getInt("edad"));
            lista.add(usuario);
         }
      } catch (SQLException exception) {
         throw new PersistenciaException("Se ha producido un error en la busqueda", exception);
      } finally {
         closeConecction(connection, statement, resultSet);
      }
      return lista;
   }


   /**
    * Metodo encargado de realizar la insercion en la BBDD
    * 
    * @param usuario a insertar
    * @throws PersistenciaException
    */
   public void insertar(Usuario usuario) throws PersistenciaException {
      String sql = "INSERT INTO usuario (identificador, nombre, apeliidos, edad)"+
      " VALUES ('"+usuario.getIdentificador()+"','"+usuario.getNombre()+"','"
      +usuario.getApellidos()+"','"+usuario.getEdad()+"')";
      update(sql);
   }

   /**
    * Metodo encargado de realizar la actualizacion de un usuario
    * @param usuario a actualizar
    * @throws PersistenciaException error controlado
    */
   public void update(Usuario usuario) throws PersistenciaException {
      String sql = "UPDATE usuario set nombre = " + usuario.getNombre() + ",  apellidos = " + usuario.getApellidos()
            + ",  edad = " + usuario.getEdad() + " WHERE identificador = " + usuario.getIdentificador();
      update(sql);
   }
   /**
    * Metodo encargado de realizar la actualizacion en la BBDD
    * 
    * @param usuario a actualizar
    * @throws PersistenciaException
    */
   public void eliminar(String identificador) throws PersistenciaException {
      String sql = "DELETE FROM usaurio WHERE identificador = '" + identificador + "'";
      update(sql);
   }

   /**
    * Metodo encargado de realizar las inserciones/modificaciones/eliminacion de la BBDD
    * @param sql con la sentencia
    * @throws PersistenciaException error controlado
    */
   public void update(String sql) throws PersistenciaException {
      Statement statement = null;
      try {
         connection= getConnection();
         statement = connection.prepareStatement(sql);
         statement.executeUpdate(sql);
      } catch (SQLException exception) {
         throw new PersistenciaException("Se ha producido un error en la busqueda", exception);
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
    * @throws PersistenciaException error controlado
    */
   private void closeConecction(Connection connection, Statement statement, ResultSet resultSet) throws PersistenciaException {
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
         throw new PersistenciaException("Se ha producido un error cerrando la sesion con la BBDD");
      }

   }

}
