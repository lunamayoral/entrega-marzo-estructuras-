public class ArbolBinarioDeBusqueda<K extends Comparable<K>,V> {
    NodoABB<K,V> raiz;

    public ArbolBinarioDeBusqueda() {
        this.raiz = null;
    }

    public ArbolBinarioDeBusqueda(NodoABB<K,V> raiz) {
        this.raiz = raiz;
    }

    public int getGrado() {
        return getGrado(raiz);
    }

    private int getGrado(NodoABB<K,V> nodo) {
        if (nodo == null) {
            return 0;
        }
        int grado = 0;
        if (nodo.getMenor() == null) {
            grado++;
        }
        if (nodo.getMayor() == null) {
            grado++;
        }
        return grado;
    }

    public int getAltura() {
        return getAltura(raiz);
    }

    private int getAltura(NodoABB<K,V> nodo) {
        if (nodo == null) {
            return 0;
        }
        int alturaIzq = getAltura(nodo.getMenor());
        int alturaDer = getAltura(nodo.getMayor());

        return Math.max(alturaIzq, alturaDer);
    }

    public ListaSimplementeEnlazada<T> getListaDatosNivel(nivel){

    }
}
