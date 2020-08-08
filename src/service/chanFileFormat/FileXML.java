package service.chanFileFormat;

import domain.Conta;
import domain.Requisicao;
import domain.enums.Formato;
import service.interfaces.Response;

public class FileXML implements Response {

    private Response response;

    @Override
    public void responde(Requisicao requisicao, Conta conta) {
        if (requisicao.getFormato() == Formato.XML){
            System.out.println(
                "<conta>" +
                    "<titular>" +
                        conta.getTitular() +
                    "</titular>" +
                    "<saldo>" +
                        conta.getSaldo() +
                    "</saldo>" +
                "</conta>");
        }else {
            response.responde(requisicao, conta);
        }
    }

    @Override
    public void nextResponseFormat(Response response) {
        this.response = response;
    }
}
