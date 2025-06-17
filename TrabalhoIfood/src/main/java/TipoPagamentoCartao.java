public class TipoPagamentoCartao  implements TipoPagamento {
    @Override
    public boolean pagar(float valor) {
        return true;
    }
}

