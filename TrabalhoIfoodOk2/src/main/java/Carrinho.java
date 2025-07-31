import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Carrinho  implements Iterable<Comida>{
    private List<Comida> comidas = new ArrayList<>();

    public void adicionarComida(Comida comida) {
        comidas.add(comida);
    }

    public float calcularValorTotal() {
        float total = 0;
        for (Comida comida : comidas) {
            total += comida.getPreco() * comida.getQuantidade();
        }
        return total;
    }

    private List<Comida> comidasAtivas = new ArrayList<>();


    public Carrinho(Comida... comidasAtivas) {
        this.comidasAtivas = Arrays.asList(comidasAtivas);
    }

    @Override
    public Iterator<Comida> iterator() {
        return comidasAtivas.iterator();
    }

    public List<Comida> getComidas() {
        return comidas;
    }
}

