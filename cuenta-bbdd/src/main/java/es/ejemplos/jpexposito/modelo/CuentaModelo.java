package es.ejemplos.jpexposito.modelo;

import es.ejemplos.jpexposito.api.Cuenta;
import es.ejemplos.jpexposito.exception.PersistenciaException;

public class CuentaModelo{

   DdBbSqLite persistencia;
   
   public CuentaModelo() throws PersistenciaException {
      persistencia = new DdBbSqLite(null, null);
      
   }

   public void insertar(Cuenta cuenta) throws PersistenciaException {
      persistencia.insertar(cuenta);
   }

   public void eliminar(Cuenta cuenta) throws PersistenciaException {
      persistencia.eliminar(cuenta.getCodigo());
   }

   public Cuenta buscar(String codigo) throws PersistenciaException {
      return persistencia.buscarCuenta(codigo);
   }


   
}
