package es.ejemplos.jpexposito;


import java.util.ArrayList;
import java.util.HashMap;

import es.ejemplos.jpexposito.elementos.*;
import es.ejemplos.jpexposito.exception.AlumnoException;
import es.ejemplos.jpexposito.exception.FicheroException;

public class ClaseArrayList {
    Profesor profesor;
    ArrayList<Alumno> alumnos;
    Fichero fichero;

    public ClaseArrayList() {
        alumnos = new ArrayList<>();
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
        alumnos.add(alumno);
    }

    /**
     * Funcion que devuelve a un alumno por su posicion en la lista
     * @param posicion
     * @return Objeto alumno
     */
    public Alumno buscar(Integer posicion) {
        Alumno alumno = null;
        int i = 0;
        while(i < alumnos.size()) {
            if (alumnos.get(i).getPosicion() == posicion) {
                alumno = alumnos.get(i);
                break;
            }
            i++;
        }
        return alumno;
    } 

    /**
     * Funcion que verifica si existe un alumno
     * @param alumno a encontrar
     * @return true/false
     */
    public boolean existe(Alumno alumno) {
        boolean existeAlumno = false;
        existeAlumno = alumnos.contains(alumno);
        return existeAlumno;
    } 
    
    /**
     * Metodo que elimina un elemento de la lista
     * @param posicion
     */
    public void eliminar(Integer posicion) {
        Alumno alumno = buscar(posicion);
        if (alumno != null) {
            alumnos.remove(alumno);
        }
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
