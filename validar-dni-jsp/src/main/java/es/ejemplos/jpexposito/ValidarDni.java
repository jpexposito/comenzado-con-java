package es.ejemplos.jpexposito;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarDni {
   String dni;

   public String getDni() {
      return this.dni;
   }

   public void setDni(String dni) {
      this.dni = dni;
   }

   public Boolean validar() {
      boolean correcto = false;
      Pattern pattern = Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
      Matcher matcher = pattern.matcher(dni);

      if (matcher.matches()) {
         String letra = matcher.group(2);
         String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
         int index = Integer.parseInt(matcher.group(1));
         index = index % 23;
         String reference = letras.substring(index, index + 1);
         if (reference.equalsIgnoreCase(letra)) {
            correcto = true;
         } else {
            correcto = false;
         }
      } else {
         correcto = false;
      }
      return correcto;
   }

}
