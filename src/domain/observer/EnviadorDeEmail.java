package domain.observer;

import domain.builder.NotaFiscal;

public class EnviadorDeEmail implements AcaoAposGerarNota{
    @Override
    public void excutar(NotaFiscal notaFiscal) {
        System.out.println("Envia Email");
    }
}
