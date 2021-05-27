package es.ejemplos.jpexposito.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import es.ejemplos.jpexposito.api.Cuenta;
import es.ejemplos.jpexposito.exception.PersistenciaException;

public class CuentaModelo{

   DdBbSqLite persistencia;
   private static final String TABLA  = "CUENTA";
   private static final String CLAVE  = "CODIGO";
   private static final String SQLCREATETABLE = "CREATE TABLE IF NOT EXISTS "+TABLA+" ("
   + " "+CLAVE+" VARCHAR(50) PRIMARY KEY,"
   + "idCodigo VARCHAR(50) NOT NULL,"
   + "nombre VARCHAR(9) NOT NULL,"
   + "apellidos VARCHAR(50) NOT NULL,"
   + "email VARCHAR(50) NOT NULL);";

   public CuentaModelo() throws PersistenciaException {
      persistencia = new DdBbSqLite(TABLA, CLAVE, null, null,SQLCREATETABLE);
      
   }

   /**
    * Metodo que permite insertar un elemento cuenta
    * @param cuenta a insertar
    * @throws PersistenciaException error controlado
    */
   public void insertar(Cuenta cuenta) throws PersistenciaException {
      String sql = "INSERT INTO "+TABLA+" (codigo, cliente, email, saldo)"+
      " VALUES ('"+cuenta.getCodigo()+"','"+cuenta.getCliente()+"','"
      +cuenta.getEmail()+"',"+cuenta.getSaldo()+");";
      persistencia.update(sql);
   }

   /**
    * Metodo que permite eliminar un elemento cuenta
    * @param cuenta a eliminar
    * @throws PersistenciaException error controlado
    */
   public void eliminar(Cuenta cuenta) throws PersistenciaException {
      String sql = "DELETE FROM "+TABLA+" WHERE "+CLAVE+" = '" + cuenta.getCodigo() + "'";
      persistencia.update(sql);
   }



   /**
    * Metodo que permite realizar la busqueda de un elemento cuenta a traves de su codigo
    * @param indentificador (Codigo) de la cuenta
    * @return Cuenta en caso de existit
     * @throws PersistenciaException error controlado
    */
   public Cuenta buscar(String indentificador) throws PersistenciaException {
      Cuenta cuentaEncotrada = null;
      String sql = "SELECT * FROM "+this.TABLA+" WHERE "+this.CLAVE+"='"+indentificador+"'";
      ResultSet resultSet;
      ArrayList<Cuenta> lista  = new ArrayList<>();
      try {
         resultSet = persistencia.buscarElementos(sql);
         lista = buscar(resultSet);
      } catch (PersistenciaException e) {
         throw new PersistenciaException("Se ha producido un error realizando la consulta",e);
      } finally {
         persistencia.closeConecction(persistencia.getConnection(), null, null);
      }
      
      if (lista.size() > 0) {
       cuentaEncotrada = lista.get(0);  
      }
      return cuentaEncotrada;
   }

   /**
    * Funcion encargada de transformar un ResultSet en una lista de resultados
    * @param resultSet de entrada
    * @return lista de Cuentas
    * @throws PersistenciaException error controlado
    */
   private ArrayList<Cuenta> buscar(ResultSet resultSet) throws PersistenciaException {
      ArrayList<Cuenta> lista = new ArrayList<>();
      try {
         while(resultSet.next()) {
            Cuenta cuenta = new Cuenta();
            cuenta.setCodigo(resultSet.getString("codigo"));
            cuenta.setCliente(resultSet.getString("cliente"));
            cuenta.setEmail(resultSet.getString("email"));
            cuenta.setSaldo(resultSet.getDouble("saldo"));
            lista.add(cuenta);
         }
      } catch (SQLException e) {
         throw new PersistenciaException("Se ha producido un error realizando la transformacion a Cuenta", e);
      } finally {
         persistencia.closeConecction(null, null, resultSet);
      }
      return lista;
   }

   /**
    * Metodo que permite realizar la actualizacion de una cuenta
    * @param cuenta a actualizar
     * @throws PersistenciaException error controlado 
    */
   public void actualizar(Cuenta cuenta) throws PersistenciaException {
      String sql = "UPDATE cuenta set cliente = '" + cuenta.getCliente() + "',  email = '" + cuenta.getEmail()
            + "',  saldo = '" + cuenta.getSaldo() +"' " + " WHERE codigo = '" + cuenta.getCodigo()+"'";
            persistencia.update(sql);
   }
   
}
