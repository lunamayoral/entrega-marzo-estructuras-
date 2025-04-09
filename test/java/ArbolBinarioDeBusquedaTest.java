import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ArbolBinarioDeBusquedaTest {

    @Test
    void getGrado() {
        ArbolBinarioDeBusqueda<Integer, String> arbol = new ArbolBinarioDeBusqueda<>();
        arbol.addNodo(10, "Raíz");
        arbol.addNodo(5, "Izquierda");
        arbol.addNodo(15, "Derecha");
        assertEquals(2, arbol.getGrado()); // Grado máximo de los nodos
    }

    @Test
    void getAltura() {
        ArbolBinarioDeBusqueda<Integer, String> arbol = new ArbolBinarioDeBusqueda<>();
        arbol.addNodo(10, "Raíz");
        arbol.addNodo(5, "Izquierda");
        arbol.addNodo(15, "Derecha");
        assertEquals(1, arbol.getAltura()); // Altura del árbol
    }

    @Test
    void getListaDatosNivel() {
        ArbolBinarioDeBusqueda<Integer, String> arbol = new ArbolBinarioDeBusqueda<>();
        arbol.addNodo(10, "Raíz");
        arbol.addNodo(5, "Izquierda");
        arbol.addNodo(15, "Derecha");
        ListaSimplementeEnlazada<String> lista = arbol.getListaDatosNivel(1);
        assertEquals(2, lista.getNumElementos()); // Debe haber 2 nodos en el nivel 1
    }

    @Test
    void isArbolCompleto() {
        ArbolBinarioDeBusqueda<Integer, String> arbol = new ArbolBinarioDeBusqueda<>();
        arbol.addNodo(10, "Raíz");
        arbol.addNodo(5, "Izquierda");
        arbol.addNodo(15, "Derecha");
        assertTrue(arbol.isArbolCompleto()); // El árbol es completo
        ArbolBinarioDeBusqueda<Integer, String> arbol2 = new ArbolBinarioDeBusqueda<>();
        assertTrue(arbol2.isArbolCompleto());
    }

    @Test
    void isArbolCasiCompleto() {
        ArbolBinarioDeBusqueda<Integer, String> arbol = new ArbolBinarioDeBusqueda<>();
        arbol.addNodo(10, "Raíz");
        arbol.addNodo(5, "Izquierda");
        assertTrue(arbol.isArbolCasiCompleto());
    }

    @Test
    void addNodoRaiz() {
        ArbolBinarioDeBusqueda<Integer, String> arbol = new ArbolBinarioDeBusqueda<>();
        assertTrue(arbol.addNodo(10, "Raíz")); // Agregar la raíz
        assertEquals("Raíz", arbol.raiz.getValor());
    }

    @Test
    void addOtrosNodos() {
        ArbolBinarioDeBusqueda<Integer, String> arbol = new ArbolBinarioDeBusqueda<>();
        arbol.addNodo(10, "Raíz");
        assertTrue(arbol.addNodo(5, "Izquierda")); // Agregar nodo izquierdo
        assertTrue(arbol.addNodo(15, "Derecha")); // Agregar nodo derecho
        assertEquals("Izquierda", arbol.raiz.getMenor().getValor());
        assertEquals("Derecha", arbol.raiz.getMayor().getValor());
    }

    @Test
    void buscarNodoAInsertar() {
        ArbolBinarioDeBusqueda<Integer, String> arbol = new ArbolBinarioDeBusqueda<>();
        arbol.addNodo(10, "Raíz");
        NodoABB<Integer, String> nodo = arbol.buscarNodoAInsertar(5, arbol.raiz);
        assertNotNull(nodo);
        assertEquals(10, nodo.getClave());
    }

    @Test
    void addNodo() {
        ArbolBinarioDeBusqueda<Integer, String> arbol = new ArbolBinarioDeBusqueda<>();
        assertTrue(arbol.addNodo(10, "Raíz"));
        assertTrue(arbol.addNodo(5, "Izquierda"));
        assertTrue(arbol.addNodo(15, "Derecha"));
    }

    @Test
    void getCamino() {
        ArbolBinarioDeBusqueda<Integer, String> arbol = new ArbolBinarioDeBusqueda<>();
        arbol.addNodo(10, "Raíz");
        arbol.addNodo(5, "Izquierda");
        arbol.addNodo(15, "Derecha");

        ArrayList<NodoABB<Integer, String>> camino = arbol.getCamino(5, arbol.raiz);
        assertEquals(2, camino.size());
        assertEquals(10, camino.get(0).getClave());
        assertEquals(5, camino.get(1).getClave());

    }

    @Test
    void recorrerPreOrden() {
        ArbolBinarioDeBusqueda<Integer, String> arbol = new ArbolBinarioDeBusqueda<>();
        arbol.addNodo(10, "Raíz");
        arbol.addNodo(5, "Izquierda");
        arbol.addNodo(15, "Derecha");

        ArrayList<String> lista = arbol.recorrerPreOrden(arbol.raiz, new ArrayList<>());
        assertEquals(3, lista.size());
        assertEquals("Raíz", lista.get(0));
    }

    @Test
    void recorrerOrdenCentral() {
        ArbolBinarioDeBusqueda<Integer, String> arbol = new ArbolBinarioDeBusqueda<>();
        arbol.addNodo(10, "Raíz");
        arbol.addNodo(5, "Izquierda");
        arbol.addNodo(15, "Derecha");

        ArrayList<String> lista = arbol.recorrerOrdenCentral(arbol.raiz, new ArrayList<>());
        assertEquals(3, lista.size());
        assertEquals("Izquierda", lista.get(0));
        assertEquals("Raíz", lista.get(1));
        assertEquals("Derecha", lista.get(2));
    }

    @Test
    void recorrerPostOrden() {
        ArbolBinarioDeBusqueda<Integer, String> arbol = new ArbolBinarioDeBusqueda<>();
        arbol.addNodo(10, "Raíz");
        arbol.addNodo(5, "Izquierda");
        arbol.addNodo(15, "Derecha");

        ArrayList<String> lista = arbol.recorrerPostOrden(arbol.raiz, new ArrayList<>());
        assertEquals(3, lista.size());
        assertEquals("Izquierda", lista.get(0));
        assertEquals("Derecha", lista.get(1));
        assertEquals("Raíz", lista.get(2));
    }

    @Test
    void getSubarbolIzquierdo() {
        ArbolBinarioDeBusqueda<Integer, String> arbol = new ArbolBinarioDeBusqueda<>();
        arbol.addNodo(10, "Raíz");
        arbol.addNodo(5, "Izquierda");
        ArbolBinarioDeBusqueda<Integer, String> subarbolIzquierdo = arbol.getSubarbolIzquierdo(arbol.raiz);
        assertNotNull(subarbolIzquierdo);
        assertEquals(5, subarbolIzquierdo.raiz.getClave());
    }

    @Test
    void getSubarbolDerecho() {
        ArbolBinarioDeBusqueda<Integer, String> arbol = new ArbolBinarioDeBusqueda<>();
        arbol.addNodo(10, "Raíz");
        arbol.addNodo(15, "Derecha");

        ArbolBinarioDeBusqueda<Integer, String> subarbolDerecho = arbol.getSubarbolDerecho(arbol.raiz);
        assertNotNull(subarbolDerecho);
        assertEquals(15, subarbolDerecho.raiz.getClave());
    }

    @Test
    void isArbolHomogeneo() {
        ArbolBinarioDeBusqueda<Integer, String> arbol = new ArbolBinarioDeBusqueda<>();
        arbol.addNodo(10, "Raíz");
        arbol.addNodo(5, "Izquierda");
        arbol.addNodo(15, "Derecha");
        assertTrue(arbol.isArbolHomogeneo());
        ArbolBinarioDeBusqueda<Integer, String> arbol2 = new ArbolBinarioDeBusqueda<>();
        assertTrue(arbol2.isArbolHomogeneo());
    }

    @Test
    void testBuscarNodoRepetido() {
        ArbolBinarioDeBusqueda<Integer, String> arbol = new ArbolBinarioDeBusqueda<>();
        arbol.addNodo(10, "Raíz");
        arbol.addNodo(5, "Izquierda");
        arbol.addNodo(15, "Derecha");

        NodoABB<Integer, String> nodo = arbol.buscarNodoAInsertar(10, arbol.raiz);
        assertNull(nodo);
    }

    @Test
    void testConstructorConNodoRaiz() {
        NodoABB<Integer, String> nodoRaiz = new NodoABB<>(10, "Raíz");
        ArbolBinarioDeBusqueda<Integer, String> arbol = new ArbolBinarioDeBusqueda<>(nodoRaiz);
        assertNotNull(arbol.raiz);
        assertEquals(10, arbol.raiz.getClave());
        assertEquals("Raíz", arbol.raiz.getValor());
        assertNull(arbol.raiz.getMenor());
        assertNull(arbol.raiz.getMayor());
    }

    @Test
    void testIsArbolCasiCompletoVacio() {
        ArbolBinarioDeBusqueda<Integer, String> arbol = new ArbolBinarioDeBusqueda<>();
        assertTrue(arbol.isArbolCasiCompleto()); // Un árbol vacío es casi completo
    }

    @Test
    void testIsArbolCasiCompletoUnSoloNodo() {
        ArbolBinarioDeBusqueda<Integer, String> arbol = new ArbolBinarioDeBusqueda<>();
        arbol.addNodo(10, "Raíz");
        assertTrue(arbol.isArbolCasiCompleto()); // Un árbol con un solo nodo es casi completo
    }

    @Test
    void testIsArbolCasiCompletoCompleto() {
        ArbolBinarioDeBusqueda<Integer, String> arbol = new ArbolBinarioDeBusqueda<>();
        arbol.addNodo(10, "Raíz");
        arbol.addNodo(5, "Izquierda");
        arbol.addNodo(15, "Derecha");
        assertTrue(arbol.isArbolCasiCompleto()); // Un árbol completo es casi completo
    }

    @Test
    void testIsArbolCasiCompletoCasiCompleto() {
        ArbolBinarioDeBusqueda<Integer, String> arbol = new ArbolBinarioDeBusqueda<>();
        arbol.addNodo(10, "Raíz");
        arbol.addNodo(5, "Izquierda");
        arbol.addNodo(15, "Derecha");
        arbol.addNodo(3, "Izquierda de 5");
        assertTrue(arbol.isArbolCasiCompleto()); // Este árbol es casi completo
    }

    @Test
    void testIsArbolCasiCompletoNoCasiCompleto() {
        ArbolBinarioDeBusqueda<Integer, String> arbol = new ArbolBinarioDeBusqueda<>();
        arbol.addNodo(10, "Raíz");
        arbol.addNodo(5, "Izquierda");
        arbol.addNodo(15, "Derecha");
        arbol.addNodo(3, "Izquierda de 5");
        arbol.addNodo(4, "Derecha de 3"); // Agregar un nodo que hace que no sea casi completo
        assertFalse(arbol.isArbolCasiCompleto()); // Ahora no es casi completo
    }

    @Test
    void testBuscarNodoAInsertarEnSubarbolDerechoNoExiste() {
        ArbolBinarioDeBusqueda<Integer, String> arbol = new ArbolBinarioDeBusqueda<>();
        arbol.addNodo(10, "Raíz");
        arbol.addNodo(5, "Izquierda");
        arbol.addNodo(15, "Derecha");

        NodoABB<Integer, String> nodo = arbol.buscarNodoAInsertar(18, arbol.raiz);
        assertNotNull(nodo); // Debería encontrar el nodo padre
        assertEquals(15, nodo.getClave()); // El padre del nodo 18 debería ser 15
    }

    @Test
    void testVerificarHomogeneidad() {
        ArbolBinarioDeBusqueda<Integer, String> arbol = new ArbolBinarioDeBusqueda<>();

    }
}