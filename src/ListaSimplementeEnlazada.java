public class ListaSimplementeEnlazada<T> implements Lista<T> {
    protected ElementoSE<T> cabeza;

    //Constructors
    public ListaSimplementeEnlazada() {
        this.cabeza = null;
    }

    public ListaSimplementeEnlazada(ElementoSE<T> cabeza) {
        this.cabeza = cabeza;
    }

    @Override
    public boolean add(T dato) {
        ElementoSE<T> temporal = new ElementoSE<T>(dato);
        if (this.getCabeza() == null) {
            setCabeza(temporal);
            return true;
        } else {
            temporal.setSiguiente(this.cabeza);
            this.cabeza = temporal;
            return true;
        }
    }

    @Override
    public boolean delete(T dato) {
        if (this.getCabeza() == null) {
            return false;
        }
        if (this.getCabeza().getDato().equals(dato)) {
            this.cabeza = cabeza.getSiguiente();
            return true;
        }
        ElementoSE<T> actual = this.cabeza;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getDato().equals(dato)) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    @Override
    public int getNumElementos() {
        int contador = 0;
        ElementoSE<T> actual = this.cabeza;
        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }

    @Override
    public IIterador<T> getIterador() {
        return new IteradorSE<>(this);
    }

    public ElementoSE<T> getCabeza() {
        if (this.cabeza == null) {
            return null;
        }
        return this.cabeza;
    }

    public void setCabeza(ElementoSE<T> cabeza) {
        this.cabeza = cabeza;
    }

    public boolean isEmpty() {
        return this.cabeza == null;
    }

    public ElementoSE<T> getUltimo() {
        if (this.cabeza == null) {
            return null;
        }
        ElementoSE<T> actual = this.cabeza;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        return actual;
    }


}

