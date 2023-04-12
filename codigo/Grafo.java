import java.util.*;

/**
 * Classe básica para um Grafo simples não direcionado.
 */
public abstract class Grafo {
    public final String nome;
    protected ABB<Vertice> vertices;
    protected ArrayList<ArrayList<Integer>> adjacencia;

    public static Grafo grafoCompleto(int ordem) {

        return new GrafoCompleto("Grafo Completo", ordem);
    }

    /**
     * Construtor. Cria um grafo vazio com um nome escolhido pelo usuário. Em caso de nome não informado
     * (string vazia), recebe o nome genérico "Grafo"
     */
    public Grafo(String nome) {
        if (nome.length() == 0)
            this.nome = "Grafo";
        else
            this.nome = nome;
        this.vertices = new ABB<>();
    }


    /**
     * Retorna o nome do grafo (string), caso seja necessário em outras classes/sistemas
     *
     * @return O nome do grafo (uma string)
     */
    public String nome() {
        return this.nome;
    }

    /**
     * Verifica se um vértice com id especificado existe no grafo.
     *
     * @param idVertice O identificador do vértice a ser encotrado
     * @return O vértice encotrado, ou null se não existir
     */
    public Vertice existeVertice(int idVertice) {
        return this.vertices.find(idVertice);
    }


    /**
     * Verifica se uma aresta exite entre dois vértices, caso o vérice de origem exista e indicando
     * o vértice de destino.
     *
     * @param verticeA Vértice de origem
     * @param verticeB Vértice de destino
     * @return A aresta encotrada, ou null se não existir
     */
    public Aresta existeAresta(int verticeA, int verticeB) {
        Vertice saida = existeVertice(verticeA);
        return saida.existeAresta(verticeB);
    }

    /**
     * Calcula a quantidade de arestas de um grafo a partir da metade da soma dos graus de todos os vértice do grafo
     *
     * @return A quantidade de arestas
     */
    public int qtdArestas() {
        int somaGraus = 0;
        int qtdVertices = ordem();
        Vertice[] array = new Vertice[qtdVertices];
        Vertice[] arrayVertices = this.vertices.allElements(array);
        for (Vertice vertice :
                arrayVertices) {
            somaGraus += vertice.grau();
        }

        return somaGraus / 2;
    }

    /**
     * Verifica se um grafo é completo ou não
     *
     * @return TRUE se o grafo for completo, FALSE caso contrário
     */
    public boolean completo() {
        int qtdArestas = qtdArestas();
        int qtdVertices = ordem();
        int e = qtdVertices * (qtdVertices - 1) / 2;

        if (qtdArestas == e) return true;
        return false;
    }

    /**
     * Cria um subgrafo a partir de uma lista de vertices
     *
     * @param vertices Lista de vétices
     * @return grafo Subgrafo
     */
    public Grafo subGrafo(Lista<Integer> vertices) {
        GrafoDirecionado subGrafo = new GrafoDirecionado("subGrafo");
        Integer[] array = new Integer[vertices.size()];
        Integer[] arrayVertices = vertices.allElements(array);

        for (Integer v : arrayVertices) {
            Vertice verticeSubGrafo = this.existeVertice(v);
            if (verticeSubGrafo != null) {
                subGrafo.addVertice(v);
            }
        }

        for (Integer origem : arrayVertices) {
            for (Integer destino : arrayVertices) {
                Aresta arestaSubGrafo = this.existeAresta(origem, destino);
                Vertice saida = this.existeVertice(origem);
                if ((arestaSubGrafo != null) && (saida != null)) {
                    subGrafo.addAresta(origem, destino, 0);
                }
            }
        }
        return subGrafo;
    }

    /**
     * Calcula o tamanho do grafo a partir da soma da quantidade de vértices e arestas
     *
     * @return O tamanho do grafo
     */
    public int tamanho() {
        int qtdVertices = ordem();
        int qtdArestas = qtdArestas();
        return qtdVertices + qtdArestas;
    }

    /**
     * Calcula a ordem do grafo a partir do tamanho da ABB de vértices
     *
     * @return A ordem do grafo
     */
    public int ordem() {
        return this.vertices.size();
    }

    /**
     * Busca em largura
     *
     * @param idVerticeInicio Vertice de inicio da busca
     * @return grafo Grafo da busca em largura
     */
    public Grafo bfs(int idVerticeInicio) {
        GrafoNaoDirecionado grafo = new GrafoNaoDirecionado("teste");
        Queue<Vertice> fila = new LinkedList<>();
        Integer[] array = new Integer[1000];

        Vertice atual = existeVertice(idVerticeInicio);

        fila.add(atual);

        while (!fila.isEmpty()) {
            atual = fila.remove();

            if (!atual.visitado()) {
                atual.visitar();
                grafo.addVertice(atual.getId());
                for (Integer v : atual.vizinhos().allElements(array)) {
                    if(v == null) break;
                    Vertice vertice = existeVertice(v);
                    fila.add(vertice);
                }
            }

        }

        return grafo;
    }

    /**
     * Busca em profundidade
     *
     * @param idVerticeInicio Vertice de inicio da busca
     * @return grafo Grafo da busca em profundidade
     */
    public Grafo dfs(int idVerticeInicio) {
        GrafoNaoDirecionado grafo = new GrafoNaoDirecionado("teste");
        Stack<Vertice> fila = new Stack<>();
        Integer[] array = new Integer[1000];

        Vertice atual = existeVertice(idVerticeInicio);

        fila.push(atual);

        while (!fila.empty()) {
            atual = fila.pop();

            if (!atual.visitado()) {
                atual.visitar();
                grafo.addVertice(atual.getId());
                for (Integer v : atual.vizinhos().allElements(array)) {
                    if(v == null) break;
                    Vertice vertice = existeVertice(v);
                    fila.add(vertice);
                }
            }

        }

        return grafo;
    }
}