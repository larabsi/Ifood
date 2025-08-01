public class Endereco implements Cloneable {
    private Cidade nomeCidade;
    private String logradouro;
    private Integer numero;

    public Endereco(Cidade nomeCidade,String logradouro, Integer numero) {
        super();
        this.nomeCidade = nomeCidade;
        this.logradouro = logradouro;
        this.numero = numero;
    }



    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "logradouro='" + logradouro + '\'' +
                ", numero=" + numero  +
                ", cidade=" + nomeCidade.getNome() +
                ", uf=" + nomeCidade.getUf() +

                '}';
    }
}