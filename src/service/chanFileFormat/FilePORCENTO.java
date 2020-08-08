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
        } else if(response != null){
            response.responde(requisicao, conta);
        } else {
            // não existe próxima na corrente, e ninguém atendeu a requisição!
            // poderíamos não ter feito nada aqui, caso não fosse necessário!
            throw new RuntimeException("Formato de resposta não encontrado");
        }
    }

    @Override
    public void nextResponseFormat(Response response) {
        this.response = response;
    }
}
