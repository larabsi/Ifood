import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {
    private Pedido pedido;
    private Cliente cliente;
    private Carrinho carrinho;
    private Desconto descontoCupom;
    private TipoPagamento pagamento;

    @BeforeEach
    public void setup() {

        carrinho = new Carrinho();
        carrinho.adicionarComida(new Comida("HAmBURGUER 1",true, 30, 2));
        carrinho.adicionarComida(new Comida("HAMBURGUER 2", true,45, 1));

        descontoCupom = new DescontoCupom30();
        pagamento = new TipoPagamentoCartao("3658741");
        pedido = new Pedido(carrinho,"Comum", pagamento, descontoCupom);

        cliente = new Cliente("Julia Souza", "12345678901",new Endereco(new Cidade("Juiz de fora","MG"),"Rua A", 1));
        cliente.atualizar(pedido);
    }

    @Test
    public void deveNotificarQuandoEstadoMudarDeNovoParaFinalizado() {
        pedido.setEstado(EstadoNovo.getInstance());
        pedido.setEstado(EstadoFinalizado.getInstance());
        assertNotNull(cliente.getUltimaNotificacao());
        assertTrue(cliente.getUltimaNotificacao().contains("Finalizado"));
    }


    @Test
    public void deveNotificarQuandoEstadoMudarEmPreparoParaEnviado() {
        pedido.setEstado(EstadoEmPreparo.getInstance());
        pedido.setEstado(EstadoEnviado.getInstance());
        assertNotNull(cliente.getUltimaNotificacao());
        assertTrue(cliente.getUltimaNotificacao().contains("Enviado"));
    }

    @Test
    void testClone() throws CloneNotSupportedException {
        Cliente cliente = new Cliente("Cliente Original", "12345678901",new Endereco(new Cidade("Juiz de fora","MG"),"Rua A", 1));

        Cliente clienteClone = cliente.clone();
        clienteClone.setNome("Cliente Clonado");
        clienteClone.getEndereco().setNumero(1000);

        assertEquals("Cliente{nome='Cliente Original', endereco=Endereco{logradouro='Rua A', numero=1, cidade=Juiz de fora, uf=MG}}", cliente.toString());
        assertEquals("Cliente{nome='Cliente Clonado', endereco=Endereco{logradouro='Rua A', numero=1000, cidade=Juiz de fora, uf=MG}}", clienteClone.toString());
    }

    @Test
    void deveRetornarClientes() {

        pedido.adicionarNovoCliente("Julia Souza","12345678901","Juiz de fora","MG","Rua A", 1485);
        pedido.adicionarNovoCliente("Camila","12345678901","Juiz de fora","MG","Rua C", 147);
        pedido.adicionarNovoCliente("Joao","12345678901","Rio de Janeiro","RJ","Rua A", 1);

        List<String> saida = Arrays.asList(
                "Cliente{nome='Julia Souza', endereco='Endereco{logradouro='Rua A', numero=1485, cidade=Juiz de fora, uf=MG}'}",
                "Cliente{nome='Camila', endereco='Endereco{logradouro='Rua C', numero=147, cidade=Juiz de fora, uf=MG}'}",
                "Cliente{nome='Joao', endereco='Endereco{logradouro='Rua A', numero=1, cidade=Rio de Janeiro, uf=RJ}'}");

        assertEquals(saida, pedido.obterClientes());
    }

    @Test
    void deveRetornarTotalCidades() {
        pedido.adicionarNovoCliente("Julia Souza","12345678901","Juiz de fora","MG","Rua A", 1485);
        pedido.adicionarNovoCliente("Camila","12345678901","Juiz de fora","MG","Rua C", 147);
        pedido.adicionarNovoCliente("Joao","12345678901","Rio de Janeiro","RJ","Rua A", 1);
        assertEquals(2, CidadeFactory.getTotalCidades());
    }


}