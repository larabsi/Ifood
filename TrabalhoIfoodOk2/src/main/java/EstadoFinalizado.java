public class EstadoFinalizado implements EstadoPedido {
    private EstadoFinalizado() {
    };
    private static EstadoFinalizado instance = new EstadoFinalizado();

    public static EstadoFinalizado getInstance() {
        return instance;
    }

    public String getNomeEstado() {
        return "Finalizado";
    }


}