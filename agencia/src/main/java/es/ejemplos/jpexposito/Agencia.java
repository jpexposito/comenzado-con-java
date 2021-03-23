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
     * Constructor por defecto
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

    /**
     * Metodo que inserta un elemento en la lista si no existe
     * @param destino a insertar
     * @throws DestinoException error controlado
     */
    public void insertar(Destino destino) throws DestinoException {
        if (!existeDestino(destino)) {
            destinos.add(destino);
        } else {
            throw new DestinoException("El destino ya existe en la lista");
        }
    }

    /**
     * Funcion que determina si existe un destino en la lista
     * @param destino a verificar
     * @return true/false
     */
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

    
    /**
     * Funcion que determina la lista de ciudades para un determinado dni
     * @param dni del pasajero
     * @return lista de ciudades
     */
    public ArrayList <String> listaCiudadas(String dni) {
        ArrayList<String> lista = new ArrayList<>();

        int i = 0;
        while (i < pasajeros.size()) {
            if (!lista.contains(pasajeros.get(i).getCiudad())) {
                lista.add(pasajeros.get(i).getCiudad());
            }
            i++;
        }
        return lista;
    }

    /**
     * Funcion que determina la cantidad de viajeros en una ciudad
     * @param ciudad a evaluar
     * @return numero de viajes
     */
    public int viajerosCiudad(String ciudad) {
        int cantidad = 0;

        for (Pasajero pasajero:pasajeros) {
            if (pasajero.getCiudad().equals(ciudad)) {
                cantidad++;
            }
        }
        return cantidad;
    }    

    /**
     * Funcion que determina la cantidad paises a los que viaja un pasajero
     * @param dni a comprobar
     * @return paises a los que viaja el viajero
     */
    public ArrayList<String> paisesPasajero(String dni) {
        ArrayList<String> paises = new ArrayList<>();

        for (Pasajero pasajero:pasajeros) {
            if (pasajero.getDni().equals(dni)) {
                String pais = obtenerPais(pasajero.getCiudad());
                if (!paises.contains(pais)) {
                    paises.add(pais);
                }
            }
        }
        return paises;
    }
    
    /**
     * Funcion que obtiene el pais asociado a un destino
     * @param ciudad del detino
     * @return pais de la ciudad si existe
     */
    private String obtenerPais(String ciudad) {
        String pais = null;
        boolean encontrado = false;
        int i = 0;

        while (i < destinos.size() && !encontrado) {
            Destino destino = destinos.get(i);
            if (destino.getCiudad().equals(ciudad)) {
                pais = destino.getPais();
                encontrado = true;
            }
            i++;
        }
        return pais;
    }

    /**
     * Funcion que determina el numero de viajes en un pais
     * @param pais sobre el que se determina la busqueda
     * @return numero de viajes
     */
    public int pasajetosEnPais(String pais) {
        int cantidad = 0;

        for (Destino destino : destinos) {
            if (destino.getPais().equals(pais)) {
                String ciudad = destino.getCiudad();
                for (Pasajero pasajero : pasajeros) {
                    if (pasajero.getCiudad().equals(ciudad) ) {
                        cantidad++;
                    }
                }
            }
        }
        return cantidad;
    }

}
