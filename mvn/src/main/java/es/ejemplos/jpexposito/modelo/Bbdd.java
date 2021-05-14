package es.ejemplos.jpexposito.modelo;

import java.sql.*;
import java.util.ArrayList;

import es.ejemplos.jpexposito.api.Fruta;
import es.ejemplos.jpexposito.excepcion.PersistenciaException;

public class Bbdd {

   private String driver;
   private String url;
   private String usuario;
   private String password;

   ArrayList<String> listaTablas;


   public Bbdd(String driver, String url, String usuario, String password) throws PersistenciaException {
      this.driver = driver;
      this.url = url;
      this.usuario = usuario;
      this.password = password;
      init();
   }

   private void init() throws PersistenciaException {
      Connection connection = null;
      for (String nombreTabla : listaTablas) {
         boolean existe = existeTabla(nombreTabla);
         if (!existe) {
            //Obtenemos la sentencia sql del fichero
            String crearTabla = "Create table if not exist fruta (identificador INT PRIMARY KEY,nombre VARCHAR(30),precio float(3,2), coste float(3,2));";
            actualizar(crearTabla);
            //Para cada uno de los insert de nombreTabla
            String insertElemento = "";
            actualizar(insertElemento);

         }
      }

   } 

   /**
    * Funcion encargada de verificar si una tabla existe
    * @param nombreTabla a verificar
    * @return true/false
    * @throws PersistenciaException
    */
   private boolean existeTabla(String nombreTabla) throws PersistenciaException {
      Connection connection = null;
      boolean existe = false;
      ResultSet resultSet  = null;

      try {
         connection = getConnection();
         DatabaseMetaData meta = connection.getMetaData();
         resultSet = meta.getTables(null, null, nombreTabla, new String[] {"TABLE"});
         existe = resultSet.next();
      } catch (Exception e) {
         //TODO: handle exception
      } finally {
         closeConecction(connection, null, resultSet);
      }
      return existe;

   }

   /**
    * Funcion encargada de realizar la conexion con la BBDD
    * @return la coneccion
    * @throws PersistenciaException controlado
    */
   private Connection getConnection() throws PersistenciaException {
      Connection connection = null;

      try {
         Class.forName(driver);
      if (usuario == null || password == null ) {
         connection = DriverManager.getConnection(url);
      } else {
         DriverManager.getConnection(url, usuario, password);
      }
      } catch (Exception exception) {
         throw new PersistenciaException("No se ha podido establecer la coneccion con la BBDD",exception);
      }

      
      return connection;
   }

   
   /**
    * Metodo encargado de realizar la insercion 
    * @param fruta a insertar
    * @throws PersistenciaException error controlado
    */
   public void insertar(Fruta fruta) throws PersistenciaException {
      String sql ="INSERT INTO FRUTA (identificador, nombre, precio coste) " +
      " VALUES ('"+fruta.getIdentificador()+"', '"+fruta.getNombre()+"',"
      +" '"+fruta.getPrecio()+"', '"+fruta.getCoste()+"')";
      actualizar(sql);
   }

   /**
    * Metodo encargado de realizar la actualizacion 
    * @param fruta a actualizar
    * @throws PersistenciaException error controlado
    */
   public void eliminar (Fruta fruta) throws PersistenciaException {
      String sql ="DELETE from Fruta where identificador = '"+fruta.getIdentificador()+"'";
      actualizar(sql);
   }

   /**
    * Metodo encargado de realizar la eliminacion 
    * @param fruta a eliminar
    * @throws PersistenciaException error controlado
    */
   public void modificar (Fruta fruta) throws PersistenciaException {
      String sql ="UPDATE FRUTA SET nombre = '"+fruta.getNombre()+"',"
      +" precio = '"+fruta.getPrecio()+"', coste ='"+fruta.getCoste()+"'"
      +" WHERE identificador = '" + fruta.getIdentificador()+"'";
      actualizar(sql);
   }

/**
 * Metodo encargado de realizar la actualizacion de la BBDD
 * @param sql a ejecutar
 * @throws PersistenciaException error controlado
 */
   private void actualizar(String sql) throws PersistenciaException {
      Statement statement = null;
      Connection connection = null;
      try {
         connection = getConnection();
         statement = connection.createStatement();
         statement.executeUpdate(sql);  
      } catch (Exception exception) {
        throw new PersistenciaException("Se ha producido un error realizando la consulta", exception);
      } finally {
         closeConecction(connection, statement, null);
      }
   
   }

   /**
    * Funcion que realiza la consulta sobre la BBDD y la tabla Fruta
    * @param sql de la consulta
    * @return lista de resultados
    * @throws PersistenciaException controlado
    */
   private ArrayList<Fruta> obtenerListado(String sql) throws PersistenciaException {
      ArrayList<Fruta> listaFrutas = new ArrayList<>();

      Fruta fruta = null;
      Statement statement = null;
      ResultSet resultSet = null;
      Connection connection = null;
      try {
         connection = getConnection();
         statement = connection.createStatement();
         resultSet = statement.executeQuery(sql);
         while (resultSet.next()) {
            String identificador = resultSet.getString("identificador");
            String nombre = resultSet.getString("nombre");
            float precio = resultSet.getFloat("precio");
            float coste = resultSet.getFloat("coste");
            fruta = new Fruta(identificador, nombre, precio, coste);
            listaFrutas.add(fruta);
         }
      } catch (Exception exception) {
        throw new PersistenciaException("Se ha producido un error realizando la consulta", exception);
      } finally {
         closeConecction(connection, statement, resultSet);
      }
      return listaFrutas;
   }

   /**
    * Funcion que obtiene el listado de todas las frutas
    * @return lisa todal
    * @throws PersistenciaException controlado
    */
   public ArrayList<Fruta> obtenerListado() throws PersistenciaException {
      String sql = "SELECT * FROM Fruta";
      return obtenerListado(sql);
   }

   /**
    * Funcion que obtiene una fruta
    * @param
    * @return lisa todal
    * @throws PersistenciaException controlado
    */
   public Fruta obtenerFruta(String identificador) throws PersistenciaException {
      Fruta fruta = null;
      ArrayList<Fruta> listaFrutas = null;
      String sql = "SELECT * FROM Fruta where identificador = ";
      sql = sql + "'" +identificador +"'";
      listaFrutas = obtenerListado(sql);
      if (!listaFrutas.isEmpty()) {
         fruta = listaFrutas.get(0);
      }

      return fruta;
     
   }

   private void closeConecction(Connection connection, Statement statement, ResultSet resultSet) throws PersistenciaException  {
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
      } catch (Exception exception) {
         throw new PersistenciaException("Se ha producido un error cerrando la coneccion", exception);
      }
      
   }
}
