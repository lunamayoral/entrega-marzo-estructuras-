import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class ArbolBinarioDeBusqueda<K extends Comparable<K>,V> {
    NodoABB<K, V> raiz;
    Lista[] elemento;

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

    protected NodoABB<K, V> buscarNodoAInsertar(K cbusqueda, NodoABB<K, V> nodo) {  //PreOrden
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

    public java.util.ArrayList<Object> getCamino(K cbusqueda, NodoABB<K, V> nodo) {

        ArrayList<Object> path = new ArrayList<>();
        {
            // Itera mientras no es nulo y no hemos llegado al nodo buscado
            while (nodo != null && !nodo.getClave().equals(cbusqueda)) {
                // Agregamos el nodo actual a la lista del camino
                path.add(nodo);

                // Indicar izquierda o derecha
                if (nodo.getClave().compareTo(cbusqueda) > 0) {
                    nodo = nodo.getMenor();
                } else {
                    nodo = nodo.getMayor();
                }
            }

            // Añade el nodo
            if (nodo != null) {
                path.add(nodo);
            }

            // Devuelve la lista
            return path;
        }
    }


    // Recorrido preorden
    public ArrayList<NodoABB<K, V>> recorrerPreOrden(NodoABB<K, V> nodo, ArrayList<NodoABB<K, V>> lista) {
        if (nodo == null) return lista;
        lista.add(nodo); //  raíz
        recorrerPreOrden(nodo.getMenor(), lista); //  subárbol izquierdo
        recorrerPreOrden(nodo.getMayor(), lista); //subárbol derecho
        return lista;
    }

    // Recorrido en orden central
    public ArrayList<NodoABB<K, V>> recorrerOrdenCentral(NodoABB<K, V> nodo, ArrayList<NodoABB<K, V>> lista) {
        if (nodo == null) return lista;
        recorrerOrdenCentral(nodo.getMenor(), lista); // Subárbol izquierdo
        lista.add(nodo); //  raíz
        recorrerOrdenCentral(nodo.getMayor(), lista); // Subárbol derecho
        return lista;
    }

    // Recorrido postorden
    public ArrayList<NodoABB<K, V>> recorrerPostOrden(NodoABB<K, V> nodo, ArrayList<NodoABB<K, V>> lista) {
        if (nodo == null) return lista;
        recorrerPostOrden(nodo.getMenor(), lista); // Subárbol izquierdo
        recorrerPostOrden(nodo.getMayor(), lista); // Subárbol derecho
        lista.add(nodo); // raíz
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

    private boolean verificarHomogeneidad(NodoABB<K, V> nodo, int grado) {
        if (getGrado(nodo) == 0) {
            return true;
        }
        if (getGrado(nodo) != grado) {
            return false;
        }
        return verificarHomogeneidad(nodo.getMenor(), grado) && verificarHomogeneidad(nodo.getMayor(), grado);
    }

}