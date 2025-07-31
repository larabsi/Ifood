public class TipoPagamentoPix implements TipoPagamento {
    @Override
    public String pagar(float valor) {
        return "Pagamento realizado no pix no valor de R$"+ valor;
    }
}