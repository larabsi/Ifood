public class EstadoEmPreparo implements EstadoPedido{
    private EstadoEmPreparo() {};
    private static EstadoEmPreparo instance = new EstadoEmPreparo();
    public static EstadoEmPreparo getInstance() {
        return instance;
    }

    public String getNomeEstado() {
        return "Em preparo";
    }

}
