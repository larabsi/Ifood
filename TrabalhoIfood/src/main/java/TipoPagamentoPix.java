public class TipoPagamentoPix implements TipoPagamento {
    @Override
    public boolean pagar(float valor) {
        return true;
    }
}