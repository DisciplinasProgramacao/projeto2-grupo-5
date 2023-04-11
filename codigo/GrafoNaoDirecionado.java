public class GrafoNaoDirecionado extends GrafoMutavel{

    /**
     * Construtor. Cria um grafo mutável com base nos atributos e métodos herdados da classe
     * pai Grafo
     *
     * @param nome O nome do grafo a ser criado
     */
    public GrafoNaoDirecionado(String nome) {
        super(nome);
    }

    /**
     * Adiciona uma aresta entre dois vértices do grafo, caso os dois vértices existam no grafo.
     * Caso a aresta já exista, ou algum dos vértices não existir, o comando é ignorado e retorna FALSE.
     * @param origem Vértice de origem
     * @param destino Vértice de destino
     * @param peso Peso da aresta
     * @return TRUE se foi inserida, FALSE caso contrário
     */
    @Override
    public boolean addAresta(int origem, int destino, int peso){
        boolean adicionou = false;
        Vertice saida = this.existeVertice(origem);
        Vertice chegada = this.existeVertice(destino);
        if(saida!=null && chegada !=null){
            adicionou = (saida.addAresta(destino, peso)&&chegada.addAresta(origem, peso));
        }
        return adicionou;
    }

    /**
     * Adiciona uma aresta entre dois vértices do grafo, caso o vérice de origem exista e indicando
     * o vértice de destino.
     * @param origem Vértice de origem
     * @param destino Vértice de destino
     * @return A aresta removida, ou null se não existir
     */
    @Override
    public Aresta removeAresta(int origem, int destino){
        Vertice saida = this.existeVertice(origem);
        Vertice outraSaida = this.existeVertice(destino);
        outraSaida.removeAresta(origem);
        return saida.removeAresta(destino);
    }

}
