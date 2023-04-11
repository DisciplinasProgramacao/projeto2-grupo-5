import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class GrafoCompletoTeste {
    GrafoCompleto grafoTeste;

    @BeforeEach
    public void prepare(){
        grafoTeste = new GrafoCompleto("teste", 5);
    }

    @Test
    public void deveVerificarSeEhCompleto(){
        assertTrue(grafoTeste.completo());
    }

    @Test
    public void deveVerificarSeExisteVertice(){
        assertEquals(2, grafoTeste.existeVertice(2).getId());
    }

    @Test
    public void deveVerificarSeExisteAresta(){
        assertEquals(3, grafoTeste.existeAresta(2, 3).destino());
    }

    @Test
    public void deveVerificarAQtdDeArestas(){
        assertEquals(10, grafoTeste.qtdArestas());
    }

    @Test
    public void deveVerificarOTamanho(){
        assertEquals(15, grafoTeste.tamanho());
    }

    @Test
    public void deveVerificarAOrdem(){
        assertEquals(5, grafoTeste.ordem());
    }
}
