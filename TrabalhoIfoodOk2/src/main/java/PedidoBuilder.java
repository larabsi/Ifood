public class PedidoBuilder {

    private Pedido pedido;

    public PedidoBuilder() {
        pedido = new Pedido();
    }

    public Pedido build() {
        if (pedido.getCarrinho()== null) {
            throw new IllegalArgumentException("Carrinho vazio");
        }
        return pedido;
    }

    public PedidoBuilder setCarrinho(Carrinho carrinho) {
        pedido.setCarrinho(carrinho);
        return this;
    }

    public PedidoBuilder setTipoDeEntrega(IServicoEntrega tipoDeEntrega) {
        pedido.setTipoEntrega(tipoDeEntrega);
        return this;
    }

    public PedidoBuilder setTipoPagamento(TipoPagamento tipoPagamento) {
        pedido.setTipoPagamento(tipoPagamento);
        return this;
    }

    public PedidoBuilder setObservacaoExtra(String observacaoExtra) {
        pedido.setObservacoesExtras(observacaoExtra);
        return this;
    }

    public PedidoBuilder setNomeDetinatario(String nomeDetinatario) {
        pedido.setNomeDestinatario(nomeDetinatario);
        return this;
    }
    }


