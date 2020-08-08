package service;

import domain.Orcamento;
import service.interfaces.Desconto;

public class CalculadorDeDescontos  {

    public double cacula(Orcamento orcamento){
        Desconto d1 = new DescontoAcimaQuinhentosReais();
        Desconto d2 = new DescontoCincoItens();
        Desconto d3 = new SemDesconto();
        d1.setProximo(d2);
        d2.setProximo(d3);

        return d1.desconta(orcamento);
    }
}
