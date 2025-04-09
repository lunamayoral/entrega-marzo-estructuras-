import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListaSimplementeEnlazadaTest {

    @Test
    void testListaSimplementeEnlazada() {
        Lista<Integer> lista = new ListaSimplementeEnlazada<>();
        lista.add(10);
        lista.add(20);
        lista.add(30);
        lista.delete(20);
        List<Integer> resultado = new ArrayList<>();
        IIterador<Integer> iterador = lista.getIterador();
        while (iterador.hasNext()) {
            resultado.add(iterador.next());
        }
        assertEquals(List.of(30, 10), resultado);
    }

    @Test
    void add() {
        ElementoSE<Integer> elemento1 = new ElementoSE<>(1);
        ListaSimplementeEnlazada<Integer> lista = new ListaSimplementeEnlazada<>(elemento1);
        assertTrue(lista.add(4));
        assertTrue(lista.add(5));
        assertEquals(3, lista.getNumElementos());
        assertEquals(5, lista.getCabeza().getDato());
        ListaSimplementeEnlazada<Integer> lista2 = new ListaSimplementeEnlazada<>();
        assertTrue(lista2.add(4));
        assertEquals(1, lista2.getNumElementos());
    }

    @Test
    void delete() {
        ListaSimplementeEnlazada<Integer> lista = new ListaSimplementeEnlazada<>();
        // Caso 1: Eliminar un elemento del medio
        lista.add(1); // 1
        lista.add(2); // 2 -> 1
        lista.add(3); // 3 -> 2 -> 1
        lista.delete(2);
        assertEquals(2, lista.getNumElementos());
        assertEquals(3, lista.getCabeza().getDato()); // Ahora la cabeza debe ser 3

        // Caso 2: Eliminar el primer elemento
        lista.delete(3);
        assertEquals(1, lista.getNumElementos());
        assertEquals(1, lista.getCabeza().getDato()); // Ahora la cabeza debe ser 1

        // Caso 3: Eliminar el último elemento
        lista.delete(1);
        assertTrue(lista.isEmpty()); // La lista debe estar vacía

        // Caso 4: Intentar eliminar un elemento que no existe
        assertFalse(lista.delete(5)); // No debe eliminar nada, ya que la lista está vacía

        // Caso 5: Eliminar de una lista vacía
        ListaSimplementeEnlazada<Integer> listaVacia = new ListaSimplementeEnlazada<>();
        assertFalse(listaVacia.delete(1)); // No debe eliminar nada, ya que la lista está vacía

        // Caso 6: Eliminar un elemento que no existe en una lista no vacía
        lista.add(4); // 4
        lista.add(3); // 3 -> 4
        assertFalse(lista.delete(5)); // No debe eliminar nada, ya que 5 no está en la lista
        assertEquals(2, lista.getNumElementos()); // La lista debe seguir teniendo 2 elementos
        assertEquals(3, lista.getCabeza().getDato()); // La cabeza debe seguir siendo 3

    }

    @Test
    void getNumElementos() {
        ListaSimplementeEnlazada<Integer> lista = new ListaSimplementeEnlazada<>();
        lista.add(4);
        lista.add(3);
        assertEquals(2, lista.getNumElementos());
    }

    @Test
    void getIterador() {
        ListaSimplementeEnlazada<Integer> lista = new ListaSimplementeEnlazada<>();
        // Agregar elementos a la lista
        lista.add(1);
        lista.add(2);
        lista.add(3);

        // Obtener el iterador
        IIterador<Integer> iterador = lista.getIterador();

        // Verificar que el iterador tiene elementos
        assertTrue(iterador.hasNext());

        // Verificar los elementos en el orden correcto
        assertEquals(3, iterador.next());
        assertEquals(2, iterador.next());
        assertEquals(1, iterador.next());

        // Verificar que no hay más elementos
        assertFalse(iterador.hasNext());
    }

    @Test
    void getCabeza() {
        ListaSimplementeEnlazada<Integer> lista = new ListaSimplementeEnlazada<>();
        lista.add(4);
        lista.add(3);
        assertEquals(3, lista.getCabeza().getDato());
    }

    @Test
    void setCabeza() {
        ListaSimplementeEnlazada<Integer> lista = new ListaSimplementeEnlazada<>();
        lista.add(4);
        lista.add(3);
        ElementoSE<Integer> elemento1 = new ElementoSE<>(1);
        lista.setCabeza(elemento1);
        assertEquals(1, lista.getCabeza().getDato());
    }

    @Test
    void isEmpty() {
        ListaSimplementeEnlazada<Integer> lista = new ListaSimplementeEnlazada<>();
        assertTrue(lista.isEmpty());
        lista.add(4);
        assertFalse(lista.isEmpty());
    }

    @Test
    void getUltimo() {
        ListaSimplementeEnlazada<Integer> lista = new ListaSimplementeEnlazada<>();
        assertNull(lista.getUltimo());
        lista.add(4);
        lista.add(3);
        assertEquals(4, lista.getUltimo().getDato());
    }
}