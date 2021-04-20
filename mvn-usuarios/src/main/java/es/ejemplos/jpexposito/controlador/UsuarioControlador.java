package es.ejemplos.jpexposito.controlador;

import es.ejemplos.jpexposito.api.Usuario;
import es.ejemplos.jpexposito.exceptions.UsuarioException;
import es.ejemplos.jpexposito.modelo.UsuarioModelo;

public class UsuarioControlador {

   private static final String EL_IDENTIFICADOR_ES_NULO_O_VACIO = "El identificador es nulo o vacio";
   private static final int EDAD_MINIMA = 18;
   UsuarioModelo usuarioModelo;

   public UsuarioControlador() {
      usuarioModelo = new UsuarioModelo();
   }

   /**
    * Medodo encargado de validar los parametros del usuario
    * @param usuario a validar
    * @throws UsuarioException exception personalizada del error
    */
   public void validar(Usuario usuario) throws UsuarioException {
      String mensaje = "";

      if (usuario == null) {
         mensaje = "El usuario es nulo";
         throw new UsuarioException(mensaje);
      }
      if (usuario.getIdentificador() == null || usuario.getIdentificador().isEmpty()) {
         mensaje = "El identificador es nulo o vacio,";
      }

      if (usuario.getNombre() == null || usuario.getNombre().isEmpty()) {
         mensaje += "El nombre es nulo o vacio,";
      }

      if (usuario.getApellidos() == null || usuario.getApellidos().isEmpty()) {
         mensaje += "Los apellidos es nulo o vacio,";
      }
      if (usuario.getEdad() < EDAD_MINIMA) {
         mensaje += "La edad es menor a "+EDAD_MINIMA;
      }

      if (!mensaje.isEmpty()) {
         throw new UsuarioException(mensaje);
      }

   }

   /**
    * Metodo encargado de realizar la insercion de un usuario
    * @param usuario a insertar
    * @throws UsuarioException controlada
    */
   public void insertar(Usuario usuario) throws UsuarioException {
      validar(usuario);

   }

    /**
    * Metodo encargado de realizar la eliminacion de un usuario
    * @param usuario a eliminar
    * @throws UsuarioException
    */
   public void eliminar(Usuario usuario) throws UsuarioException {
      validar(usuario);
   }

    /**
    * Metodo encargado de realizar la modificacion de un usuario
    * @param usuario a modificar
    * @throws UsuarioException controlada
    */
   public void modificar(Usuario usuario) throws UsuarioException {
      validar(usuario);
   }
   /**
    * Funcion que realiza la busqueda de un usuario
    * @param identificador del usuario
    * @throws UsuarioException
    */
   public void buscar(String identificador) throws UsuarioException {
      if (identificador == null || identificador.isEmpty()) {
         throw new UsuarioException(EL_IDENTIFICADOR_ES_NULO_O_VACIO);
      }
   }

   /**
    * Funcion que muestra un usuario 
    * @param identificador del usuario a mostrar
    * @throws UsuarioException
    */
   public void mostrar(String identificador) throws UsuarioException {
      if (identificador == null || identificador.isEmpty()) {
         throw new UsuarioException(EL_IDENTIFICADOR_ES_NULO_O_VACIO);
      }
   }

   /**
    * Funcion encargada de mostrar todos los usuarios
    */
   public void mostrarTodos() {

   }

   
}
