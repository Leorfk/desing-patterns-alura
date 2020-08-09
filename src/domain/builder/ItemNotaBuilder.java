package domain.builder;

public class ItemNotaBuilder {

    private String nomeItem;
    private double valor;

    public ItemNotaBuilder comNome(String nomeItem){
        this.nomeItem = nomeItem;
        return this;
    }

    public ItemNotaBuilder comPreco(double valor){
        this.valor = valor;
        return this;
    }

    public ItemNota montarItem(){
        return new ItemNota(nomeItem, valor);
    }
}
