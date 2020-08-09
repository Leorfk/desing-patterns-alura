package service.state;

import domain.Orcamento;
import service.interfaces.EstadoDeUmOrcamento;

public class Aprovado implements EstadoDeUmOrcamento {

    public void aplicaDescontoExtra(Orcamento orcamento){
        orcamento.valor -= orcamento.valor*0.02;
    }

    @Override
    public void aprova(Orcamento orcamento) {
        throw new RuntimeException("Orçamento já está aprovado");
    }

    @Override
    public void reprova(Orcamento orcamento) {
        throw new RuntimeException("Não podemos reprovar um orçamento aprovado");
    }

    @Override
    public void finaliza(Orcamento orcamento) {
        orcamento.estadoAtual = new Finalizado();
    }
}
