package es.ejemplos.jpexposito.controlador;

import es.ejemplos.jpexposito.api.Usuario;
import es.ejemplos.jpexposito.exceptions.PersistenciaException;
import es.ejemplos.jpexposito.exceptions.UsuarioException;
import es.ejemplos.jpexposito.modelo.UsuarioModelo;

public class UsuarioControlador {

   private static final String EL_USUARIO_NO_SE_ENCUENTRA_ALMACENADO = "El usuario NO se encuentra almacenado";
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
   private void validar(Usuario usuario) throws UsuarioException {
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
    * @throws FicheroException
    */
   public void insertar(Usuario usuario) throws UsuarioException,  PersistenciaException {
      validar(usuario);
      if (existe(usuario.getIdentificador())) {
         throw new UsuarioException("El usuario se encuentra almacenado");
      }
      usuarioModelo.insertar(usuario);
   }

    /**
    * Metodo encargado de realizar la eliminacion de un usuario
    * @param usuario a eliminar
    * @throws UsuarioException
    * @throws FicheroException
    */
   public void eliminar(Usuario usuario) throws UsuarioException,  PersistenciaException {
      validar(usuario);
      if (!existe(usuario.getIdentificador())) {
         throw new UsuarioException(EL_USUARIO_NO_SE_ENCUENTRA_ALMACENADO);
      } 
      usuarioModelo.eleminar(usuario);
   }

    /**
    * Metodo encargado de realizar la modificacion de un usuario
    * @param usuario a modificar
    * @throws UsuarioException controlada
    * @throws PersistenciaException
    */
   public void modificar(Usuario usuario) throws UsuarioException, PersistenciaException {
      validar(usuario);
      if (!existe(usuario.getIdentificador())) {
         throw new UsuarioException(EL_USUARIO_NO_SE_ENCUENTRA_ALMACENADO);
      }
      usuarioModelo.modificar(usuario);
   }
   /**
    * Funcion que realiza la busqueda de un usuario
    * @param identificador del usuario
    * @return Usuario encontrado
    * @throws UsuarioException error controla
    * @throws FicheroException
    * @throws PersistenciaException
    */
   public Usuario buscar(String identificador) throws UsuarioException,  PersistenciaException { 
      Usuario usuario = null;
      if (identificador == null || identificador.isEmpty()) {
         throw new UsuarioException(EL_IDENTIFICADOR_ES_NULO_O_VACIO);
      }
      usuario = usuarioModelo.buscar(identificador);
      return usuario;
   }

   /**
    * Funcion que muestra un usuario 
    * @param identificador del usuario a mostrar
    * @return informacion del asociada al usuario
    * @throws UsuarioException error controlado
    */
   public String mostrar(String identificador) throws UsuarioException,  PersistenciaException {
      if (identificador == null || identificador.isEmpty()) {
         throw new UsuarioException(EL_IDENTIFICADOR_ES_NULO_O_VACIO);
      }
      Usuario usuario = buscar(identificador);
      if (usuario == null) {
         throw new UsuarioException(EL_USUARIO_NO_SE_ENCUENTRA_ALMACENADO);
      }
      return usuario.toString();
      
   }

   /**
    * Funcion encargada de mostrar todos los usuarios
    */
   public void mostrarTodos() {

   }

   /**
    * Funcion que verifica si un usario existe 
    * @param identificador encontrar
    * @return true/false
    */
   public boolean existe(String identificador) throws UsuarioException,  PersistenciaException {
      boolean encontrado = false;
      Usuario usuario = null;

      usuario = buscar(identificador);
      if (usuario !=null) {
         encontrado = true;
      }

      return encontrado;
   }

   
}
