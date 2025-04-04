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

        // Inicializa
        ArbolBinarioDeBusqueda<Integer, String> tree = new ArbolBinarioDeBusqueda<>();
        NodoABB<Integer, String> node = new NodoABB<>(20, "LeftRight");

        // Caso 1: Nodo existente
        System.out.println("Caso 1: Nodo existente (40):");
        System.out.println(tree.getCamino(40, root));

        // Caso 2: Nodo no existente
        System.out.println("Caso 2: Nodo no existente (100):");
        System.out.println(tree.getCamino(100, root));

        // Caso 3: Árbol vacío
        System.out.println("Caso 3: Árbol vacío:");
        System.out.println(tree.getCamino(50, null));



        NodoABB<Integer, String> aa = new NodoABB<>(50, "R");
        NodoABB<Integer, String> ab = new NodoABB<>(30, "L");
        NodoABB<Integer, String> ac = new NodoABB<>(70, "R");
        NodoABB<Integer, String>  ad = new NodoABB<>(20, "LL");
        NodoABB<Integer, String> ae = new NodoABB<>(40, "LR");
        NodoABB<Integer, String> af = new NodoABB<>(60, "RL");
        NodoABB<Integer, String> ag = new NodoABB<>(80, "RR");

        aa.setMenor(ab);
        aa.setMayor(ac);
        ab.setMenor(ad);
        ab.setMayor(ae);
        ac.setMenor(af);
        ac.setMayor(ag);


        ArbolBinarioDeBusqueda<Integer, String> arbolito = new ArbolBinarioDeBusqueda<>();
        ListaSimplementeEnlazada todos = new ListaSimplementeEnlazada();
        arbolito.recorrerPreOrden(aa, todos);
        System.out.println(arbolito);

    }








}
