package domain;

public class ImpostoBrasileiro extends Imposto{

    public ImpostoBrasileiro(Imposto outroImposto) {
        super(outroImposto);
    }

    public ImpostoBrasileiro() {
    }

    @Override
    public double calcular(Orcamento orcamento) {
        return orcamento.getValor()*0.2;
    }
}
