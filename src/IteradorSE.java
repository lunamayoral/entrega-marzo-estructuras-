public class IteradorSE<T> implements IIterador<T> {
    // Atributos de la clase iterador
    private ListaSimplementeEnlazada<T> miLista;
    private ElementoSE<T> actual;

    // Constructor
    public IteradorSE(ListaSimplementeEnlazada<T> l) {
        this.miLista = l;
        this.actual = l.getCabeza();
    }

    @Override
    public boolean hasNext() {
        return this.actual != null;
    }


    public T getDato() {
        T temporal = this.actual.getDato(); //elemento, le pido el dato y lo guardo en la variable temporal
        this.actual = this.actual.getSiguiente();
        return temporal;
    }

    @Override
    public T next() {
        if (!hasNext()){
            System.out.println("No hay elementos en la lista.");
            return null;
        }
        T temporal = this.actual.getDato();
        this.actual = this.actual.getSiguiente();
        return temporal;
    }

    @Override
    public void delete(){
        this.miLista.delete(this.actual.getDato());
    }
}
