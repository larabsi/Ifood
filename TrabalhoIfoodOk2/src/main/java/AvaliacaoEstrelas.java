public class AvaliacaoEstrelas  implements IAvaliacao {

    private String estrelas;

    @Override
    public String getAvaliacao() {
        return this.estrelas;
    }

    @Override
    public void setAvaliacao(String estrelas) {
        this.estrelas = estrelas;
    }
}