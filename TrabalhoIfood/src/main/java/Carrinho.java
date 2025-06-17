import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<Comida> comidas = new ArrayList<>();

    public void adicionarComida(Comida comida) {
        comidas.add(comida);
    }

    public float calcularTotal() {
        float total = 0;
        for (Comida comida : comidas) {
            total += comida.getPreco() * comida.getQuantidade();
        }
        return total;
    }

    public List<Comida> getComidas() {
        return comidas;
    }
}

