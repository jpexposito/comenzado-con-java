package es.ejemplos.jpexposito.vista;

import es.ejemplos.jpexposito.api.Fruta;
import es.ejemplos.jpexposito.controlador.FrutaController;
import es.ejemplos.jpexposito.excepcion.FrutaException;

public class AppFruteria {

    FrutaController frutaController;

    public AppFruteria() {
        frutaController = new FrutaController();
    }

    public static void main( String[] args ){
        System.out.println( "Hello World!" );
    }

    public void insertar(Fruta fruta) throws FrutaException {
        frutaController.insertar(fruta);
     }
}
