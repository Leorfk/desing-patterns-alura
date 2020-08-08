package domain;

import service.interfaces.Imposto;

public class ICMS implements Imposto {
    @Override
    public double calcular(Orcamento orcamento) {
        return orcamento.getValor()*0.1;
    }
}
