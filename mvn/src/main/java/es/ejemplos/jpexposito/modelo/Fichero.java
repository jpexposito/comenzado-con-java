package es.ejemplos.jpexposito.modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import es.ejemplos.jpexposito.api.Fruta;
import es.ejemplos.jpexposito.excepcion.FicheroException;


public class Fichero {
   
   private static final String SE_HA_PRODUCIDO_UN_ERROR_EN_EL_VOLCADO_DEL_FICHERO = "Se ha producido un error en el volcado del fichero";
   private static final String RETORNO_CARRO = "\n";
   private static final String NOMBRE_FICHERO = "Fichero-frutas.txt";
   

   /**
    * Metodo encargado de almacenar una fruta en el fichero
    * @param fruta a insertar
    * @throws FicheroException controlado
    */
   public void insertar(Fruta fruta) throws FicheroException {
      ArrayList<Fruta> listado;
      listado = obtenerListado();
      listado.add(fruta);
      try {
         crear(NOMBRE_FICHERO, listado.toString());
      } catch (FicheroException exception) {
        throw new FicheroException(SE_HA_PRODUCIDO_UN_ERROR_EN_EL_VOLCADO_DEL_FICHERO, exception);
      }
   }

   /**
    * Metodo encargado de eliminar una fruta del fichero
    * @param fruta a eliminar 
    * @throws FicheroException error controlado
    */
   public void eliminar (Fruta fruta) throws FicheroException {
      ArrayList<Fruta> listado;
      listado = obtenerListado();
      listado.remove(fruta);
      try {
         crear(NOMBRE_FICHERO, listado.toString());
      } catch (FicheroException exception) {
        throw new FicheroException(SE_HA_PRODUCIDO_UN_ERROR_EN_EL_VOLCADO_DEL_FICHERO, exception);
      }
   }

   /**
    * Metodo encargado de modificar un elemento del fichero
    * @param frutaAlamcenada elemento a actualizar
    * @param fruta elemento con la informacion actualizada
    * @throws FicheroException
    */
   public void modificar (Fruta frutaAlmacenada, Fruta fruta) throws FicheroException {
      ArrayList<Fruta> listado = obtenerListado(); 
      int posicion = -1;
      posicion = listado.indexOf(frutaAlmacenada);
      listado.remove(posicion);
      listado.add(posicion, fruta);
      crear(NOMBRE_FICHERO, listado.toString());
      
   }

   /**
    * Funcion encargada de obtener el listado de frutas del fichero
    * @return listado de frutas
    * @throws FicheroException
    */
   public ArrayList<Fruta> obtenerListado() throws FicheroException {
      ArrayList<Fruta> lista = new ArrayList<>();
      File fichero = null;
      Scanner scanner = null;

      try {
         fichero = new File(NOMBRE_FICHERO);
         if (!validarFichero(fichero)) {
            throw new FicheroException("El fichero a leer no existe");
         }
         scanner = new Scanner(fichero);
         while (scanner.hasNextLine()) {
            String linea = scanner.nextLine(); // Guardamos la linea en un String
            if (linea != null && !linea.isEmpty()) {
               Fruta fruta = new Fruta(linea);
               lista.add(fruta);
            }
         }
      } catch (FicheroException e) {  
            throw e;
      }catch (Exception e) {
            throw new FicheroException("Se ha producido un error en la lectura del fichero", e);
      } finally {
         if (scanner != null) {
            scanner.close();
         }
      }

      return lista;
   }

   
   /**
    * Funcion encargada de leer un ficher
    * 
    * @param nombre nombre del fichero a leer
    * @throws FicheroException Error controlado en la lectura del fichero
    */
   public String leer(String nombre) throws FicheroException {
      StringBuilder informacion = null;
      File fichero = null;
      Scanner scanner = null;

      try {
         fichero = new File(nombre);
         if (!validarFichero(fichero)) {
            throw new FicheroException("El fichero a leer no existe");
         }
         informacion = new StringBuilder();
         scanner = new Scanner(fichero);

         while (scanner.hasNextLine()) {
            String linea = scanner.nextLine(); // Guardamos la linea en un String
            informacion.append(linea + RETORNO_CARRO);
         }
      } catch (FicheroException e) {  
            throw e;
      }catch (Exception e) {
            throw new FicheroException("Se ha producido un error en la lectura del fichero", e);
      } finally {
         if (scanner != null) {
            scanner.close();
         }
      }
      return informacion.toString();
   }

   /**
    * Metodo encargado de crear un fichero
    * @param nombre del fichero a crear
    * @throws FicheroException
    */
   public void crear(String nombre, String cadenaTexto) throws FicheroException {
      FileWriter fichero = null;
      try {
			fichero = new FileWriter(nombre);
         fichero.write(cadenaTexto + "\n");
		} catch (Exception ex) {
			throw new FicheroException("Se ha producido un error en la escritura del fichero", ex);
		} finally {
         if (fichero != null) {
            try {
               fichero.close();
            } catch (IOException e) {
               throw new FicheroException("No ha sido podible cerrar el fichero", e);
            }
         }
      }

   }

   /**
    * Funcion que verifica si el fichero existo
    * @param fichero
    * @return
    */
   public boolean validarFichero(File fichero) {
      return fichero.exists();
   }

   /**
    * Metodo encargado de elimianr un fichero/directorio
    * @param nombre del fichero/directorio a elimina
    * @throws FicheroException error controlado
    */
   public void eliminar(String nombre) throws FicheroException {
      File fichero = new File(nombre);
      if (validarFichero(fichero)) {
         fichero.delete();
      } else {
         throw new FicheroException("No se puede eliminar un fichero que no existe");
      }
      
   }

   /**
    * Funcion que verifica si se trata de un directorio no
    * @param path de la ruta a validad
    * @return boolean Si/No se trata de un directorio
    */
   public boolean esDirectorio(String path) {
      File fichero = new File(path);
      return fichero.isDirectory();
   }
}
