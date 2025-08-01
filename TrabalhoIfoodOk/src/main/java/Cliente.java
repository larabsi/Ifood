import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {
    private String nome;
    private String ultimaNotificacao;

    public Cliente(String nome) {
        this.nome = nome;
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
}
