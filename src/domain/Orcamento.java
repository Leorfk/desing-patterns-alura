package domain;

import service.interfaces.EstadoDeUmOrcamento;
import service.state.EmAprovacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Orcamento {
    public double valor;
    private final List<Item> items;
    public EstadoDeUmOrcamento estadoAtual;


    public Orcamento(double valor) {
        this.valor = valor;
        items = new ArrayList<>();
        estadoAtual = new EmAprovacao();
    }

    public double getValor() {
        return valor;
    }

    public void addItem(Item item){
        items.add(item);
    }
    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void aplicaDescontoExtra() {
        estadoAtual.aplicaDescontoExtra(this);
    }

    public void aprova(){
        estadoAtual.aprova(this);
    }

    public void reprova(){
        estadoAtual.reprova(this);
    }

    public void finaliza(){
        estadoAtual.finaliza(this);
    }
}
