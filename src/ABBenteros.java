public class ABBenteros extends ArbolBinarioDeBusqueda<Integer,Integer> {

    public ABBenteros() {
        super(); // Llama al constructor de la clase padre
    }

    // Método para insertar un nuevo nodo
    @Override
    public boolean addNodo(Integer clave, Integer valor) {
        return super.addNodo(clave, valor);
    }

    public int getSuma() {
        return calcularSuma(raiz);
    }

    // Método recursivo para calcular la suma
    private int calcularSuma(NodoABB<Integer, Integer> nodo) {
        if (nodo == null) {
            return 0; // Si el nodo es nulo, la suma es 0
        }
        // Sumar el valor del nodo actual y las sumas de los subárboles izquierdo y derecho
        return nodo.getValor() + calcularSuma(nodo.getMenor()) + calcularSuma(nodo.getMayor());
    }
}

