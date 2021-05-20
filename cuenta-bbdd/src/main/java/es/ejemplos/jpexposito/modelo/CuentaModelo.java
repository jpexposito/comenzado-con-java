package es.ejemplos.jpexposito.modelo;

import es.ejemplos.jpexposito.api.Cuenta;
import es.ejemplos.jpexposito.exception.PersistenciaException;

public class CuentaModelo{

   DdBbSqLite persistencia;
   private static final String TABLA  = "CUENTA";
   private static final String CLAVE  = "CODIGO";
   //ModeloCliente
   
   public CuentaModelo() throws PersistenciaException {
      persistencia = new DdBbSqLite(TABLA, CLAVE, null, null);
      
   }

   public void insertar(Cuenta cuenta) throws PersistenciaException {
      String sql = "INSERT INTO "+TABLA+" (codigo, cliente, email, saldo)"+
      " VALUES ('"+cuenta.getCodigo()+"','"+cuenta.getCliente()+"','"
      +cuenta.getEmail()+"',"+cuenta.getSaldo()+");";
      persistencia.update(sql);
   }

   public void eliminar(Cuenta cuenta) throws PersistenciaException {
      String sql = "DELETE FROM "+TABLA+" WHERE "+CLAVE+" = '" + cuenta.getCodigo() + "'";
      persistencia.update(sql);
   }

   public Cuenta buscar(String codigo) throws PersistenciaException {
      return (Cuenta) persistencia.buscarElemento(codigo);
   }

   public void actualizar(Cuenta cuenta) throws PersistenciaException {
      String sql = "UPDATE cuenta set cliente = '" + cuenta.getCliente() + "',  email = '" + cuenta.getEmail()
            + "',  saldo = '" + cuenta.getSaldo() +"' " + " WHERE codigo = '" + cuenta.getCodigo()+"'";
            persistencia.update(sql);
   }


   
}
