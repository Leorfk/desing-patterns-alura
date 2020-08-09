package domain;

public abstract class TemplateImpostoCondicional extends Imposto {

    public TemplateImpostoCondicional(Imposto outroImposto) {
        super(outroImposto);
    }

    public TemplateImpostoCondicional() {
    }

    @Override
    public final double calcular(Orcamento orcamento) {
        if (deveUsarTaxacaoMaxima(orcamento)){
            return maximaTaxacao(orcamento);
        }else {
            return minimaTaxacao(orcamento);
        }
    }

    protected abstract double minimaTaxacao(Orcamento orcamento);

    protected abstract double maximaTaxacao(Orcamento orcamento);

    protected abstract boolean deveUsarTaxacaoMaxima(Orcamento orcamento);
}
