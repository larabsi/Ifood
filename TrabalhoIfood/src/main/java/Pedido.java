import java.util.Observable;

public class Pedido extends Observable {
    private Carrinho carrinho;
    private EstadoPedido estado;
    private Restaurante restaurante;
    private TipoPagamento tipoPagamento;
    private Desconto desconto;

    public Pedido(Carrinho carrinho,Restaurante restaurante, TipoPagamento tipoPagamento, Desconto desconto) {
        this.carrinho = carrinho;
        this.restaurante=restaurante;
        this.tipoPagamento = tipoPagamento;
        this.desconto = desconto;
        this.estado = EstadoNovo.getInstance();
        restaurante.adicionarPedido(this);
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
        setChanged();
        notifyObservers(estado.getEstado());
    }

    public void preparar() {
        if(estado.preparar(this)) {
            setChanged();
            notifyObservers(estado.getEstado());
        }
    }

    public void enviar() {
        if(estado.enviar(this)) {
            setChanged();
            notifyObservers(estado.getEstado());
        }
    }

    public void finalizar() {
        if(estado.finalizar(this)) {
            setChanged();
            notifyObservers(estado.getEstado());
        }
    }

    public float calcularValorFinal() {
        float valorSemDesconto = carrinho.calcularTotal();
        if (desconto != null) {
            return desconto.aplicar(valorSemDesconto);
        }
        return valorSemDesconto;
    }
    public Restaurante getRestaurante() {
        return restaurante;
    }
    public boolean pagar() {
        return tipoPagamento.pagar(calcularValorFinal());
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }
}