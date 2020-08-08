package service;

import domain.Orcamento;
import service.interfaces.Desconto;

public class SemDesconto implements Desconto {
    @Override
    public double desconta(Orcamento orcamento) {
        return 0;
    }

    @Override
    public void setProximo(Desconto proximo) {
        //não tem
    }
}
