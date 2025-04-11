import java.util.ArrayList;
import java.util.Collections;
public class AleatorioABB extends ABBenteros {

    public static void main(String[] args) {

        ABBenteros algo = new ABBenteros();

        int min = 0;
        int max = 128;

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        for (int num : numbers) {
            algo.addNodo(num, num);
        }

        System.out.println("Números aleatorios sin repetición:");
        System.out.println(numbers);

        System.out.println("Suma de los valores en el árbol:");
        System.out.println("Suma: " + algo.getSuma());

        // Recorridos del árbol
        ArrayList<Integer> preOrden = algo.recorrerPreOrden(algo.raiz, new ArrayList<>());
        System.out.println("Recorrido en preorden: " + preOrden);

        int contPre = 0;
        for (int i = min; i <= max; i++) {
            contPre += preOrden.get(i);
        }
        System.out.println("Suma Preorden: " + contPre);

        ArrayList<Integer> ordenCentral = algo.recorrerOrdenCentral(algo.raiz, new ArrayList<>());
        System.out.println("Recorrido en orden central: " + ordenCentral);

        int conIn = 0;
        for (int i = min; i <= max; i++) {
            conIn += ordenCentral.get(i);
        }
        System.out.println("Suma OrdenCentral: " + conIn);

        ArrayList<Integer> postOrden = algo.recorrerPostOrden(algo.raiz, new ArrayList<>());
        System.out.println("Recorrido en postorden: " + postOrden);

        int contPos = 0;
        for (int i = min; i <= max; i++) {
            contPos += postOrden.get(i);
        }
        System.out.println("Suma PostOrden: " + contPos);

        //subarbolesIzq

        ArbolBinarioDeBusqueda<Integer, Integer> saIzqa = algo.getSubarbolIzquierdo(algo.raiz);
        ArrayList<Integer> valoresa = saIzqa.recorrerPreOrden(saIzqa.raiz, new ArrayList<>());
        System.out.println("SubArbolIzq valores (PreOrden): " + valoresa);

        int contSIpre = 0;
        for (int valor : valoresa) {
            contSIpre += valor;
        }
        System.out.println("Suma SIpre: " + contSIpre);

        ArbolBinarioDeBusqueda<Integer, Integer> saIzq = algo.getSubarbolIzquierdo(algo.raiz);
        ArrayList<Integer> valores = saIzq.recorrerOrdenCentral(saIzq.raiz, new ArrayList<>());
        System.out.println("SubArbolIzq valores (Orden Central): " + valores);
        int contSIcen = 0;
        for (int valor : valores) {
            contSIcen += valor;
        }
        System.out.println("Suma SIcen: " + contSIcen);

        ArbolBinarioDeBusqueda<Integer, Integer> saIzqb = algo.getSubarbolIzquierdo(algo.raiz);
        ArrayList<Integer> valoresb = saIzqb.recorrerPostOrden(saIzqb.raiz, new ArrayList<>());
        System.out.println("SubArbolIzq valores (PostOrden): " + valoresb);

        int contSIpos = 0;
        for (int valor : valoresb) {
            contSIpos += valor;
        }
        System.out.println("Suma SIpos: " + contSIpos);

        //Subarboles derecha

        ArbolBinarioDeBusqueda<Integer, Integer> saDerea = algo.getSubarbolDerecho(algo.raiz);
        ArrayList<Integer> vAloresa = saDerea.recorrerPreOrden(saDerea.raiz, new ArrayList<>());
        System.out.println("SubArbolDere vAlores (PreOrden): " + vAloresa);

        int contSDpre = 0;
        for (int valor : vAloresa) {
            contSDpre += valor;
        }
        System.out.println("Suma SDpre: " + contSDpre);

        ArbolBinarioDeBusqueda<Integer, Integer> saDere = algo.getSubarbolDerecho(algo.raiz);
        ArrayList<Integer> vAlores = saDere.recorrerOrdenCentral(saDere.raiz, new ArrayList<>());
        System.out.println("SubArbolDere vAlores (Orden Central): " + vAlores);

        int contSDcen = 0;
        for (int valor : vAlores) {
            contSDcen += valor;
        }
        System.out.println("Suma SDcen: " + contSDcen);

        ArbolBinarioDeBusqueda<Integer, Integer> saDereb = algo.getSubarbolDerecho(algo.raiz);
        ArrayList<Integer> vAloresb = saDereb.recorrerPostOrden(saDereb.raiz, new ArrayList<>());
        System.out.println("SubArbolDere vAlores (PostOrden): " + vAloresb);

        int contSDpos = 0;
        for (int valor : vAloresb) {
            contSDpos += valor;
        }
        System.out.println("Suma SDcen: " + contSDpos);

        //Verificacion
        System.out.println(algo.raiz + " + " + contSIpre + " + " + contSDpre + " = 8256 = " + algo.getSuma());
        System.out.println(contSIcen + " + " + algo.raiz + " + " + contSDcen + " = 8256 = " + algo.getSuma());
        System.out.println(contSIpos + " + " + contSDpos + " + " + algo.raiz + " = 8256 = " + algo.getSuma());

        //Altura
        System.out.println(algo.getAltura());

        // Obtener el camino hacia el nodo con clave 110
        ArrayList<NodoABB<Integer, Integer>> camino = algo.getCamino(110, algo.raiz);
        System.out.println("Camino hasta el nodo con clave 110:" + camino);
        //Longitud
        System.out.println(camino.size());
    }
}

