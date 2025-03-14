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
        int gradoActual = nodo.getGradoNodos(nodo);
        int gradoIzq = getGrado(nodo.getMenor());
        int gradoDcha = getGrado(nodo.getMayor());

        return Math.max(gradoActual, Math.max(gradoIzq, gradoDcha));
    }

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

    protected boolean addNodoRaiz(K clave, V valor) {
        NodoABB<K, V> n = new NodoABB<>(clave, valor);
        this.raiz = n;
        return true;
    }

    protected boolean addOtrosNodos(K clave, V valor) {
        NodoABB<K, V> candidato = buscarNodoAInsertar(clave, this.raiz);
        if (candidato == null) {
            return false;
        }
        NodoABB<K, V> n = new NodoABB<>(clave, valor);
        if (candidato.getClave().compareTo(clave) > 0 ) {
            candidato.setMenor(n);
        } else {
            candidato.setMayor(n);
        }
        return true;
    }

    protected NodoABB<K, V> buscarNodoAInsertar(K cbusqueda, NodoABB<K, V> nodo) {
        if (nodo.getClave().equals(cbusqueda)) {
            return null;
        }
        if (nodo.getClave().compareTo(cbusqueda) > 0) {
            if (nodo.getMenor() != null) {
                return buscarNodoAInsertar(cbusqueda, nodo.getMenor());
            } else {
                return nodo;
            }
        } else {
            if (nodo.getMayor() != null) {
                return buscarNodoAInsertar(cbusqueda, nodo.getMayor());
            } else {
                return nodo;
            }
        }
    }

    public boolean addNodo(K clave, V valor) {
        if (this.raiz == null) {
            return addNodoRaiz(clave, valor);
        } else {
            return addOtrosNodos(clave, valor);
        }
    }



}


