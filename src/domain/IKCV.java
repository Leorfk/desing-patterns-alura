package domain;

public class IKCV extends TemplateImpostoCondicional {

    private boolean temItemMaiorQueCemReais(Orcamento orcamento){
        for (Item item:orcamento.getItems()) {
            if (item.getValor()>100){
                return true;
            }
        }
        return false;
    }

    @Override
    protected double minimaTaxacao(Orcamento orcamento) {
        return orcamento.getValor()*0.06;
    }

    @Override
    protected double maximaTaxacao(Orcamento orcamento) {
        return orcamento.getValor()*0.10;
    }

    @Override
    protected boolean deveUsarTaxacaoMaxima(Orcamento orcamento) {
        return orcamento.getValor()>500&&temItemMaiorQueCemReais(orcamento);
    }
}
