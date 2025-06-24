public class EstadoFinalizado extends EstadoPedido {
    private EstadoFinalizado() {
    }

    ;
    private static EstadoFinalizado instance = new EstadoFinalizado();

    public static EstadoFinalizado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Finalizado";
    }

    public boolean preparar(Pedido pedido) {
        pedido.setEstado(EstadoEmPreparo.getInstance());
        return true;
    }
}