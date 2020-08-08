package service;

import domain.Conta;
import service.interfaces.Investimento;

import java.util.Random;

public class InvestimentoModerado implements Investimento {
    private static final double TAXA_MENOR = 0.007;
    private static final double TAXA_MAIOR = 0.025;
    private Random random;

    public InvestimentoModerado() {
        this.random = new Random();
    }

    public double calcularInvestimento(Conta conta) {
        if(random.nextInt(2) == 0) return conta.getSaldo() * TAXA_MAIOR;
        else return conta.getSaldo() * TAXA_MENOR;
    }
}