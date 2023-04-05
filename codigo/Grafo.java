import java.sql.Array;

/**
 * Classe básica para um Grafo simples não direcionado.
 */
public class Grafo {
    public final String nome;
    private ABB<Vertice> vertices;

    public static Grafo grafoCompleto(int ordem){
        return null;
    }

    /**
     * Construtor. Cria um grafo vazio com um nome escolhido pelo usuário. Em caso de nome não informado 
     * (string vazia), recebe o nome genérico "Grafo"
     */
    public Grafo(String nome){
        if(nome.length()==0) 
            this.nome = "Grafo";
        else
            this.nome = nome;
        this.vertices = new ABB<>();
    }

    /**
     * Retorna o nome do grafo (string), caso seja necessário em outras classes/sistemas
     * @return O nome do grafo (uma string)
     */
    public String nome(){
        return this.nome;
    }


    public void carregar(String nomeArquivo){

    }

    public void salvar(String nomeArquivo){
        
    }
    
    /**
     * Adiciona um vértice com o id especificado. Ignora a ação e retorna false se já existir
     * um vértice com este id
     * @param id O identificador do vértice a ser criado/adicionado
     * @return TRUE se houve a inclusão do vértice, FALSE se já existia vértice com este id
     */
    public boolean addVertice(int id){
        Vertice novo = new Vertice(id);
        return this.vertices.add(id, novo);
    }

    public Vertice removeVertice(int id){
        return this.vertices.remove(id);
    }

    public Vertice existeVertice(int idVertice){
        return this.vertices.find(idVertice);
    }

    /**
     * Adiciona uma aresta entre dois vértices do grafo, caso os dois vértices existam no grafo. 
     * Caso a aresta já exista, ou algum dos vértices não existir, o comando é ignorado e retorna FALSE.
     * @param origem Vértice de origem
     * @param destino Vértice de destino
     * @param peso Peso da aresta
     * @return TRUE se foi inserida, FALSE caso contrário
     */
    public boolean addAresta(int origem, int destino, int peso){
        boolean adicionou = false;
        Vertice saida = this.existeVertice(origem);
        Vertice chegada = this.existeVertice(destino);
        if(saida!=null && chegada !=null){
            adicionou = (saida.addAresta(destino, peso)&&chegada.addAresta(origem, peso));
        }
        return adicionou;
    }


    public Aresta removeAresta(int origem, int destino){
        Vertice saida = this.existeVertice(origem);
        return saida.removeAresta(destino);
    }

    public Aresta existeAresta(int verticeA, int verticeB){
        Vertice saida = existeVertice(verticeA);
        return saida.existeAresta(verticeB);
    }

    public int qtdArestas(){
        int qtdArestas = 0;
        int qtdVertices = ordem();
        Vertice [] array = new Vertice[qtdVertices];
        Vertice [] arrayVertices = this.vertices.allElements(array);
        for (Vertice vertice:
                arrayVertices) {
            qtdArestas += vertice.grau();
        }

        return qtdArestas / 2;
    }

    public boolean completo(){
        int qtdArestas = qtdArestas();
        int qtdVertices = ordem();
        int e = qtdVertices * (qtdVertices - 1) / 2;

        if (qtdArestas  == e){
            return true;
        }
        return false;
    }

    public Grafo subGrafo(Lista<Integer> vertices){
        Grafo subgrafo = new Grafo("Subgrafo de "+this.nome);
        return subgrafo;
    }
    
    public int tamanho(){
        int qtdVertices = ordem();
        int qtdArestas = qtdArestas();
        return qtdVertices + qtdArestas;
    }

    public int ordem(){
        return this.vertices.size();
    }

}