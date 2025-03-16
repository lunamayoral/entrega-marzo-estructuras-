public class NodoABB<K,V> {
    private K clave;
    private V valor;
    private NodoABB<K,V> menor;
    private NodoABB<K,V> mayor;


    public NodoABB(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public void setMenor(NodoABB<K,V> menor) {
        this.menor = menor;
    }

    public void setMayor(NodoABB<K,V> mayor) {
        this.mayor = mayor;
    }

    public K getClave() {
        return clave;
    }

    public V getValor() {
        return valor;
    }

    public void setValor(V valor) {
        this.valor = valor;
    }

    public void setClave(K clave) {
        this.clave = clave;
    }

    public NodoABB<K,V> getMenor() {
        return menor;
    }

    public NodoABB<K,V> getMayor() {
        return mayor;
    }

    public int getGradoNodos(NodoABB<K, V> nodo) {
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





}
