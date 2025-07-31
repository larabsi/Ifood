public class EstadoNovo implements EstadoPedido{
    private EstadoNovo() {};
    private static EstadoNovo instance = new EstadoNovo();
    public static EstadoNovo getInstance() {
        return instance;
    }

    public String getNomeEstado() {
        return "Novo";
    }

}
