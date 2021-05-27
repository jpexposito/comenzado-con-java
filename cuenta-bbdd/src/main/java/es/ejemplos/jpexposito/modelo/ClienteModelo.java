package es.ejemplos.jpexposito.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import es.ejemplos.jpexposito.api.Cliente;
import es.ejemplos.jpexposito.exception.PersistenciaException;

public class ClienteModelo{

   DdBbSqLite persistencia;
   private static final String TABLA  = "CLIENTE";
   private static final String CLAVE  = "DNI";
   private static final String SQLCREATETABLE = "CREATE TABLE IF NOT EXISTS "+TABLA+" ("
   + CLAVE + " VARCHAR(9) PRIMARY KEY,"
   + "nombre VARCHAR(9) NOT NULL,"
   + "edad integer NOT NULL);";

   

   
   public ClienteModelo() throws PersistenciaException {
      persistencia = new DdBbSqLite(TABLA, CLAVE, null, null,SQLCREATETABLE);
      
   }

   /**
    * Metodo que permite insertar un elemento cliente
    * @param cliente a insertar
    * @throws PersistenciaException error controlado
    */
   public void insertar(Cliente cliente) throws PersistenciaException {
      String sql = "INSERT INTO "+TABLA+" (dni, nombre, edad)"+
      " VALUES ('"+cliente.getDni()+"','"+cliente.getNombre()+"',"+cliente.getEdad()+");";
      persistencia.update(sql);
   }

   /**
    * Metodo que permite eliminar un elemento cliente
    * @param cliente a eliminar
    * @throws PersistenciaException error controlado
    */
   public void eliminar(Cliente cliente) throws PersistenciaException {
      String sql = "DELETE FROM "+TABLA+" WHERE "+CLAVE+" = '" + cliente.getDni() + "'";
      persistencia.update(sql);
   }



   /**
    * Metodo que permite realizar la busqueda de un elemento cuenta a traves de su codigo
    * @param indentificador (Codigo) de la cliente
    * @return cliente en caso de existit
     * @throws PersistenciaException error controlado
    */
   public Cliente buscar(String indentificador) throws PersistenciaException {
      Cliente clienteEncontrado = null;
      String sql = "SELECT * FROM "+this.TABLA+" WHERE "+this.CLAVE+"='"+indentificador+"'";
      ResultSet resultSet;
      ArrayList<Cliente> lista  = new ArrayList<>();
      try {
         resultSet = persistencia.buscarElementos(sql);
         lista = buscar(resultSet);
      } catch (PersistenciaException e) {
         throw new PersistenciaException("Se ha producido un error realizando la consulta",e);
      } finally {
         persistencia.closeConecction(persistencia.getConnection(), null, null);
      }
      
      if (lista.size() > 0) {
         clienteEncontrado = lista.get(0);  
      }
      return clienteEncontrado;
   }
   /**
    * Funcion encargada de transformar un ResultSet en una lista de resultados
    * @param resultSet de entrada
    * @return lista de clientes
    * @throws PersistenciaException error controlado
    */
   private ArrayList<Cliente> buscar(ResultSet resultSet) throws PersistenciaException {
      ArrayList<Cliente> lista = new ArrayList<>();
      try {
         while(resultSet.next()) {
            Cliente cliente = new Cliente();
            cliente.setDni(resultSet.getString("dni"));
            cliente.setNombre(resultSet.getString("nombre"));
            cliente.setEdad(resultSet.getInt("edad"));
            lista.add(cliente);
         }
      } catch (SQLException e) {
         throw new PersistenciaException("Se ha producido un error realizando la transformacion a Cliente", e);
      } finally {
         persistencia.closeConecction(null, null, resultSet);
      }
      return lista;
   }

   /**
    * Metodo que permite realizar la actualizacion de una cliente
    * @param cliente a actualizar
     * @throws PersistenciaException error controlado 
    */
   public void actualizar(Cliente cliente) throws PersistenciaException {
      String sql = "UPDATE cliente set nombre = '" + cliente.getNombre() + "',  edad = " + cliente.getEdad()
      + " WHERE codigo = '" + cliente.getDni()+"'";
            persistencia.update(sql);
   }
   
}
