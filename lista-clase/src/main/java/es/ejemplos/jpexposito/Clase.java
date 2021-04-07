package es.ejemplos.jpexposito;

import java.io.File;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import es.ejemplos.jpexposito.elementos.*;
import es.ejemplos.jpexposito.exception.AlumnoException;
import es.ejemplos.jpexposito.exception.FicheroException;

public class Clase {
    Profesor profesor;
    HashMap<Integer, Alumno> alumnos;
    Fichero fichero;

    public Clase() {
        alumnos = new HashMap<>();
    }

    /**
     * Metodo que inserta un alumno en la lista
     * @param alumno a insertar
     * @throws AlumnoException
     */
    public void insertar(Alumno alumno) throws AlumnoException {
        if (existe(alumno)) {
            throw new AlumnoException("El alumno ya se encuentra en la lista");
        }
        alumnos.put(alumno.getPosicion(), alumno);
    }

    /**
     * Funcion que devuelve a un alumno por su posicion en la lista
     * @param posicion
     * @return Objeto alumno
     */
    public Alumno buscar(Integer posicion) {
        Alumno alumno = null;
        alumno = alumnos.get(posicion);
        return alumno;
    } 

    /**
     * Funcion que verifica si existe un alumno
     * @param alumno a encontrar
     * @return true/false
     */
    public boolean existe(Alumno alumno) {
        Alumno alumnoAencontrar;
        alumnoAencontrar = buscar(alumno.getPosicion());
        if (alumnoAencontrar != null) {
            return true;
        }
        else return false;
    } 
    
    /**
     * Metodo que elimina un elemento de la lista
     * @param posicion
     */
    public void eliminar(Integer posicion) {
        alumnos.remove(posicion);
    }

    /**
     * Funcion que muestra el contenido de la lista
     * @return String con los elementos
     */
    public String mostrarLista() {
        return alumnos.toString();
    }

    /**
     * Metodo que permite almacenar en un fichera
     * @param nombreFichero
     * @throws FicheroException
     */
    public void volcarAfichero(String nombreFichero) throws FicheroException {
    
        if (fichero == null) {
            fichero = new Fichero();
        }
        String cadena = mostrarLista();

        fichero.crear(nombreFichero, cadena);
    }

    

}
