package domain.builder;

public class ItemNota {
    private String nome;
    private double valor;

    public ItemNota(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }
}
