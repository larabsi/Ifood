import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EstadoPedidoTest {


    private Pedido pedido;
    private Carrinho carrinho;
    private Desconto descontoCupom;
    private TipoPagamento pagamento;

    @BeforeEach
    public void setup() {

        carrinho = new Carrinho();
        carrinho.adicionarComida(new Comida("HAmBURGUER 1", true,30, 2));
        carrinho.adicionarComida(new Comida("HAMBURGUER 2",true, 45, 1));


        descontoCupom = new DescontoCupom10();
        pagamento = new TipoPagamentoCartao("3658741");
        pedido = new Pedido(carrinho,"Comum",pagamento, descontoCupom);

    }


    @Test
    void deveArmazenarEstados() {
        pedido.setEstado(EstadoNovo.getInstance());
        pedido.setEstado(EstadoFinalizado.getInstance());
        assertEquals(2, pedido.getEstados().size());
    }

    @Test
    void deveRetornarEstadoInicial() {
        pedido.setEstado(EstadoNovo.getInstance());
        pedido.setEstado(EstadoFinalizado.getInstance());
        pedido.restauraEstado(0);
        assertEquals(EstadoNovo.getInstance(), pedido.getEstado());
    }

    @Test
    void deveRetornarEstadoAnterior() {
        pedido.setEstado(EstadoNovo.getInstance());
        pedido.setEstado(EstadoFinalizado.getInstance());
        pedido.setEstado(EstadoEmPreparo.getInstance());
        pedido.setEstado(EstadoEnviado.getInstance());
        pedido.restauraEstado(2);
        assertEquals(EstadoEmPreparo.getInstance(), pedido.getEstado());
    }

    @Test
    void deveRetornarExcecaoIndiceInvalido() {
        try {
            pedido.restauraEstado(0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Indice invalido", e.getMessage());
        }
    }

}