public class TipoPagamentoCartao implements TipoPagamento {
   private String numeroCartao;

    public TipoPagamentoCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }
    @Override
    public String pagar(float valor) {
        return "Pagamento realizado com Cartão de Crédito: " + numeroCartao+ " No valor de R$"+ valor;
    }

}

