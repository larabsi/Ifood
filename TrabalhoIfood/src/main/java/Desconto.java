public abstract class Desconto {
    protected Desconto proximo;

    public void setProximo(Desconto proximo) {
        this.proximo = proximo;
    }

    public float aplicar(float valor) {
        float novoValor = calcula(valor);
        if (proximo != null) {
            return proximo.aplicar(novoValor);
        }
        return novoValor;
    }

    protected abstract float calcula(float valor);
}


