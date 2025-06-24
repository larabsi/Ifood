import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EstadoPedidoTest {


    private Pedido pedido;
    private Cliente cliente;
    private Carrinho carrinho;
    private Desconto descontoFidelidade;
    private Desconto descontoCupom;
    private TipoPagamento pagamento;

    @BeforeEach
    public void setup() {

        carrinho = new Carrinho();
        carrinho.adicionarComida(new Comida("HAmBURGUER 1", 30, 2));
        carrinho.adicionarComida(new Comida("HAMBURGUER 2", 45, 1));


        descontoCupom = new DescontoCupom10();
        pagamento = new TipoPagamentoCartao("3658741");
        pedido = new Pedido(carrinho,pagamento, descontoCupom);

        cliente = new Cliente("Julia Souza");
        cliente.atualizar(pedido);
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
    public void NaodeveMudarEstadoDePreparoParaNovo() {
        pedido.setEstado(EstadoEmPreparo.getInstance());
        assertFalse(pedido.getEstado().novo(pedido));

    }

    @Test
    public void NaodeveMudarEstadoDePreparoParaFinalizado() {
        pedido.setEstado(EstadoEmPreparo.getInstance());
        assertFalse(pedido.getEstado().finalizar(pedido));
    }

    @Test
    public void NaodeveMudarEstadoDeFinalizadoParaNovo() {
        pedido.setEstado(EstadoFinalizado.getInstance());
        assertFalse(pedido.getEstado().novo(pedido));
    }

    @Test
    public void NaodeveMudarEstadoDeFinalizadoParaEnviado() {
        pedido.setEstado(EstadoFinalizado.getInstance());
        assertFalse(pedido.getEstado().enviar(pedido));
    }

    @Test
    public void NaodeveMudarEstadoDeEnviadoParaEmpreparo() {
        pedido.setEstado(EstadoEnviado.getInstance());
        assertFalse(pedido.getEstado().preparar(pedido));
    }
    @Test
    public void NaodeveMudarEstadoDeEnviadoParaNovo() {
        pedido.setEstado(EstadoEnviado.getInstance());
        assertFalse(pedido.getEstado().novo(pedido));
    }
    @Test
    public void NaodeveMudarEstadoDeEnviadoParaFinalizado() {
        pedido.setEstado(EstadoEnviado.getInstance());
        assertFalse(pedido.getEstado().finalizar(pedido));
    }
    @Test
    public void NaodeveMudarEstadoDeNovoParaEnviado() {
        pedido.setEstado(EstadoNovo.getInstance());
        assertFalse(pedido.getEstado().enviar(pedido));
    }

    @Test
    public void NaodeveMudarEstadoDeNovoParaEmPreparo() {
        pedido.setEstado(EstadoNovo.getInstance());
        assertFalse(pedido.getEstado().preparar(pedido));
    }





}