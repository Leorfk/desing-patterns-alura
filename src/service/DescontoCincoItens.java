package service;

import domain.Orcamento;
import service.interfaces.Desconto;

public class DescontoCincoItens implements Desconto {

    private Desconto proximo;

    @Override
    public double desconta(Orcamento orcamento) {
        if (orcamento.getItems().size() > 5){
            return orcamento.getValor()*0.1;
        }else {
            return proximo.desconta(orcamento);
        }
    }

    @Override
    public void setProximo(Desconto proximo) {
        this.proximo = proximo;
    }
}
