package domain;

import service.interfaces.Imposto;

public class ICPP extends TemplateImpostoCondicional {
    @Override
    public double minimaTaxacao(Orcamento orcamento) {
        return orcamento.getValor()*0.05;
    }

    @Override
    public double maximaTaxacao(Orcamento orcamento) {
        return orcamento.getValor()*0.07;
    }

    @Override
    public boolean deveUsarTaxacaoMaxima(Orcamento orcamento) {
        return orcamento.getValor()>500;
    }
}
