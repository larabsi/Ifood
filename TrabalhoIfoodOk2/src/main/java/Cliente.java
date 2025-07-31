import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer, Cloneable{
    private String nome;
    private Endereco endereco;
    private String ultimaNotificacao;

    private String documento;

    public Cliente(String nome,String documento,Endereco endereco) {
        this.nome = nome;
        this.documento=documento;
        this.endereco=endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void atualizar(Pedido pedido) {
        pedido.addObserver(this);
    }


    @Override
    public void update(Observable pedido, Object arg) {
        this.ultimaNotificacao = this.nome + ", As informacoes do pedido: " + pedido.toString();
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public String obterCliente() {
        return "Cliente{" +
                "nome='" + this.nome + '\'' +
                ", endereco='" + this.getEndereco() + '\'' +
                '}';
    }

    @Override
    public Cliente clone() throws CloneNotSupportedException {
        Cliente clienteClone = (Cliente) super.clone();
        clienteClone.endereco = (Endereco) clienteClone.endereco.clone();
        return clienteClone;
    }
    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
