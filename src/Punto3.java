import java.util.ArrayList;

public class Punto3 extends ABBenteros {
    public static void agregarNumerosAlArbol(ABBenteros arbol, int inicio, int fin) {
        for (int i = inicio; i <= fin; i++) {
            arbol.addNodo(i, i);
        }
    }
    public static void main(String[] args){
        // apartado1
        ABBenteros arbol=new ABBenteros();
        agregarNumerosAlArbol(arbol, 0,128);
        ArrayList<Integer> lista = new ArrayList<>();
        System.out.println(arbol.recorrerPreOrden(arbol.raiz,lista));
        //apartado2
        System.out.println(arbol.getSuma());
        //apartado3
        System.out.println(arbol.sumaEnOrden(arbol.raiz));
        System.out.println(arbol.sumaPostOrden(arbol.raiz));
        System.out.println(arbol.sumaPreOrden(arbol.raiz));
        //apartado4
        int suma1= arbol.getSubarbolDerecho(arbol.raiz).getSuma()+arbol.getSubarbolIzquierdo(arbol.raiz).getSuma();
        System.out.println(suma1);
        //apartado5
        System.out.println(arbol.getAltura());
        //apartado6
        System.out.println(arbol.getCamino(110,arbol.raiz));
        System.out.println(arbol.getCamino(110,arbol.raiz).size());
    }
}
