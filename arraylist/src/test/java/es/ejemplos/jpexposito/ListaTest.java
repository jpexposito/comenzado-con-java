package es.ejemplos.jpexposito;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListaTest {
   Lista lista;
   String dato = "valor1";
   
   @BeforeEach
   public void sepUp() {
      if (lista == null) {
         lista = new Lista();
      }
      lista.insertar(dato);
      
   }

   @AfterEach
   public void alfer() {
      lista.eliminar(dato);
   }

   @Test
   public void insertarTest() {
      assertTrue(lista.existe(dato), "El elemento no se encuentra en la lista");
   } 
   
   @Test
   public void buscarTest() {
      String datoABuscar = lista.buscar(dato);
      assertTrue(datoABuscar.equals(dato), "El elemento encontrado no es el esperado");
   }
}
