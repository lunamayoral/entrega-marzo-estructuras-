public class NodoABB<K,V> {
    private K clave;
    private V valor;
    private NodoABB<K,V> menor;
    private NodoABB<K,V> mayor;

    public NodoABB(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
    }
}
