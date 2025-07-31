import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ServicoFactoryTest {

    @Test
    void deveRetornarExcecaoParaServicoInexistente() {
        try {
            IServicoEntrega entrega = ServicoEntregaFactory.obterEntrega("Entrega Plus");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Tipo de Entrega inexistente", e.getMessage());
        }
    }
}
