package service.chanFileFormat;

import domain.Conta;
import domain.Requisicao;
import service.interfaces.Response;

public class FileNoFormat implements Response {
    @Override
    public void responde(Requisicao requisicao, Conta conta) {
        System.out.println(conta.getTitular()+conta.getSaldo());
    }

    @Override
    public void nextResponseFormat(Response response) {

    }
}
