package domain;

public class ICCC extends Imposto {

    public ICCC(Imposto outroImposto) {
        super(outroImposto);
    }

    public ICCC() {
    }

    @Override
    public double calcular(Orcamento orcamento) {
        if(orcamento.getValor() < 1000.00){
            return orcamento.getValor() * 0.05;
        }
        else if(orcamento.getValor() <= 3000){
            return orcamento.getValor() * 0.07;
        } else {
            return orcamento.getValor() * 0.08 + 30;
        }
    }
}
