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
    public int sumaPreOrden(NodoABB<Integer, Integer> nodo) {
        if (nodo == null) {
            return 0;
        }
        return nodo.getValor() + sumaPreOrden(nodo.getMenor()) + sumaPreOrden(nodo.getMayor());
    }

    // Recorrido en orden
    public int sumaEnOrden(NodoABB<Integer, Integer> nodo) {
        if (nodo == null) {
            return 0;
        }
        return sumaEnOrden(nodo.getMenor()) + nodo.getValor() + sumaEnOrden(nodo.getMayor());
    }

    // Recorrido en postorden
    public int sumaPostOrden(NodoABB<Integer, Integer> nodo) {
        if (nodo == null) {
            return 0;
        }
        return sumaPostOrden(nodo.getMenor()) + sumaPostOrden(nodo.getMayor()) + nodo.getValor();
    }
    @Override
    public ABBenteros getSubarbolIzquierdo(NodoABB<Integer,Integer> nodo) {
        ABBenteros subarbolIzquierdo = new ABBenteros();
        if (nodo != null && nodo.getMenor() != null) {
            subarbolIzquierdo.raiz = nodo.getMenor(); // Asignar el nodo menor como raíz del subárbol
        }
        return subarbolIzquierdo;
    }
@Override
    public ABBenteros getSubarbolDerecho(NodoABB<Integer, Integer> nodo) {
        ABBenteros subarbolDerecho = new ABBenteros();
        if (nodo != null && nodo.getMayor() != null) {
            subarbolDerecho.raiz = nodo.getMayor(); // Asignar el nodo mayor como raíz del subárbol
        }
        return subarbolDerecho;
    }
}

