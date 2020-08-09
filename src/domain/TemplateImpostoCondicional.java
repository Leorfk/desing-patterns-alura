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

    public abstract double minimaTaxacao(Orcamento orcamento);

    public abstract double maximaTaxacao(Orcamento orcamento);

    public abstract boolean deveUsarTaxacaoMaxima(Orcamento orcamento);
}
