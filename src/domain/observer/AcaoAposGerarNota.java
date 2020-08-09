package domain.observer;

import domain.builder.NotaFiscal;

public interface AcaoAposGerarNota {
    void excutar(NotaFiscal notaFiscal);
}
