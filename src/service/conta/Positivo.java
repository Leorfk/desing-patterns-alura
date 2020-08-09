package service.conta;

import domain.Conta;

public class Positivo implements ContaStatus{
    @Override
    public void saca(Conta conta, double valor) {
        double saque = conta.getSaldo() - valor;
        conta.setSaldo(saque);
        if (conta.getSaldo() < 0){
            conta.estado = new Negativo();
        }
    }

    @Override
    public void depositar(Conta conta, double valor) {
        double deposito = valor + conta.getSaldo();
        conta.setSaldo(deposito);
    }
}
