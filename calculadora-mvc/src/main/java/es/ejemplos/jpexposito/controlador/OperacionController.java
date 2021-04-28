package es.ejemplos.jpexposito.controlador;

import javax.management.openmbean.OpenDataException;

import es.ejemplos.jpexposito.api.Operacion;
import es.ejemplos.jpexposito.exceptions.OperacionException;
import es.ejemplos.jpexposito.modelo.OperacionModelo;

public class OperacionController {
   private static final char SUMA = '+';
   private static final char RESTA = '-';
   private static final char MULTIPLICACION = '*';
   private static final char DIVISION = '/';
   OperacionModelo operacionModelo;
   
   public OperacionController() {
      if (operacionModelo == null) {
         operacionModelo = new OperacionModelo();
      }
   }

   /**
    * Metodo encargado de realizar la validacion del objeto operacion
    * @param operacion a validar
    * @throws OperacionException error controlado
    */
   public void validar(Operacion operacion) throws OperacionException {
      String mensaje = "";
      if (operacion == null) {
         mensaje = "No se puede realizar la operacion con un objeto null";
         throw new OperacionException(mensaje);
      }
      if (operacion.getNumero1() < 0) {
         mensaje += "El numero 1 debe de ser mayor o igual a 0";
      }
      if (operacion.getNumero2() < 0) {
         mensaje += "El numero 2 debe de ser mayor o igual a 0";
      }
      if (operacion.getOperando() == ' ' ) {
         mensaje += "El operador debe de estar relleno";
      }
      if (!mensaje.isEmpty()) {
         throw new OperacionException(mensaje);
      }
   }
   /**
    * Funcion que suma
    * @param operacion objeto a sumar
    * @return devuelve el resultado de la suma
    * @throws OperacionException error controlado
    */
    public void verificarOperacion (Operacion operacion, char operando) throws OperacionException {
      validar(operacion);
      if (operacion.getOperando() != operando) {
         throw new OperacionException("Se esta intentando realizar una operacion incorrecta que no es " +operando);
      }
   }

   /**
    * Funcion que suma
    * @param operacion objeto a sumar
    * @return devuelve el resultado de la suma
    * @throws OperacionException error controlado
    */
   public double suma (Operacion operacion) throws OperacionException {
      verificarOperacion(operacion, SUMA);
      operacion.setResultado(operacion.getNumero1() + operacion.getNumero2());
      return operacion.getResultado();
   }

   /**
    * Funcion que realiza la resta
    * @param operacion objeto a resta
    * @return devuelve el resultado de la resta
    * @throws OperacionException error controlado
    */
    public double resta (Operacion operacion) throws OperacionException {
      verificarOperacion(operacion, RESTA);
      operacion.setResultado(operacion.getNumero1() - operacion.getNumero2());
      return operacion.getResultado();
   }

   /**
    * Funcion que realiza la multiplicacion
    * @param operacion objeto a multiplicacion
    * @return devuelve el resultado de la multiplicacion
    * @throws OperacionException error controlado
    */
    public double multiplicacion (Operacion operacion) throws OperacionException {
      verificarOperacion(operacion, MULTIPLICACION);
      operacion.setResultado(operacion.getNumero1() * operacion.getNumero2());
      return operacion.getResultado();
   }

   /**
    * Funcion que realiza la division
    * @param operacion objeto a division
    * @return devuelve el resultado de la division
    * @throws OperacionException error controlado
    */
    public double division (Operacion operacion) throws OperacionException {
      verificarOperacion(operacion, DIVISION);
      if (operacion.getNumero2() == 0) {
         throw new OperacionException("No se puede realizar la division por 0");
      }
      operacion.setResultado(operacion.getNumero1() / operacion.getNumero2());
      return operacion.getResultado();
   }

}
