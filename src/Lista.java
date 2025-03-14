public interface Lista<T> {

    boolean add(T elemento);

    boolean delete(T elemento);

    IIterador<T> getIterador();

    int getNumElementos();

}
