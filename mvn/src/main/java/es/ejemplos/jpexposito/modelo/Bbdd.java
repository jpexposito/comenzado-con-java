package es.ejemplos.jpexposito.modelo;

import java.sql.*;
import java.util.ArrayList;

import es.ejemplos.jpexposito.api.Fruta;
import es.ejemplos.jpexposito.excepcion.BbddException;

public class Bbdd {

   private String driver;
   private String url;
   private String usuario;
   private String password;


   public Bbdd(String driver, String url, String usuario, String password) {
      this.driver = driver;
      this.url = url;
      this.usuario = usuario;
      this.password = password;
   }

   /**
    * Funcion encargada de realizar la conexion con la BBDD
    * @return la coneccion
    * @throws BbddException controlado
    */
   private Connection getConnection() throws BbddException {
      Connection connection = null;

      try {
         Class.forName(driver);
      if (usuario == null || password == null ) {
         connection = DriverManager.getConnection(url);
      } else {
         DriverManager.getConnection(url, usuario, password);
      }
      } catch (Exception exception) {
         throw new BbddException("No se ha podido establecer la coneccion con la BBDD",exception);
      }

      
      return connection;
   }

   
   //CRUD
   public void insertar(Fruta fruta) {

   }

   public void eliminar (Fruta fruta) {

   }

   public void modificar (Fruta fruta) {

   }


   /**
    * Funcion que realiza la consulta sobre la BBDD y la tabla Fruta
    * @param sql de la consulta
    * @return lista de resultados
    * @throws BbddException controlado
    */
   private ArrayList<Fruta> obtenerListado(String sql) throws BbddException {
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
        throw new BbddException("Se ha producido un error realizando la consulta", exception);
      } finally {
         closeConecction(connection, statement, resultSet);
      }
      return listaFrutas;
   }

   /**
    * Funcion que obtiene el listado de todas las frutas
    * @return lisa todal
    * @throws BbddException controlado
    */
   public ArrayList<Fruta> obtenerListado() throws BbddException {
      String sql = "SELECT * FROM Fruta";
      return obtenerListado(sql);
   }

   /**
    * Funcion que obtiene una fruta
    * @param
    * @return lisa todal
    * @throws BbddException controlado
    */
   public Fruta obtenerFruta(String identificador) throws BbddException {
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

   private void closeConecction(Connection connection, Statement statement, ResultSet resultSet) throws BbddException  {
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
         throw new BbddException("Se ha producido un error cerrando la coneccion", exception);
      }
      
   }
}
