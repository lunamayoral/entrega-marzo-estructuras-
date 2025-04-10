import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class ABBenterosTest {
    ABBenteros arbol= new ABBenteros();

    @Test
    void addNodo() {
        // Insertar nodos en el árbol
        arbol.addNodo(5, 5);
        arbol.addNodo(3, 3);
        arbol.addNodo(7, 7);
        arbol.addNodo(2, 2);
        arbol.addNodo(4, 4);


        // Verificar que la suma es correcta
        int sumaEsperada = 5 + 3 + 7 + 2 + 4; // 21
        assertEquals(sumaEsperada, arbol.getSuma());


        // Verificar que los nodos se insertaron correctamente
        assertEquals(21, arbol.getSuma());
    }


    @Test
    void getSuma() {
        // Calcular la suma en un árbol vacío
        int suma = arbol.getSuma();
        assertEquals(0, suma); // La suma de un árbol vacío debe ser 0


        // Insertar un solo nodo
        arbol.addNodo(10, 10);
        suma = arbol.getSuma();
        assertEquals(10, suma); // La suma debe ser igual al valor del nodo


        // Insertar más nodos
        arbol.addNodo(5, 5);
        arbol.addNodo(15, 15);
        suma = arbol.getSuma();
        assertEquals(10 + 5 + 15, suma); // Verificar la suma total
    }

    @Test
    void sumaPreOrden() {
        // Calcular la suma en un árbol vacío
        int suma = arbol.sumaPreOrden(arbol.raiz);
        assertEquals(0, suma); // La suma de un árbol vacío debe ser 0


        // Insertar un solo nodo
        arbol.addNodo(10, 10);
        suma = arbol.sumaPreOrden(arbol.raiz);
        assertEquals(10, suma); // La suma debe ser igual al valor del nodo


        // Insertar más nodos
        arbol.addNodo(5, 5);
        arbol.addNodo(15, 15);
        suma = arbol.sumaPreOrden(arbol.raiz);
        assertEquals(10 + 5 + 15, suma); // Verificar la suma total

    }

    @Test
    void sumaEnOrden() {
        // Calcular la suma en un árbol vacío
        int suma = arbol.sumaEnOrden(arbol.raiz);
        assertEquals(0, suma); // La suma de un árbol vacío debe ser 0


        // Insertar un solo nodo
        arbol.addNodo(10, 10);
        suma = arbol.sumaEnOrden(arbol.raiz);
        assertEquals(10, suma); // La suma debe ser igual al valor del nodo


        // Insertar más nodos
        arbol.addNodo(5, 5);
        arbol.addNodo(15, 15);
        suma = arbol.sumaEnOrden(arbol.raiz);
        assertEquals(10 + 5 + 15, suma); // Verificar la suma total

    }

    @Test
    void sumaPostOrden() {
        // Calcular la suma en un árbol vacío
        int suma = arbol.sumaPostOrden(arbol.raiz);
        assertEquals(0, suma); // La suma de un árbol vacío debe ser 0


        // Insertar un solo nodo
        arbol.addNodo(10, 10);
        suma = arbol.sumaPostOrden(arbol.raiz);
        assertEquals(10, suma); // La suma debe ser igual al valor del nodo


        // Insertar más nodos
        arbol.addNodo(5, 5);
        arbol.addNodo(15, 15);
        suma = arbol.sumaPostOrden(arbol.raiz);
        assertEquals(10 + 5 + 15, suma); // Verificar la suma total
    }

    @Test
    void getSubarbolIzquierdo() {
        ABBenteros arbol = new ABBenteros();
        arbol.addNodo(10, 10);
        arbol.addNodo(5, 5);
        ABBenteros subarbolIzquierdo = arbol.getSubarbolIzquierdo(arbol.raiz);
        assertNotNull(subarbolIzquierdo);
        assertEquals(5, subarbolIzquierdo.raiz.getClave());
    }

    @Test
    void getSubarbolDerecho() {
        ABBenteros arbol = new ABBenteros();
        arbol.addNodo(10,10 );
        arbol.addNodo(15,15 );

      ABBenteros subarbolDerecho = arbol.getSubarbolDerecho(arbol.raiz);
        assertNotNull(subarbolDerecho);
        assertEquals(15, subarbolDerecho.raiz.getClave());
    }
}