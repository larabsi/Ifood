import org.junit.jupiter.api.Test;

import java.awt.color.ProfileDataException;

import static org.junit.jupiter.api.Assertions.*;

public class BuilderTest {

    @Test
    void deveRetornarExcecaoParaPedidoSemCarrinho() {
        try {
            PedidoBuilder pedidoBuilder = new PedidoBuilder();
            Pedido pedido = pedidoBuilder
                    .setCarrinho(null)
                    .setObservacaoExtra("Carne mal passada")
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Carrinho vazio", e.getMessage());
        }
    }

    @Test
    void deveRetornarPedidoValido() {
        Carrinho carrinho = new Carrinho(
                new Comida("Pizza marguerita", true,15,1),
                new Comida("Pizza portuguesa", true,35,1),
                new Comida("Pizza frango", false,45,2),
                new Comida("Pizza calabresa", true,20,1));

        PedidoBuilder pedidoBuilder = new PedidoBuilder();
        Pedido pedido = pedidoBuilder
                .setCarrinho(carrinho)
                .setObservacaoExtra("Pizza bem assada")
                .build();

        assertNotNull(pedido);
    }


}

