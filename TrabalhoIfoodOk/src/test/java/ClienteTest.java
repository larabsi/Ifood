import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClienteTest {
    private Pedido pedido;
    private Cliente cliente;
    private Carrinho carrinho;
    private Desconto descontoCupom;
    private TipoPagamento pagamento;
    @BeforeEach
    public void setup() {

        carrinho = new Carrinho();
        carrinho.adicionarComida(new Comida("HAmBURGUER 1", 30, 2));
        carrinho.adicionarComida(new Comida("HAMBURGUER 2", 45, 1));

        descontoCupom = new DescontoCupom30();
        pagamento = new TipoPagamentoCartao("3658741");
        pedido = new Pedido(carrinho,pagamento, descontoCupom);

        cliente = new Cliente("Julia Souza");
        cliente.atualizar(pedido);
    }

    @Test
    public void deveNotificarQuandoEstadoMudarDeNovoParaFinalizado() {
        pedido.setEstado(EstadoNovo.getInstance());
        pedido.finalizar();
        assertNotNull(cliente.getUltimaNotificacao());
        assertTrue(cliente.getUltimaNotificacao().contains("Finalizado"));
    }
    @Test
    public void DeveNotificarQuandoEstadoMudarFinalizadoParaEmpreparo() {
        pedido.setEstado(EstadoFinalizado.getInstance());
        pedido.preparar();
        assertNotNull(cliente.getUltimaNotificacao());
        assertTrue(cliente.getUltimaNotificacao().contains("Em preparo"));
    }
    @Test
    public void deveNotificarQuandoEstadoMudarEmPreparoParaEnviado() {
        pedido.setEstado(EstadoEmPreparo.getInstance());
        pedido.enviar();
        assertNotNull(cliente.getUltimaNotificacao());
        assertTrue(cliente.getUltimaNotificacao().contains("Enviado"));
    }
}
