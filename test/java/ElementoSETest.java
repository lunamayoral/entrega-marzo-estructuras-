import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementoSETest {

    @Test
    void getSiguiente() {
        ElementoSE<Integer> elemento1 = new ElementoSE<>(2);
        ElementoSE<Integer> elemento2 = new ElementoSE<>(3);
        elemento1.setSiguiente(elemento2);
        assertEquals(elemento2, elemento1.getSiguiente());
    }

    @Test
    void setSiguiente() {
        ElementoSE<Integer> elemento1 = new ElementoSE<>(2);
        ElementoSE<Integer> elemento2 = new ElementoSE<>(3);
        elemento1.setSiguiente(elemento2);
        assertEquals(elemento2, elemento1.getSiguiente());

        ElementoSE<Integer> nuevoSiguiente = new ElementoSE<>(3);
        elemento1.setSiguiente(nuevoSiguiente);

        // Verificar que el siguiente elemento ha cambiado
        assertEquals(nuevoSiguiente, elemento1.getSiguiente());
    }

    @Test
    void getDato() {
        ElementoSE<Integer> elemento1 = new ElementoSE<>(2);
        assertEquals(2, elemento1.getDato());
    }

    @Test
    void setDato() {
        ElementoSE<Integer> elemento1 = new ElementoSE<>(2);
        elemento1.setDato(3);
        assertEquals(3, elemento1.getDato());
    }
}