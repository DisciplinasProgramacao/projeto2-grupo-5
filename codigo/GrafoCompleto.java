public class GrafoCompleto extends Grafo{

    /**
     * Construtor. Cria um grafo completo com base nos atributos e métodos herdados da classe
     * pai Grafo
     * @param nome O nome do grafo a ser criado
     * @param ordem A ordem do grafo a ser criado
     */
    public GrafoCompleto(String nome, int ordem){
        super(nome);

        for(int i = 0; i < ordem; i++){
            Vertice vertice = new Vertice(i);
            this.vertices.add(i, vertice);
        }

        for(int i = 0; i < ordem; i++){
            Vertice saida = this.existeVertice(i);
            for (int j = 0; j < ordem; j++){
                if(i != j){
                    saida.addAresta(j);
                }
            }
        }
    }
}
