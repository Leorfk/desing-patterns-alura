package domain;

import java.util.ArrayList;
import java.util.List;

public class IHIT extends TemplateImpostoCondicional{
    @Override
    protected double minimaTaxacao(Orcamento orcamento) {
        return orcamento.getValor() * (0.01 * orcamento.getItems().size());
    }

    @Override
    protected double maximaTaxacao(Orcamento orcamento) {
        return orcamento.getValor()*0.13+100;
    }

    @Override
    protected boolean deveUsarTaxacaoMaxima(Orcamento orcamento) {
        List<String> validaOrcamentos = new ArrayList<>();
        for (Item item:orcamento.getItems()) {
            if (validaOrcamentos.contains(item.getNome())){
                return true;
            }else {
                validaOrcamentos.add(item.getNome());
            }
        }
        return false;
    }
}
