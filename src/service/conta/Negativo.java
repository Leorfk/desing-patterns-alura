package service.conta;

import domain.Conta;

public class Negativo implements ContaStatus {
    @Override
    public void saca(Conta conta, double valor) {
        throw new RuntimeException("Conta con saldo negativo");
    }

    @Override
    public void depositar(Conta conta, double valor) {
        double deposito = (valor*0.95)+conta.getSaldo();
        conta.setSaldo(deposito);
        if (conta.getSaldo() > 0){
            conta.estado = new Positivo();
        }
    }
}
