package es.ejemplos.jpexposito.vista;

import es.ejemplos.jpexposito.controlador.CuentaControlador;

public class AppVista  {
    static CuentaControlador cuentaControlador;
    public static void main( String[] args ){
        cuentaControlador = new CuentaControlador();
        System.out.println( "Hello World!" );
    }
}
