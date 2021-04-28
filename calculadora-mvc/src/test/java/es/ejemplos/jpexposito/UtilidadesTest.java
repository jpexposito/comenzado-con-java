package es.ejemplos.jpexposito;

import es.ejemplos.jpexposito.api.Operacion;

public class UtilidadesTest {
   
   double numero1 = 1.0;
   double numero2 = 1.0;
   char operando = '+';
   
   protected Operacion generarOperacion(double numero1, double numero2, char operando) {
      Operacion operacion = null;
      
      operacion = new Operacion();
      operacion.setNumero1(numero1);
      operacion.setNumero2(numero2);
      operacion.setOperando(operando);
      
      return operacion;
  }
}
