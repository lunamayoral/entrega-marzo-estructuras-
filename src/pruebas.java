import java.util.ArrayList;

public class pruebas {
    public static void main(String[] args) {
        ArbolBinarioDeBusqueda<Integer, String> arbol = new ArbolBinarioDeBusqueda<>();
        arbol.addNodo(10, "Raíz");
        arbol.addNodo(5, "Izquierda");
        arbol.addNodo(15, "Derecha");
        int gradoMaximo = arbol.getGrado();
        System.out.println("El grado máximo del árbol es: " + gradoMaximo);




        NodoABB<Integer, String> root = new NodoABB<>(50, "Root");
        NodoABB<Integer, String> left = new NodoABB<>(30, "Left");
        NodoABB<Integer, String> right = new NodoABB<>(70, "Right");
        NodoABB<Integer, String> leftLeft = new NodoABB<>(20, "LeftLeft");
        NodoABB<Integer, String> leftRight = new NodoABB<>(40, "LeftRight");

        root.setMenor(left);
        root.setMayor(right);
        left.setMenor(leftLeft);
        left.setMayor(leftRight);

        // Inicializa el método
        ArbolBinarioDeBusqueda<Integer, String> tree = new ArbolBinarioDeBusqueda<>();
        NodoABB<Integer, String> node= new NodoABB<>(20, "LeftRight");

        // Caso 1: Nodo existente
        System.out.println("Caso 1: Nodo existente (40):");
        System.out.println(tree.getCamino(40, root));

        // Caso 2: Nodo no existente
        System.out.println("Caso 2: Nodo no existente (100):");
        System.out.println(tree.getCamino(100, root));

        // Caso 3: Árbol vacío
        System.out.println("Caso 3: Árbol vacío:");
        System.out.println(tree.getCamino(50, null));



        NodoABB<Integer, String> nodo1 = new NodoABB<>(1, "Raíz");
        NodoABB<Integer, String> nodo2 = new NodoABB<>(2, "Izquierdo");
        NodoABB<Integer, String> nodo3 = new NodoABB<>(3, "Derecho");


        nodo1.setMenor(nodo2);
        nodo1.setMayor(nodo3);


        ArbolBinarioDeBusqueda<Integer, String> recorridos = new ArbolBinarioDeBusqueda<>();


        ArrayList<NodoABB<Integer, String>> preOrden = new ArrayList<>();
        ArrayList<NodoABB<Integer, String>> OrdenCentral = new ArrayList<>();
        ArrayList<NodoABB<Integer, String>> postOrden = new ArrayList<>();


        recorridos.recorrerPreOrden(nodo1);
        recorridos.recorrerOrdenCentral(nodo1);
        recorridos.recorrerPostOrden(nodo1);


        System.out.println(preOrden);
        System.out.println(OrdenCentral);
        System.out.println(postOrden);

    }
}
