package service;

import domain.Conta;
import service.interfaces.Investimento;

public class RealizadorDeInvestimentos{

    public void realiza(Conta conta, Investimento investimento){
        double resultado = investimento.calcularInvestimento(conta);

        conta.depositar(resultado * 0.75);
        System.out.println("Novo Saldo: " + conta.getSaldo());
    }
}
