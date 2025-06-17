import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private static Restaurante instance = new Restaurante();
    private String nome;
    private List<Pedido> pedidos = new ArrayList<>();

    private Restaurante() {
        this.nome = "R1";
    }

    public Restaurante(String nome) {
        this.nome = nome;
    }

    public static Restaurante getInstance() {
        return instance;
    }

    public String getNome() {
        return nome;
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}

