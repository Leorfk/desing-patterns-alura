package domain;

import java.util.ArrayList;
import java.util.List;

public class FiltroMenorQueCemReais extends Filtro{

    public FiltroMenorQueCemReais(Filtro outroFiltro) {
        super(outroFiltro);
    }

    public FiltroMenorQueCemReais() {
    }

    @Override
    public List<Conta> filtrar(List<Conta> contas) {
        List<Conta> filtrada = new ArrayList<Conta>();
        for (Conta conta:contas) {
            if (conta.getSaldo() < 100){
                filtrada.add(conta);
            }
        }
        filtrada.addAll(proximo(contas));
        return filtrada;
    }
}
