import java.util.Iterator;

public class RevisarCarrinho{
    public static Integer contarComidasAtivasCarrinho(Carrinho carrinho) {
        int quantidade = 0;
        for (Comida comida : carrinho) {
            if (comida.isAtivo()) {
                quantidade++;
            }
        }
        return quantidade;
    }

    public static Integer contarTotalComidasCarrinho(Carrinho carrinho) {
        int quantidade = 0;
        for (Iterator a = carrinho.iterator(); a.hasNext(); ) {
            quantidade++;
            a.next();
        }
        return quantidade;
    }


}
