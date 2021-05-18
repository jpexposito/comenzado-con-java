package es.ejemplos.jpexposito.modelo;

import es.ejemplos.jpexposito.exception.PersistenciaException;

public class CuentaModelo{

   DdBbSqLite ddBbSqLite;
   
   public CuentaModelo() throws PersistenciaException {
      ddBbSqLite = new DdBbSqLite(null, null);
      
   }


   
}
