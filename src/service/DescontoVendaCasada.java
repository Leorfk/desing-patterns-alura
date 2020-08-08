package service;

import domain.Item;
import domain.Orcamento;
import service.interfaces.Desconto;

public class DescontoVendaCasada implements Desconto {

    private Desconto proximo;

    @Override
    public double desconta(Orcamento orcamento) {
        if (aconteceuVendaCasada(orcamento)){
            return orcamento.getValor()*0.05;
        }else{
            return proximo.desconta(orcamento);
        }
    }

    @Override
    public void setProximo(Desconto proximo) {
        this.proximo = proximo;
    }

    private boolean itemExiste(String nomeItem, Orcamento orcamento){

        for (Item item: orcamento.getItems()) {
            if (item.getNome().equals(nomeItem)){
                return true;
            }
        }
        return false;
    }

    private boolean aconteceuVendaCasada(Orcamento orcamento){
        return itemExiste("CANETA", orcamento) && itemExiste("LAPIS", orcamento);
    }
}
