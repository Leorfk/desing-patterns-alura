package domain;

public class ISS extends Imposto {
    public ISS(Imposto outroImposto) {
        super(outroImposto);
    }

    public ISS() {
    }

    @Override
    public double calcular(Orcamento orcamento) {
        return orcamento.getValor()*0.06+calculoDoOutroImposto(orcamento);
    }

    protected double calculoDoOutroImposto(Orcamento orcamento) {
        return outroImposto.calcular(orcamento);
    }
}
