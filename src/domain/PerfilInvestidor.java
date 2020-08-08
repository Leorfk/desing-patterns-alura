package domain;

public enum PerfilInvestidor {
    CONSERVADOR(0) ,
    MODERADO(1),
    ARROJADO(2);

    public int valorInvestidor;
    PerfilInvestidor(int valor){
        valorInvestidor = valor;
    }

    public int getValorInvestidor(){
        return valorInvestidor;
    }
}
