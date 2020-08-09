package service.conta;

import domain.Conta;

public interface ContaStatus {
    void saca(Conta conta, double valor);
    void depositar(Conta conta, double valor);
}
