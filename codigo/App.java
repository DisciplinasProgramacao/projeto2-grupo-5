import java.io.IOException;
import java.util.*;

public class App {

    private static Scanner scanner;

    private static void opcoesGrafo(Grafo grafo) {
        System.out.println("Escolha: \n1 - SubGrafo \n2 - Tamanho \n3 - Ordem \n4 - Busca em Profundidade \n5 - Busca em Largura");
        int tipoGrafo = Integer.parseInt(scanner.nextLine());

        switch (tipoGrafo) {

            case 1:
                Lista<Integer> listaVertice = new Lista<>();
                do {
                    System.out.println("Escreva um vértice // 0 para sair");
                    tipoGrafo = Integer.parseInt(scanner.nextLine());
                    listaVertice.add(tipoGrafo);
                }while(tipoGrafo != 0);
                System.out.println(grafo.subGrafo(listaVertice));
                break;

            case 2:
                System.out.println(grafo.tamanho());
                break;

            case 3:
                System.out.println(grafo.ordem());
                break;

            case 4:
                System.out.println("Escreva um vértice para iniciar a busca");
                tipoGrafo = Integer.parseInt(scanner.nextLine());
                System.out.println(grafo.dfs(tipoGrafo));
                break;

            case 5:
                System.out.println("Escreva um vértice para iniciar a busca");
                tipoGrafo = Integer.parseInt(scanner.nextLine());
                System.out.println(grafo.bfs(tipoGrafo));
                break;
        }
    }

    private static void criarGrafo() throws IOException {
        scanner = new Scanner(System.in);
        GrafoMutavel grafoMutavel;

        System.out.println("Selecione o tipo de grafo: \n1 - Direcionado \n2 - Não direcionado");
        int tipoGrafo = Integer.parseInt(scanner.nextLine());
        System.out.println("Nome do arquivo:");
        String nomeArquivo = scanner.nextLine();

        switch (tipoGrafo) {
            case 1:
                grafoMutavel = new GrafoDirecionado("Grafo Direcionado");
                grafoMutavel.carregar(nomeArquivo);
                opcoesGrafo(grafoMutavel);
                break;
            case 2:
                grafoMutavel = new GrafoNaoDirecionado("Grafo Nao Direcionado");
                grafoMutavel.carregar(nomeArquivo);
                opcoesGrafo(grafoMutavel);
                break;
        }
        scanner.close();
    }

    public static void main(String[] args) throws Exception {

        scanner = new Scanner(System.in);

        System.out.println("Selecione: \n1 - Grafo completo \n2 - Criar grafo");
        int tipoGrafo = Integer.parseInt(scanner.nextLine());

        switch (tipoGrafo) {

            case 1:
                System.out.println("Nome do grafo completo:");
                String nome = scanner.nextLine();
                System.out.println("Ordem do grafo completo");
                int ordem = Integer.parseInt(scanner.nextLine());

                GrafoCompleto grafoCompleto = new GrafoCompleto(nome, ordem);
                opcoesGrafo(grafoCompleto);
                break;

            case 2:
                criarGrafo();
                break;
        }
        scanner.close();
    }
}
