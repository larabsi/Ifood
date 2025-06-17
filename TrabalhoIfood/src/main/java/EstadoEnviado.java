public class EstadoEnviado extends EstadoPedido{
    private EstadoEnviado() {};
    private static EstadoEnviado instance = new EstadoEnviado();
    public static EstadoEnviado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Enviado";
    }
}
