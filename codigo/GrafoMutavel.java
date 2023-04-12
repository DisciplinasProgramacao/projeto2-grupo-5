import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class GrafoMutavel  extends Grafo{

    /**
     * Construtor. Cria um grafo mutável com base nos atributos e métodos herdados da classe
     * pai Grafo
     * @param nome O nome do grafo a ser criado
     */
    public GrafoMutavel(String nome){
        super(nome);
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

    /**
     * Remove um vértice com o id especificado.
     * @param id O identificador do vértice a ser removido
     * @return O vértice removido, ou null se não existir
     */
    public Vertice removeVertice(int id){
        return this.vertices.remove(id);
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

    /**
     * Adiciona uma aresta entre dois vértices do grafo, caso o vérice de origem exista e indicando
     * o vértice de destino.
     * @param origem Vértice de origem
     * @param destino Vértice de destino
     * @return A aresta removida, ou null se não existir
     */
    public Aresta removeAresta(int origem, int destino){
        Vertice saida = this.existeVertice(origem);
        return saida.removeAresta(destino);
    }

    /**
     * Essa função Java carrega um grafo de um arquivo e cria sua representação de lista de adjacência.
     * 
     * @param nomeArquivo O nome do arquivo que contém os dados do grafo a serem carregados.
     */
    public void carregar(String nomeArquivo) throws IOException{
        File arquivo = new File(nomeArquivo);
        Scanner ler = new Scanner(arquivo);

        int nVertices = ler.nextInt();
        int nArestas = ler.nextInt();
        this.vertices = new ABB<>();
        this.adjacencia = new ArrayList<>();
        for(int i = 0; i < nVertices; i++){
            this.adjacencia.add(new ArrayList<Integer>());
        }

        for(int i = 0; i< nArestas; i++){
            int origem = ler.nextInt();
            int destino = ler.nextInt();
            int peso = ler.nextInt();
            addAresta(origem, destino, peso);
        }

        ler.close();
    }

    /**
     * Esta função salva um grafo representado por vértices e listas de adjacências em um arquivo.
     * 
     * @param nomeArquivo O parâmetro "nomeArquivo" é uma String que representa o nome do arquivo
     * onde o gráfico será salvo.
     */
    public void salvar(String nomeArquivo) throws IOException{
        File arquivo = new File(nomeArquivo);
        FileWriter escrever = new FileWriter(arquivo);

        escrever.write(this.vertices + "" + this.vertices.size() + "\n");

        for(int i = 0; i < this.vertices.size(); i++){
            for(int j = 0; j < this.adjacencia.get(i).size(); j++){
                escrever.write(i + " " + this.adjacencia.get(i).get(j) + "\n");
            }
        }

        escrever.close();
    }

   
}
