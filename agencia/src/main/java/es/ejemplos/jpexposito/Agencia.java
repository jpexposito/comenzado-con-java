package es.ejemplos.jpexposito;

import java.util.ArrayList;

import es.ejemplos.jpexposito.elementos.Destino;
import es.ejemplos.jpexposito.elementos.Pasajero;
import es.ejemplos.jpexposito.exception.DestinoException;
import es.ejemplos.jpexposito.exception.PasajeroExeption;

/**
 * Agencia de gestion de pasajeros
 */
public class Agencia {
    ArrayList<Pasajero> pasajeros;
    ArrayList<Destino> destinos;
    

    /**
     * Constructor
     */
    public Agencia() {
        this.pasajeros = new ArrayList<>();
        this.destinos =  new ArrayList<>();
    }

    /**
     * Metodo que inserta un elemento
     * @param pasajero a insertar
     * @throws PasajeroExeption error contrado
     */
    public void insertar(Pasajero pasajero) throws PasajeroExeption {
        if (!existePasaje(pasajero)) {
            pasajeros.add(pasajero);
        } else {
            throw new PasajeroExeption("El pasajero ya existe en la lista");
        }
    }

    public void insertar(Destino destino) throws PasajeroExeption {
        if (!existeDestino(destino)) {
            destinos.add(destino);
        } else {
            throw new DestinoException("El destino ya existe en la lista");
        }
    }

    public boolean existeDestino(Destino destino) {
        return destinos.contains(destino);
    }

    /**
     * Funcion que determina si existe un pasaje
     * @param pasajero a verifica
     * @return true/false
     */
    public boolean existePasaje(Pasajero pasajero) {
        return pasajeros.contains(pasajero);
    }

    
}
