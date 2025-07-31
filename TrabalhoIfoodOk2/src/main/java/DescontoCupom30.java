public class DescontoCupom30  extends Desconto {
    @Override
    protected float calcula(float valor) {
        return valor * 0.70f;
    }
}