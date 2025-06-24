import java.util.Observable;

public class Pedido extends Observable {
    private Carrinho carrinho;
    private EstadoPedido estado;
    private TipoPagamento tipoPagamento;
    private Desconto desconto;

    public Pedido(Carrinho carrinho, TipoPagamento tipoPagamento, Desconto desconto) {
        this.carrinho = carrinho;
        this.tipoPagamento = tipoPagamento;
        this.desconto = desconto;
        this.estado = EstadoNovo.getInstance();
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

    @Override
    public String toString() {
        return "Pedido{" +
                "carrinho=" + getCarrinho() +
                ", estado=" + getEstado() +
                '}';
    }
}