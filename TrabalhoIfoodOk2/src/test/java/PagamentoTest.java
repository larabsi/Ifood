import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PagamentoTest {
    @Test
    public void devePagarComCartao() {
        Carrinho  carrinho = new Carrinho();
        carrinho.adicionarComida(new Comida("HAmBURGUER 1",true, 30, 2));
        Desconto descontoCupom30 = new DescontoCupom30();
        TipoPagamento pagamento = new TipoPagamentoCartao("3658741");
        Pedido pedido = new Pedido(carrinho,"Comum",pagamento, descontoCupom30);
        Cliente cliente = new Cliente("Julia Souza", "12345678901",new Endereco(new Cidade("Juiz de fora","MG"),"Rua A", 1));
        cliente.atualizar(pedido);
        assertEquals("Pagamento realizado com Cartão de Crédito: 3658741 No valor de R$42.0", pedido.pagar());
    }
    @Test
    public void devePagarComPix() {
        Carrinho  carrinho = new Carrinho();
        carrinho.adicionarComida(new Comida("HAmBURGUER 1",true, 30, 2));
        Desconto descontoCupom30 = new DescontoCupom30();
        TipoPagamento pagamento = new TipoPagamentoPix();
        Pedido pedido = new Pedido(carrinho,"Express",pagamento, descontoCupom30);
        Cliente cliente = new Cliente("Julia Souza", "12345678901",new Endereco(new Cidade("Juiz de fora","MG"),"Rua A", 1));
        cliente.atualizar(pedido);
        assertEquals("Pagamento realizado no pix no valor de R$42.0", pedido.pagar());
    }

}
