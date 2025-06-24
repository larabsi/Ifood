public abstract class Desconto {
    protected Desconto desconto;

    public float aplicar(float valor) {
        float novoValor = calcula(valor);
        return novoValor;
    }

    protected abstract float calcula(float valor);
}


