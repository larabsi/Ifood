public class DescontoFidelidade  extends Desconto {
    @Override
    protected float calcula(float valor) {
        return valor * 0.95f;
    }
}
