public class EstadoEmPreparo extends EstadoPedido{
    private EstadoEmPreparo() {};
    private static EstadoEmPreparo instance = new EstadoEmPreparo();
    public static EstadoEmPreparo getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Em preparo";
    }
    public boolean enviar(Pedido pedido) {
        pedido.setEstado(EstadoEnviado.getInstance());
        return true;
    }
}
