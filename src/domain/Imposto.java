package domain;

public abstract class Imposto {

    protected final Imposto outroImposto;

    public Imposto(Imposto outroImposto){
        this.outroImposto = outroImposto;
    }

    public Imposto() {
        this.outroImposto = null;
    }

    public abstract double calcular(Orcamento orcamento);
    
    protected double calculoDoOutroImposto(Orcamento orcamento){
        if (outroImposto == null){
            return 0;
        }
        return outroImposto.calcular(orcamento);
    }
}
