package es.ejemplos.jpexposito.vista;

import es.ejemplos.jpexposito.controlador.UsuarioControlador;

/**
 * Clase encargada de realizar la interfaz de la App
 */
public class AppVista {

    UsuarioControlador usuarioControlador;

    public AppVista() {
        usuarioControlador = new UsuarioControlador();
    }

    public static void main( String[] args ) {
        System.out.println( "Hello World!" );

        // Insertar Usuarios
        // Eliminar Usuarios
        // Listar Usuarios
        // Buscar un usuario
        // Mostrar un Usuario
        // Modificar un Usuario
    }
}
