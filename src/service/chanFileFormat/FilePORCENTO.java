package service.chanFileFormat;

import domain.Conta;
import domain.Requisicao;
import domain.enums.Formato;
import service.interfaces.Response;

public class FilePORCENTO implements Response {
    private Response response;
    @Override
    public void responde(Requisicao requisicao, Conta conta) {
        if (requisicao.getFormato() == Formato.PORCENTO){
            System.out.println("%"+ conta.getTitular() + "%" + conta.getSaldo() +"%");
        }else {
            response.responde(requisicao, conta);
        }

    }

    @Override
    public void nextResponseFormat(Response response) {
        this.response = response;
    }
}
