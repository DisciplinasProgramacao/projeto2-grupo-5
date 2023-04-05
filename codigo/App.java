public class App {

    public static void main(String[] args) throws Exception {
        Grafo grafoTeste = new Grafo("teste");
        grafoTeste.addVertice(1);
        grafoTeste.addVertice(2);
        grafoTeste.addVertice(3);
        grafoTeste.addVertice(4);
        grafoTeste.addVertice(5);

        grafoTeste.addAresta(1, 2, 0);
        grafoTeste.addAresta(1, 3, 0);
        grafoTeste.addAresta(1, 4, 0);
        grafoTeste.addAresta(1, 5, 0);

        grafoTeste.addAresta(2, 3, 0);
        grafoTeste.addAresta(2, 4, 0);
        grafoTeste.addAresta(2, 5, 0);

        grafoTeste.addAresta(3, 4, 0);
        grafoTeste.addAresta(3, 5, 0);

        grafoTeste.addAresta(4, 5, 0);

        System.out.println(grafoTeste.ordem());
        System.out.println(grafoTeste.qtdArestas());
        System.out.println(grafoTeste.tamanho());
        System.out.println(grafoTeste.completo());
    }
}
