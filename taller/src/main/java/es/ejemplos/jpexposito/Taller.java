package es.ejemplos.jpexposito;

import java.security.KeyStore.Entry;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class Taller {
    ArrayList<String> matriculas;

    public Taller() {
        matriculas = new ArrayList<>();
    }

    /**
     * Metodo encargado de insertar una matricula en la lista
     * @param matricula a insertar
     */
    public void insertar(String matricula) {
        if (!existe(matricula)) {
            matriculas.add(matricula);
        }
    }

    /**
     * Funcion que determina si existe un elemento
     * @param matricula a buscar
     * @return true/false
     */
    public boolean existe(String matricula) {
        return matriculas.contains(matricula);
    }

    public String buscar(String matricula) {
        String matriculaEncontrada = null;
        boolean encontrado = false;

        int i = 0;
        while (i < matriculas.size() && !encontrado) {
            if (matriculas.get(i).equals(matricula)) {
                matriculaEncontrada = matricula; 
                encontrado = true;
             }
            i++;
        }

        return matriculaEncontrada;
    }


 

}
