public class ServicoEntregaFactory {
    public static IServicoEntrega obterEntrega(String tipoEntrega) {
        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName("ServicoEntrega" + tipoEntrega);
            objeto = classe.newInstance();
        } catch (Exception ex) {
            throw new IllegalArgumentException("Tipo de Entrega inexistente");
        }
        if (!(objeto instanceof IServicoEntrega)) {
            throw new IllegalArgumentException("Tipo de Entrega inválida");
        }
        return (IServicoEntrega) objeto;
    }
}
