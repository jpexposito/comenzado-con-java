package es.ejemplos.jpexposito;

public class ValidarUsuario {
 
   private String usuario;
   private String password;

   /**
    * Funcion encargada de realizar la validacion del usuario
    * @param usuario
    * @param password
    * @return
    */
   public boolean validate(String usuario, String password){
      System.out.println("Valor de this.usuario:"+this.usuario);
      System.out.println("Valor de usuario:"+usuario);
      System.out.println("Valor de this.password:"+this.password);
      System.out.println("Valor de password:"+password);
      
       if (usuario.equals(this.usuario) && usuario.equals(this.password))
           return true;
       else
           return false;
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
