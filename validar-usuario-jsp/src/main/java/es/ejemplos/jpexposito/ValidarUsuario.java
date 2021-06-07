package es.ejemplos.jpexposito;

import es.ejemplos.jpexposito.exceptions.UsuarioException;

public class ValidarUsuario {
 
   private String usuario;
   private String password;
   private String usuarioAlmancenado = "test";
   private String passwordAlmancenado = "test";




   /**
    * Funcion encargada de realizar la validacion del usuario 
    * @param usuario
    * @param password
    * @return true/false 
    * @throws UsuarioException
    */
   public void validate() throws UsuarioException{
       if (!(usuarioAlmancenado.equals(this.usuario) && passwordAlmancenado.equals(this.password)))
       throw new UsuarioException("El usuario o contraseña no son validos");
        
   }

   public String getUsuario() {
      return this.usuario;
   }

   public void setUsuario(String usuario) {
      this.usuario = usuario;
   }

   public String getPassword() {
      return this.password;
   }

   public void setPassword(String password) {
      this.password = password;
   }


}
