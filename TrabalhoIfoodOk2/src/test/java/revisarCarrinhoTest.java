import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class revisarCarrinhoTest {
    @Test
    void deveContarComidasAtivaCarrinho() {
        Carrinho carrinho = new Carrinho(
                new Comida("Pizza marguerita", true,15,1),
                new Comida("Pizza portuguesa", true,35,1),
                new Comida("Pizza frango", false,45,2),
                new Comida("Pizza calabresa", true,20,1)
        );
        assertEquals(3, RevisarCarrinho.contarComidasAtivasCarrinho(carrinho));
    }

    @Test
    void deveContarTotalComidasCarrinho() {
        Carrinho carrinho = new Carrinho(
                new Comida("Pizza marguerita", true,15,1),
                new Comida("Pizza portuguesa", true,35,1),
                new Comida("Pizza frango", false,45,2),
                new Comida("Pizza calabresa", true,20,1)
        );
        assertEquals(4, RevisarCarrinho.contarTotalComidasCarrinho(carrinho));
    }
}
