package domain.observer;

import domain.builder.NotaFiscal;

public class EnviadorDeSMS implements AcaoAposGerarNota{
    @Override
    public void excutar(NotaFiscal notaFiscal) {
        System.out.println("Envia SMS");
    }
}
