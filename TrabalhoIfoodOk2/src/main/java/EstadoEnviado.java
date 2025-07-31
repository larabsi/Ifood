public class EstadoEnviado implements EstadoPedido{
    private EstadoEnviado() {};
    private static EstadoEnviado instance = new EstadoEnviado();
    public static EstadoEnviado getInstance() {
        return instance;
    }

    public String getNomeEstado() {
        return "Enviado";
    }
}
