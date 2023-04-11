import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {
        Grafo grafoCompleto = Grafo.grafoCompleto(5);
        Grafo subGrafo = new GrafoDirecionado("Subgrafo");

        Lista<Integer> idVertices = new Lista<>();
        idVertices.add(1);
        idVertices.add(2);
        idVertices.add(3);

        System.out.println(subGrafo.existeVertice(3).grau());
        System.out.println(subGrafo.ordem());
        System.out.println(subGrafo.qtdArestas());
        System.out.println(subGrafo.tamanho());
        System.out.println(subGrafo.completo());
    }
}
