import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodoABBTest {

    @Test
    void setMenor() {
        NodoABB<Integer, Integer> nodo1 = new NodoABB<>(5, 3);
        NodoABB<Integer, Integer> nodo2 = new NodoABB<>(3, 2);
        nodo1.setMenor(nodo2);
        assertEquals(nodo2, nodo1.getMenor());
    }

    @Test
    void setMayor() {
        NodoABB<Integer, Integer> nodo1 = new NodoABB<>(5, 3);
        NodoABB<Integer, Integer> nodo2 = new NodoABB<>(3, 2);
        nodo1.setMayor(nodo2);
        assertEquals(nodo2, nodo1.getMayor());
    }

    @Test
    void getClave() {
        NodoABB<Integer, Integer> nodo = new NodoABB<>(5, 3);
        assertEquals(5, nodo.getClave());
    }

    @Test
    void getValor() {
        NodoABB<Integer, Integer> nodo = new NodoABB<>(5, 3);
        assertEquals(3, nodo.getValor());
    }

    @Test
    void setValor() {
        NodoABB<Integer, Integer> nodo = new NodoABB<>(5, 3);
        nodo.setValor(10);
        assertEquals(10, nodo.getValor());
    }

    @Test
    void setClave() {
        NodoABB<Integer, Integer> nodo = new NodoABB<>(5, 3);
        nodo.setClave(10);
        assertEquals(10, nodo.getClave());
    }

    @Test
    void getMenor() {
        NodoABB<Integer, Integer> nodo1 = new NodoABB<>(5, 3);
        NodoABB<Integer, Integer> nodo2 = new NodoABB<>(3, 2);
        nodo1.setMenor(nodo2);
        assertEquals(nodo2, nodo1.getMenor());
    }

    @Test
    void getMayor() {
        NodoABB<Integer, Integer> nodo1 = new NodoABB<>(5, 3);
        NodoABB<Integer, Integer> nodo2 = new NodoABB<>(7, 4);
        nodo1.setMayor(nodo2);
        assertEquals(nodo2, nodo1.getMayor());
    }

    @Test
    void getGradoNodos() {
        NodoABB<Integer, Integer> nodo = new NodoABB<>(5, 3);
        assertEquals(2, nodo.getGradoNodos(nodo)); // Grado 2 porque no tiene hijos
        nodo.setMenor(new NodoABB<>(3, 2));
        assertEquals(1, nodo.getGradoNodos(nodo)); // Grado 1 porque tiene un hijo
        nodo.setMayor(new NodoABB<>(7, 4));
        assertEquals(0, nodo.getGradoNodos(nodo)); // Grado 0 porque tiene ambos hijos
        NodoABB<Integer, Integer> nodo3 = null;
        assertEquals(0, nodo.getGradoNodos(nodo3));
    }

    @Test
    void StringtoString() {
        NodoABB<Integer, Integer> nodo = new NodoABB<>(5, 3);
        assertEquals("Nodo[3]", nodo.toString());
    }
}