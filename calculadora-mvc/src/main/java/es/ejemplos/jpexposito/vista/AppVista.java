package es.ejemplos.jpexposito.vista;

import java.util.InputMismatchException;
import java.util.Scanner;

import es.ejemplos.jpexposito.api.Operacion;
import es.ejemplos.jpexposito.controlador.OperacionController;
import es.ejemplos.jpexposito.exceptions.OperacionException;

/**
 * Hello world!
 *
 */
public class AppVista {
    static OperacionController operacionController;
    public static void main( String[] args ) throws OperacionException{
        if (operacionController == null) {
            operacionController = new OperacionController();
        }
        menu();
    }

    private static void menu() throws OperacionException {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        Operacion operacion;
        double resultado = 0;
        while (!salir) {
 
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Salir");
            operacion = null;
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        operacion = realizarOperacion('+', sn);
                        resultado = operacionController.suma(operacion);
                        System.out.println("Resultado obtenido:"+resultado);
                        break;
                    case 2:
                        operacion = realizarOperacion('-', sn);
                        resultado = operacionController.resta(operacion);
                        System.out.println("Resultado obtenido:"+resultado);
                        break;
                    case 3:
                        operacion = realizarOperacion('*', sn);
                        resultado = operacionController.multiplicacion(operacion);
                        System.out.println("Resultado obtenido:"+resultado);
                        break;
                    case 4:
                        operacion = realizarOperacion('/', sn);
                        resultado = operacionController.division(operacion);
                        System.out.println("Resultado obtenido:"+resultado);
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar una opcion correcta");
                sn.next();
            }
        }
 
    }

    public static Operacion realizarOperacion(char operando, Scanner sn) {

        System.out.println("Introduzca el valor 1");
        double numero1 = sn.nextDouble();
        System.out.println("Introduzca el valor 2");
        double numero2 = sn.nextDouble();
        Operacion operacion = new Operacion(numero1, numero2, operando);
        return operacion;
    }

}
