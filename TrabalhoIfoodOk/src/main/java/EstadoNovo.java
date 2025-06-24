public class EstadoNovo extends EstadoPedido{
    private EstadoNovo() {};
    private static EstadoNovo instance = new EstadoNovo();
    public static EstadoNovo getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Novo";
    }
    public boolean finalizar(Pedido pedido) {
        pedido.setEstado(EstadoFinalizado.getInstance());
        return true;
    }
}
