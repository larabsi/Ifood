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
        this.ultimaNotificacao = this.nome + ", seu pedido está agora: " + arg;
        System.out.println(this.ultimaNotificacao);
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }
}
