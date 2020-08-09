package domain;

import service.interfaces.Imposto;

public abstract class TemplateImpostoCondicional implements Imposto {
    @Override
    public double calcular(Orcamento orcamento) {
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
