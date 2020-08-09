package domain;

import java.util.ArrayList;
import java.util.List;

public class FiltroMaiorQueQuinhentosMilReais extends Filtro{

    public FiltroMaiorQueQuinhentosMilReais(Filtro outroFiltro) {
        super(outroFiltro);
    }

    public FiltroMaiorQueQuinhentosMilReais() {
    }

    @Override
    public List<Conta> filtrar(List<Conta> contas) {
        List<Conta> filtrada = new ArrayList<Conta>();
        for (Conta conta:contas) {
            if (conta.getSaldo() > 500000){
                filtrada.add(conta);
            }
        }
        filtrada.addAll(proximo(contas));
        return filtrada;
    }
}
