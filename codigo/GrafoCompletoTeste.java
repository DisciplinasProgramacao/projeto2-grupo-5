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
