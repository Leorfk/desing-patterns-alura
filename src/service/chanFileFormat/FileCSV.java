package service.chanFileFormat;

import domain.Conta;
import domain.Requisicao;
import domain.enums.Formato;
import service.interfaces.Response;

public class FileCSV implements Response {

    private Response response;

    @Override
    public void responde(Requisicao requisicao, Conta conta) {
        if (requisicao.getFormato() == Formato.CSV){
            System.out.println(conta.getSaldo()+";"+conta.getTitular());
        }else {
            response.responde(requisicao, conta);
        }
    }

    @Override
    public void nextResponseFormat(Response response) {
        this.response = response;
    }
}
