import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;


public class ArbolBinarioDeBusqueda<K extends Comparable<K>,V> {
    NodoABB<K, V> raiz;

    public ArbolBinarioDeBusqueda() {
        this.raiz = null;
    }

    public ArbolBinarioDeBusqueda(NodoABB<K, V> raiz) {
        this.raiz = raiz;
    }

    public NodoABB<K, V> getRaiz() {
        return raiz;
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
            return -1;
        } else {
            int alturaIzq = getAltura(nodo.getMenor());
            int alturaDcha = getAltura(nodo.getMayor());
            return Math.max(alturaIzq, alturaDcha) + 1; // Sumamos 1 por el nodo actual
        }
    }

    public ListaSimplementeEnlazada<V> getListaDatosNivel(int nivelDeseado) {
        ListaSimplementeEnlazada<V> nodos = new ListaSimplementeEnlazada<>();
        obtenerNodosEnNivel(raiz, nivelDeseado, 0, nodos);
        return nodos;
    }

    private void obtenerNodosEnNivel(NodoABB<K, V> nodo, int nivelDeseado, int nivelActual, ListaSimplementeEnlazada<V> nodos) {
        if (nodo == null) {
            return;
        }
        if (nivelActual == nivelDeseado) {
            nodos.add(nodo.getValor());
        } else {
            obtenerNodosEnNivel(nodo.getMenor(), nivelDeseado, nivelActual + 1, nodos);
            obtenerNodosEnNivel(nodo.getMayor(), nivelDeseado, nivelActual + 1, nodos);
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
        NodoABB<K, V> n = new NodoABB<>(clave, valor);
        if (candidato.getClave().compareTo(clave) > 0) {
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

    public ArrayList<NodoABB<K, V>> getCamino(K cbusqueda, NodoABB<K, V> nodo) {
        ArrayList<NodoABB<K, V>> path = new ArrayList<>();
        if (nodo == null) {
            return path;
        }
        while (nodo != null && !nodo.getClave().equals(cbusqueda)) {
            path.add(nodo);
            if (nodo.getClave().compareTo(cbusqueda) > 0) {
                nodo = nodo.getMenor();
            } else {
                nodo = nodo.getMayor();
            }
        }
        if (nodo != null) {
            path.add(nodo);
        }
        return path;
    }

    // Recorrido preorden
    public ArrayList<V> recorrerPreOrden(NodoABB<K, V> nodo, ArrayList<V> lista) {

        if (nodo != null) {
            lista.add(nodo.getValor()); // Agrega el valor del nodo actual
            recorrerPreOrden(nodo.getMenor(), lista); // Recorre el subárbol izquierdo
            recorrerPreOrden(nodo.getMayor(), lista); // Recorre el subárbol derecho
        }

        return lista; // Retorna la lista con los valores agregados
    }


    // Recorrido en orden central
    public ArrayList<V> recorrerOrdenCentral(NodoABB<K, V> nodo, ArrayList<V> lista) {
        if (nodo != null) {
            recorrerOrdenCentral(nodo.getMenor(), lista); // Subárbol izquierdo
            lista.add(nodo.getValor()); //  raíz
            recorrerOrdenCentral(nodo.getMayor(), lista); // Subárbol derecho
        }
        return lista;
    }

    // Recorrido postorden
    public ArrayList<V> recorrerPostOrden(NodoABB<K, V> nodo, ArrayList<V> lista) {
        if (nodo != null) {
            recorrerPostOrden(nodo.getMenor(), lista); // Subárbol izquierdo
            recorrerPostOrden(nodo.getMayor(), lista); // Subárbol derecho
            lista.add(nodo.getValor()); // raíz
        }
        return lista;
    }

    public ArbolBinarioDeBusqueda<K, V> getSubarbolIzquierdo(NodoABB<K, V> nodo) {
        ArbolBinarioDeBusqueda<K, V> subarbolIzquierdo = new ArbolBinarioDeBusqueda<>();
        if (nodo != null && nodo.getMenor() != null) {
            subarbolIzquierdo.raiz = nodo.getMenor(); // Asignar el nodo menor como raíz del subárbol
        }
        return subarbolIzquierdo;
    }

    public ArbolBinarioDeBusqueda<K, V> getSubarbolDerecho(NodoABB<K, V> nodo) {
        ArbolBinarioDeBusqueda<K, V> subarbolDerecho = new ArbolBinarioDeBusqueda<>();
        if (nodo != null && nodo.getMayor() != null) {
            subarbolDerecho.raiz = nodo.getMayor(); // Asignar el nodo mayor como raíz del subárbol
        }
        return subarbolDerecho;
    }

    public boolean isArbolHomogeneo() {
        if (raiz == null) {
            return true; // Un árbol vacío es homogéneo.
        }
        return verificarHomogeneidad(raiz, this.getGrado());
    }

    protected boolean verificarHomogeneidad(NodoABB<K, V> nodo, int grado) {
        if (getGradoNodos(nodo) == 0) {
            return true;
        }
        if (getGradoNodos(nodo) != grado) {
            return false;
        }
        return verificarHomogeneidad(nodo.getMenor(), grado) && verificarHomogeneidad(nodo.getMayor(), grado);
    }

    public int getGradoNodos(NodoABB<K, V> nodo) {
        if (nodo == null) {
            return 0; // Un nodo nulo no tiene grado
        }
        int grado = 0;
        if (nodo.getMenor() != null) {
            grado++; // Incrementa el grado si hay un hijo izquierdo
        }
        if (nodo.getMayor() != null) {
            grado++; // Incrementa el grado si hay un hijo derecho
        }
        return grado; // Devuelve el grado total del nodo
    }

}