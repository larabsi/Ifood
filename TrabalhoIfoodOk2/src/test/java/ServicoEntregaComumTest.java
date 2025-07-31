import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicoEntregaComumTest {
    private Pedido pedido;
    private Carrinho carrinho;
    private Desconto descontoCupom;
    private TipoPagamento pagamento;
    @Test
    public void deveCriarPedidoComEntregaComum() {
        carrinho = new Carrinho();
        carrinho.adicionarComida(new Comida("HAmBURGUER 1",true, 30, 2));
        carrinho.adicionarComida(new Comida("HAMBURGUER 2", true,45, 1));

        descontoCupom = new DescontoCupom30();
        pagamento = new TipoPagamentoCartao("3658741");
        pedido = new Pedido(carrinho,"Comum", pagamento, descontoCupom);

        assertEquals("Entrega comum selecionada", pedido.vizualizarTipoEntrega());
    }


}
