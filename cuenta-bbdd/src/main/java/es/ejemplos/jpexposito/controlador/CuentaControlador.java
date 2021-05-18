package es.ejemplos.jpexposito.controlador;

import es.ejemplos.jpexposito.exception.PersistenciaException;
import es.ejemplos.jpexposito.modelo.CuentaModelo;

public class CuentaControlador {

   CuentaModelo cuentaModelo;

   public CuentaControlador() throws PersistenciaException {
      cuentaModelo = new CuentaModelo();
   }
   
}
