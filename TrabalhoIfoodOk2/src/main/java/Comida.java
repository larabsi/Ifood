public class Comida {
    private String nome;
    private float preco;
    private int quantidade;

    private boolean ativo;
    IAvaliacao avaliacao;
    AvaliacaoAdapter persistencia;

    public Comida(String nome, boolean ativo,float preco, int quantidade) {
        this.nome = nome;
        this.ativo=ativo;
        this.preco = preco;
        this.quantidade = quantidade;
        avaliacao = new AvaliacaoEstrelas();
        persistencia = new AvaliacaoAdapter(avaliacao);
    }


    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getNome() {
        return nome;
    }

    public void setAvaliacao(String estrelas) {
        avaliacao.setAvaliacao(estrelas);
        persistencia.salvarAvaliacao();
    }

    public String getAvaliacao() {
        return persistencia.recuperarAvaliacao();
    }
    public float getNota() {
        return persistencia.getNota();
    }
    public float getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }
}