public class DescontoCupom10 extends Desconto {
    @Override
    protected float calcula(float valor) {
        return valor * 0.90f;
    }
}
