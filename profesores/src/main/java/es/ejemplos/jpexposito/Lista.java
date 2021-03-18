package es.ejemplos.jpexposito;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.Policy;
import java.util.ArrayList;

import es.ejemplos.jpexposito.elementos.Profesor;

public class Lista {
   ArrayList<Profesor> lista;

   /**
    * Constructor por defecto de lista
    */
   public Lista() {
      lista = new ArrayList<>();
   }

   /**
    * Metodo encargado de realizar la insercion en la lista
    * @param profesor a insertar
    * @throws ProfesorException
    */
   public void insertar(Profesor profesor) throws ProfesorException {
      if (!existe(profesor)) {
         lista.add(profesor);
      } else {
         throw new ProfesorException("El profesor, con dni:"+profesor.getDni()
         +", ya existe en la lista");
      } 
   }

   /**
    * Funcion encargada de verificar que existe el profesor en la lista
    * @param profesor a buscar
    * @return existe true/false
    */
   public boolean existe(Profesor profesor) {
      /** 
      boolean existe = false;
      int i = 0;
         while (i < lista.size() && ! existe) {
            if (profesor.getDni().equals(lista.get(i).getDni())) {
               existe = true;
            }
            i++;
         }

      return existe;
      **/
      return lista.contains(profesor);
   }

   /**
    * Funcion encargada de eliminar un elemento de la lista
    * @param profesor a eliminar
    */
   public void eliminar (Profesor profesor) {
      lista.remove(profesor);
   }

   /**
    * Funcion encargada de listar los elementos de la lista
    * @return String con todos los elementos de la lista
    */
   public String listar() {
      return lista.toString();

      /**
      int i = 0;
      while (i < lista.size()) {
         lista.get(i).toString();
         i++;
      }
      */
   }

   /**
    * Metodo encargado de almacenar la informacion de la lista
    
   public void almacenarDatos(String nombreFichero) {
      FileWriter myWriter;
      try {
         myWriter = new FileWriter(nombreFichero);
         myWriter.write(listar());
         
      } catch (IOException e) {
         // TODO Debe de existir un error controlado
         // th...
      } finally {
         try {
            myWriter.close();
         } catch (IOException e) {
            throw new Exception("");
         }
      }
     
      */
   }


}
