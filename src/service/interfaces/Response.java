package service.interfaces;

import domain.Conta;
import domain.Requisicao;

public interface Response {
    void responde(Requisicao requisicao, Conta conta);
    void nextResponseFormat(Response response);
}
