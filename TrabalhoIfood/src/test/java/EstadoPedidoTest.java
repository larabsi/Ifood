import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EstadoPedidoTest {


    private Pedido pedido;
    private Cliente cliente;
    private Carrinho carrinho;
    private Restaurante restaurante;
    private Desconto descontoFidelidade;
    private Desconto descontoCupom;
    private TipoPagamento pagamento;

    @BeforeEach
    public void setup() {
        restaurante = new Restaurante("Hamburgueria");

        carrinho = new Carrinho();
        carrinho.adicionarComida(new Comida("HAmBURGUER 1", 30, 2));
        carrinho.adicionarComida(new Comida("HAMBURGUER 2", 45, 1));


        descontoFidelidade = new DescontoFidelidade();
        descontoCupom = new DescontoCupom();
        descontoFidelidade.setProximo(descontoCupom);
        pagamento = new TipoPagamentoCartao();
        pedido = new Pedido(carrinho, restaurante,pagamento, descontoCupom);

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
    @Test
    public void deveMudarEstadoDeNovoParaFinalizado() {
        pedido.setEstado(EstadoNovo.getInstance());
        assertTrue(pedido.getEstado().finalizar(pedido));
        assertEquals(EstadoFinalizado.getInstance(), pedido.getEstado());
    }
    @Test
    public void deveMudarEstadoDeFinalizadoParaEmPreparo() {
        pedido.setEstado(EstadoFinalizado.getInstance());
        assertTrue(pedido.getEstado().preparar(pedido));
        assertEquals(EstadoEmPreparo.getInstance(), pedido.getEstado());
    }
    @Test
    public void deveMudarEstadoDePreparoParaEnviado() {
        pedido.setEstado(EstadoEmPreparo.getInstance());
        assertTrue(pedido.getEstado().enviar(pedido));
        assertEquals(EstadoEnviado.getInstance(), pedido.getEstado());
    }

    @Test
    public void pedidoDeveSerDeUmRestaurante() {
        assertEquals("Hamburgueria", pedido.getRestaurante().getNome());
        assertTrue(pedido.getRestaurante().getPedidos().contains(pedido));
    }
    @Test
    public void devePagarComCartao() {
        assertTrue(pedido.pagar());
    }
    @Test
    public void devePagarComPix() {
        assertTrue(pedido.pagar());
    }



}