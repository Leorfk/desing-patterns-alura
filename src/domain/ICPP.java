package domain;

public class ICPP extends TemplateImpostoCondicional {
    @Override
    protected double minimaTaxacao(Orcamento orcamento) {
        return orcamento.getValor()*0.05;
    }

    @Override
    protected double maximaTaxacao(Orcamento orcamento) {
        return orcamento.getValor()*0.07;
    }

    @Override
    protected boolean deveUsarTaxacaoMaxima(Orcamento orcamento) {
        return orcamento.getValor()>500;
    }
}
