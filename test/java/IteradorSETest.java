import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IteradorSETest {

    @Test
    void hasNext() {
        ListaSimplementeEnlazada<Integer> lista = new ListaSimplementeEnlazada<>();
        lista.add(1);
        lista.add(2);
        lista.add(3); // La lista ahora es: 3 -> 2 -> 1
        IteradorSE<Integer> iterador = new IteradorSE<>(lista);
        // Verificar que hay elementos al inicio
        assertTrue(iterador.hasNext());

        // Avanzar hasta el final
        iterador.next(); // 3
        iterador.next(); // 2
        iterador.next(); // 1

        // Verificar que no hay más elementos
        assertFalse(iterador.hasNext());
    }

    @Test
    void getDato() {
        ListaSimplementeEnlazada<Integer> lista = new ListaSimplementeEnlazada<>();
        lista.add(1);
        lista.add(2);
        lista.add(3); // La lista ahora es: 3 -> 2 -> 1
        IteradorSE<Integer> iterador = new IteradorSE<>(lista);
        // Obtener el primer dato
        assertEquals(3, iterador.getDato()); // Debe devolver 3
        assertEquals(2, iterador.getDato()); // Debe devolver 2
        assertEquals(1, iterador.getDato()); // Debe devolver 1
    }

    @Test
    void next() {
        ListaSimplementeEnlazada<Integer> lista = new ListaSimplementeEnlazada<>();
        lista.add(1);
        lista.add(2);
        lista.add(3); // La lista ahora es: 3 -> 2 -> 1
        IteradorSE<Integer> iterador = new IteradorSE<>(lista);
        // Verificar que devuelve los elementos en el orden correcto
        assertEquals(3, iterador.next()); // Debe devolver 3
        assertEquals(2, iterador.next()); // Debe devolver 2
        assertEquals(1, iterador.next()); // Debe devolver 1

        // Verificar que no hay más elementos
        assertFalse(iterador.hasNext());
        assertNull(iterador.next());
    }

    @Test
    void delete() {
        ListaSimplementeEnlazada<Integer> lista = new ListaSimplementeEnlazada<>();
        lista.add(1);
        lista.add(2);
        lista.add(3); // La lista ahora es: 3 -> 2 -> 1
        IteradorSE<Integer> iterador = new IteradorSE<>(lista);
        iterador.delete();
        assertEquals(3, iterador.getDato());
        assertEquals(2, lista.getCabeza().getDato());


    }
}