package es.ejemplos.jpexposito.api;

public class Cuenta {
   String codigo;
   String cliente;
   String email;
   double saldo;

   /** 
    * Constructor por defecto
    */
   public Cuenta () {}

   /**
    * Constructor con parametros
    * @param codigo de la cuenta
    * @param cliente de la cuenta
    * @param email del cliente
    * @param saldo actual de la cuenta
    */
   public Cuenta(String codigo, String cliente, String email, double saldo) {
      this.codigo = codigo;
      this.cliente = cliente;
      this.email = email;
      this.saldo = saldo;
   }




   public String getCodigo() {
      return this.codigo;
   }

   public void setCodigo(String codigo) {
      this.codigo = codigo;
   }

   public String getCliente() {
      return this.cliente;
   }

   public void setCliente(String cliente) {
      this.cliente = cliente;
   }

   public String getEmail() {
      return this.email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public double getSaldo() {
      return this.saldo;
   }

   public void setSaldo(double saldo) {
      this.saldo = saldo;
   }





}
