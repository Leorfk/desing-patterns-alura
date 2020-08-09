package domain.observer;

import domain.builder.NotaFiscal;

public class Impressora implements AcaoAposGerarNota{
    @Override
    public void excutar(NotaFiscal notaFiscal) {
        System.out.println("Nota impressa");
    }
}
