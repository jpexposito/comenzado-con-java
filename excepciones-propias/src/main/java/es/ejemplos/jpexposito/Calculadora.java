package es.ejemplos.jpexposito;

/**
 * Clase principal de una calculadora con excepticones
 */
public class Calculadora {
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
    }

    /**
     * Funcion encargada de realizar la division de dos numeros enteros
     * @param dividendo de la operacion
     * @param divisor de la operacion
     * @return resultado de la operacion;
     */
    public int division(int dividendo, int divisor) {
        if (divisor <= 0) {
            throw new ArithmeticException("No es posible dividir por 0");
        }
        int resultado = dividendo/divisor;
        
        return resultado;

    }
}
