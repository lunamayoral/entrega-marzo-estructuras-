public class pruebas {
    public static void main(String[] args) {
        ArbolBinarioDeBusqueda<Integer, String> arbol = new ArbolBinarioDeBusqueda<>();
        arbol.addNodo(10, "Raíz");
        arbol.addNodo(5, "Izquierda");
        arbol.addNodo(15, "Derecha");
        int gradoMaximo = arbol.getGrado();
        System.out.println("El grado máximo del árbol es: " + gradoMaximo);
    }
}
