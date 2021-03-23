package es.ejemplos.jpexposito.elementos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.ejemplos.jpexposito.exception.PasajeroExeption;

public class Validacion {

   private String patron = "^[0-9]{8}[A-Z-a-z]";
    
    /**
     * Funcion que evalua si un dni cumple el patron 00000000X o
     * @param valor a evaluar
     * @return true/false en funcion de si es correcto o no
     */
    public void validarDni(String valor) throws PasajeroExeption {
        boolean resultado = false;
        Pattern pattern;
        Matcher matcher;
        
        pattern = Pattern.compile(patron);
        matcher = pattern.matcher(valor);
        resultado = matcher.find();
        if (!resultado) {
            throw new PasajeroExeption("El Dni:" +valor+ ", no tiene un formato correcto");
        }
    }

}
