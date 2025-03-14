import java.util.LinkedList;
import java.util.Queue;

public class ArbolBinarioDeBusqueda<K extends Comparable<K>,V> {
    NodoABB<K, V> raiz;

    public ArbolBinarioDeBusqueda() {
        this.raiz = null;
    }

    public ArbolBinarioDeBusqueda(NodoABB<K, V> raiz) {
        this.raiz = raiz;
    }

    public int getGrado() {
        return getGrado(raiz);
    }

    private int getGrado(NodoABB<K, V> nodo) {
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
    // Falta getgrado para el arbol entero

    public int getAltura() {
        return getAltura(raiz);
    }

    private int getAltura(NodoABB<K, V> nodo) {
        if (nodo == null) {
            return 0;
        } else {
            int alturaIzq = getAltura(nodo.getMenor());
            int alturaDcha = getAltura(nodo.getMayor());
            if (nodo.getMenor() == null) {
                alturaIzq++;
            }
            if (nodo.getMayor() == null) {
                alturaDcha++;
            }
            return Math.max(alturaIzq, alturaDcha);
        }
    }

    public boolean isArbolCompleto() {
        if (raiz == null) {
            return true;
        }

        Queue<NodoABB<K, V>> cola = new LinkedList<>();
        cola.add(raiz);

        boolean espacio = false;

        while (!cola.isEmpty()) {
            NodoABB<K, V> actual = cola.poll();

            if (actual.getMenor() != null) {
                if (espacio) {
                    return false;
                }
                cola.add(actual.getMenor());
            } else {
                espacio = true; // Detectamos un hueco
            }

            if (actual.getMayor() != null) {
                if (espacio) {
                    return false; // Igual que con el izquierdo
                }
                cola.add(actual.getMayor());
            } else {
                espacio = true;
            }
        }

        return true;
    }

    public boolean isArbolCasiCompleto() {
        if (raiz == null) {
            return true; // Un árbol vacío es casi completo
        }

        Queue<NodoABB<K, V>> queue = new LinkedList<>();
        queue.add(raiz);

        boolean espacio = false;

        while (!queue.isEmpty()) {
            NodoABB<K, V> actual = queue.poll();

            if (actual.getMenor() != null) {
                if (espacio) {
                    return false; // Si hay un nodo después de un hueco, no es casi completo
                }
                queue.add(actual.getMenor());
            } else {
                espacio = true; // Detectamos un hueco
            }

            if (actual.getMayor() != null) {
                if (espacio) {
                    return false; // Igual que con el izquierdo
                }
                queue.add(actual.getMayor());
            } else {
                espacio = true;
            }
        }
        return true;
    }
}
