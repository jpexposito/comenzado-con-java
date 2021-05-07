package es.ejemplos.jpexposito.modelo;

import java.util.ArrayList;

import es.ejemplos.jpexposito.api.Usuario;
import es.ejemplos.jpexposito.excepcion.BbddException;
import es.ejemplos.jpexposito.excepcion.FicheroException;

public class UsuarioModelo {
   //Fichero persistencia;
   DerbyBddd persistencia;

   /**
    * Constructor por defecto 
    */
   public UsuarioModelo() {
      persistencia = new DerbyBddd("org.apache.derby.jdbc.EmbeddedDriver", "derbi.db",null,null);
   }
   

   /**
    * Metodo encargado de realizar la insercion de un usuario
    * @param usuario a insertar
    * @throws FicheroException controlada
    * @throws BbddException
    */
   public void insertar(Usuario usuario) throws FicheroException, BbddException {
      persistencia.insertar(usuario);
   }

   /**
    * Metodo encargado de realizar la eleminacion de un usuario
    * @param usuario a eliminar
    * @throws FicheroException controlada
    */
   public void eleminar(Usuario usuario) throws FicheroException, BbddException {
      persistencia.eliminar(usuario);
   }

   /**
    * Metodo encargado de realizar la modificacion de un usuario
    * @param usuario a modificar
    */
   public void modificar(Usuario usuario) {
     
   }

   /**
    * Funcion encargada de realizar la busqueda de un usuario
    * @param identificador del usuario
    * @return Usuario a buscar
    * @throws FicheroException
    */
   public Usuario buscar(String identificador) throws FicheroException, BbddException {
     Usuario usuario = null;
     usuario = persistencia.buscarUsuario(identificador);
     return usuario;
   }
}
