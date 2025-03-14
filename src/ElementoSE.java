public class ElementoSE<T> {
    protected T dato; // Dato
    protected ElementoSE<T> siguiente; //Enganche con el siguiente elemento

    public ElementoSE(T dato) {
        this.dato = dato;
    }

    public ElementoSE<T> getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(ElementoSE<T> siguiente) {
        this.siguiente = siguiente;
    }

    public T getDato() {
        return dato;
    }
    public void setDato(T dato) {
        this.dato = dato;
    }

}
