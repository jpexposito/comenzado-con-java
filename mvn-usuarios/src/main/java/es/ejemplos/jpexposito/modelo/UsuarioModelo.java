package es.ejemplos.jpexposito.modelo;

import es.ejemplos.jpexposito.api.Usuario;
import es.ejemplos.jpexposito.exceptions.PersistenciaException;

public class UsuarioModelo {
   //Fichero persistencia;
   DerbyBddd persistencia;
   MySqlDbdd persistenciaMySql;
   Fichero persistenciaFichero;

   /**
    * Constructor por defecto 
    */
   public UsuarioModelo() {
      persistencia = new DerbyBddd("org.apache.derby.jdbc.EmbeddedDriver", "derbi.db",null,null);
      persistenciaMySql = new MySqlDbdd("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/test", "usuario", "password");
      persistenciaFichero = new Fichero();
   }
   

   /**
    * Metodo encargado de realizar la insercion de un usuario
    * @param usuario a insertar
    * @throws FicheroException controlada
    * @throws PersistenciaException
    */
   public void insertar(Usuario usuario) throws  PersistenciaException {
      persistencia.insertar(usuario);
      persistenciaFichero.insertar(usuario);
   }

   /**
    * Metodo encargado de realizar la eleminacion de un usuario
    * @param usuario a eliminar
    * @throws FicheroException controlada
    */
   public void eleminar(Usuario usuario) throws  PersistenciaException {
      persistencia.eliminar(usuario.getIdentificador());
   }

   /**
    * Metodo encargado de realizar la modificacion de un usuario
    * @param usuario a modificar
    * @throws PersistenciaException
    */
   public void modificar(Usuario usuario) throws PersistenciaException {
      persistencia.update(usuario);
   }

   /**
    * Funcion encargada de realizar la busqueda de un usuario
    * @param identificador del usuario
    * @return Usuario a buscar
    * @throws FicheroException
    */
   public Usuario buscar(String identificador) throws  PersistenciaException {
     Usuario usuario = null;
     usuario = persistencia.buscarUsuario(identificador);
     return usuario;
   }
}
