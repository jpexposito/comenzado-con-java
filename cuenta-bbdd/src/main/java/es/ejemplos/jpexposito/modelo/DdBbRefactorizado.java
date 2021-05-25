package es.ejemplos.jpexposito.modelo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import es.ejemplos.jpexposito.api.Cuenta;
import es.ejemplos.jpexposito.exception.PersistenciaException;

public abstract class DdBbRefactorizado {

   private static final String TABLE = "TABLE";
   private static final String TABLE_NAME= "TABLE_NAME";

   protected String nombreTabla;
   protected String clave;
   protected String driver;
   protected String urlConexion;
   protected String usuario;
   protected String password;

   public DdBbRefactorizado(String nombreTabla, String clave, String driver, String urlConexion, String usuario, String password) throws PersistenciaException {
      this.nombreTabla = nombreTabla;
      this.clave = clave;
      this.driver = driver;
      this.urlConexion = urlConexion;
      this.usuario = usuario;
      this.password = password;
      inicializarTabla(nombreTabla);
   }


   private void inicializarTabla(String tabla) throws PersistenciaException {
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
        if (!listaTablas.contains(tabla)) {
           //Crear tabla cuenta
           String sqlCrearTabla = "CREATE TABLE IF NOT EXISTS CUENTA ("
            + " codigo VARCHAR(50) PRIMARY KEY,"
            + "cliente VARCHAR(9) NOT NULL,"
            + "email VARCHAR(50) NOT NULL,"
            + "saldo DOUBLE NOT NULL);";
           update(sqlCrearTabla);
           //Extraer de fichero las sentencias sql para insertar en la BBDD
           //String sqlInsertarDatos = null;
           //update(sqlInsertarDatos);
           //Insertar datos
        }

      } catch (Exception e) {
         throw new PersistenciaException("Se ha producido un error en la inicializacion de la BBDD", e);
      } finally {
         closeConecction(connection, null, resultSet);
      }

   }

   /**
    * Funcion encargada de realizar la conexion con la BBDD
    * @return conexion abierta
    * @throws PersistenciaException
    */
   public Connection getConnection() throws PersistenciaException {
      Connection connection = null;

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
      
      return connection;
   }

   /**
    * Funcion encargada de obtener un cuenta
    * 
    * @param identificador del cuenta
    * @return Objeto cuenta
    * @throws PersistenciaException
    */
    /**
   public Object buscarElemento(String identificador) throws PersistenciaException {
      Object elemento = null;
      String sql = "SELECT * FROM "+this.nombreTabla+" WHERE "+this.clave+"='"+identificador+"'";
      ArrayList<Object> lista = buscar(sql);
      if (!lista.isEmpty()) {
         elemento = lista.get(0);
      }
      return elemento;
   }
   **/

   /**
    * Funcion que obtiene todos los usuarios de la BBDD
    * @return lista usuarios
    * @throws PersistenciaException error controlado
    
    public ArrayList<Object> buscarTodos() throws PersistenciaException {
      String sql = "SELECT * FROM " + this.nombreTabla;
      return buscar(sql);
   }
   **/
   /**
    * Funcion que realiza una consulta sobre una sentencia sql dada
    * @param sql de la consulta
    * @return lista resultados (0..n) Usuasios
    * @throws PersistenciaException error controlado
    */
    /**
   private ArrayList<Object> buscar(String sql) throws PersistenciaException {
      ArrayList<Object> lista = new ArrayList<>();
      PreparedStatement statement = null;
      ResultSet resultSet = null;
      Connection connection = null;
      try {
         connection = getConnection();
         statement = connection.prepareStatement(sql);
         resultSet = statement.executeQuery();

         while(resultSet.next()) {
            Cuenta cuenta = new Cuenta();
            cuenta.setCodigo(resultSet.getString("codigo"));
            cuenta.setCliente(resultSet.getString("cliente"));
            cuenta.setEmail(resultSet.getString("email"));
            cuenta.setSaldo(resultSet.getDouble("saldo"));
            lista.add(cuenta);
         }
      } catch (SQLException exception) {
         throw new PersistenciaException("Se ha producido un error en la busqueda", exception);
      } finally {
         closeConecction(connection, statement, resultSet);
      }
      return lista;
   }
**/

   /**
    * Funcion que realiza una consulta sobre una sentencia sql dada
    * @param sql de la consulta
    * @return lista resultados (0..n) Usuasios
    * @throws PersistenciaException error controlado
    */
    protected ResultSet buscarElementos(String sql) throws PersistenciaException {
      
      PreparedStatement statement = null;
      ResultSet resultSet = null;
      Connection connection = null;
      try {
         connection = getConnection();
         statement = connection.prepareStatement(sql);
         resultSet = statement.executeQuery();
      } catch (SQLException exception) {
         throw new PersistenciaException("Se ha producido un error en la busqueda", exception);
      } finally {
         //closeConecction(connection, statement, null);
      }
      return resultSet;
   }


   /**
    * Metodo encargado de realizar las inserciones/modificaciones/eliminacion de la BBDD
    * @param sql con la sentencia
    * @throws PersistenciaException error controlado
    */
   public void update(String sql) throws PersistenciaException {
      PreparedStatement statement = null;
      Connection connection = null;
      try {
         connection= getConnection();
         statement = connection.prepareStatement(sql);
         statement.executeUpdate();
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
   public void closeConecction(Connection connection, Statement statement, ResultSet resultSet) throws PersistenciaException {
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
