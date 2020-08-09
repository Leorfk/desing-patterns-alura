package domain.observer;

import domain.builder.NotaFiscal;

public class NotaFiscalDAO implements AcaoAposGerarNota{
    @Override
    public void excutar(NotaFiscal notaFiscal) {
        System.out.println("Salva no banco de dados");
    }
}
