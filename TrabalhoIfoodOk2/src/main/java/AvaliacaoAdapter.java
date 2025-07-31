public class AvaliacaoAdapter  extends AvaliacaoNota {

    private IAvaliacao avaliacaoEstrelas;

    public AvaliacaoAdapter(IAvaliacao avaliacaoEstrelas) {
        this.avaliacaoEstrelas = avaliacaoEstrelas;
    }

    public String recuperarAvaliacao() {
        if (this.getNota() >= 9.0f)
            avaliacaoEstrelas.setAvaliacao("*****");
        else if (this.getNota() >= 7.0f)
            avaliacaoEstrelas.setAvaliacao("****");
        else if (this.getNota() >= 5.0f)
            avaliacaoEstrelas.setAvaliacao("***");
        else if (this.getNota() >= 4.0f)
            avaliacaoEstrelas.setAvaliacao("**");
        else
            avaliacaoEstrelas.setAvaliacao("*");
        return avaliacaoEstrelas.getAvaliacao();
    }

    public void salvarAvaliacao() {
        if (avaliacaoEstrelas.getAvaliacao().equals("*****"))
            this.setNota(9.0f);
        else if (avaliacaoEstrelas.getAvaliacao().equals("****"))
            this.setNota(7.0f);
        else if (avaliacaoEstrelas.getAvaliacao().equals("***"))
            this.setNota(5.0f);
        else if (avaliacaoEstrelas.getAvaliacao().equals("**"))
            this.setNota(4.0f);
        else
            this.setNota(0.0f);
    }
}