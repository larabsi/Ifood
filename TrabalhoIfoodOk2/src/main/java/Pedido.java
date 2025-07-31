import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Pedido extends Observable {
    private Carrinho carrinho;
    private EstadoPedido estado;
    private IServicoEntrega tipoEntrega;
    private TipoPagamento tipoPagamento;
    private String nomeDestinatario;
    private String observacoesExtras;

    private Desconto desconto;
private List<EstadoPedido>memento = new ArrayList<EstadoPedido>();
    public Pedido(Carrinho carrinho,String tipoEntrega,TipoPagamento tipoPagamento, Desconto desconto) {
        this.carrinho = carrinho;
        this.tipoEntrega = ServicoEntregaFactory.obterEntrega(tipoEntrega);
        this.tipoPagamento = tipoPagamento;
        this.desconto = desconto;
        this.estado = EstadoNovo.getInstance();
    }
public Pedido (){
        this.carrinho= null;
        this.tipoPagamento=null;
}
    public EstadoPedido getEstado() {
        return this.estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
        setChanged();
        notifyObservers(estado.getNomeEstado());
        this.memento.add(this.estado);
    }
    public void restauraEstado(int indice) {
        if (indice<0 || indice>this.memento.size()-1){
            throw new IllegalArgumentException("Indice invalido");
        }
        this.estado=this.memento.get(indice);
    }
    public List <EstadoPedido>getEstados() {
        return this.memento;
    }

    private List<Cliente> clientes = new ArrayList<>();
    public void adicionarNovoCliente(String nomeCliente,String documento, String nomeCidade, String uf,String logradouro,int numero) {
        Cidade cidade = CidadeFactory.getCidade(nomeCidade, uf);
        Cliente cliente = new Cliente(nomeCliente, documento,new Endereco(new Cidade(nomeCidade,uf),logradouro,numero));
        clientes.add(cliente);
    }

    public List<String> obterClientes() {
        List<String> saida = new ArrayList<String>();
        for (Cliente cliente : this.clientes) {
            saida.add(cliente.obterCliente());
        }
        return saida;
    }
    public float calcularValorFinal() {
        float valorSemDesconto = carrinho.calcularValorTotal();
        if (desconto != null) {
            return desconto.aplicar(valorSemDesconto);
        }
        return valorSemDesconto;
    }
    public String pagar() {
        return tipoPagamento.pagar(calcularValorFinal());
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public IServicoEntrega getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(IServicoEntrega tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    public void setNomeDestinatario(String nomeDestinatario) {
        this.nomeDestinatario = nomeDestinatario;
    }

    public String getObservacoesExtras() {
        return observacoesExtras;
    }

    public void setObservacoesExtras(String observacoesExtras) {
        this.observacoesExtras = observacoesExtras;
    }

    public Desconto getDesconto() {
        return desconto;
    }

    public void setDesconto(Desconto desconto) {
        this.desconto = desconto;
    }

    public List<EstadoPedido> getMemento() {
        return memento;
    }

    public void setMemento(List<EstadoPedido> memento) {
        this.memento = memento;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    public String vizualizarTipoEntrega() {
        return tipoEntrega.entregar();
    }
    @Override
    public String toString() {
        return "Pedido{" +
                "carrinho=" + getCarrinho() +
                ", estado=" + getEstado() +
                '}';
    }
}