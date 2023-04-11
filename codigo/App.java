public class App {

    public static void main(String[] args) throws Exception {
        Grafo grafoTeste = Grafo.grafoCompleto(5);

        System.out.println(grafoTeste.existeVertice(1).getId());
        System.out.println(grafoTeste.ordem());
        System.out.println(grafoTeste.qtdArestas());
        System.out.println(grafoTeste.tamanho());
        System.out.println(grafoTeste.completo());
    }
}
