public abstract class EstadoPedido {
    public abstract String getEstado();

    public boolean novo(Pedido pedido) {
        return false;
    }
    public boolean preparar(Pedido pedido) {
        return false;
    }
    public boolean finalizar(Pedido pedido) {
        return false;
    }
    public boolean enviar(Pedido pedido) {
        return false;
    }

}
