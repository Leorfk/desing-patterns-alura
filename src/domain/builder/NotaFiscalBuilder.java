package domain.builder;

import domain.observer.AcaoAposGerarNota;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NotaFiscalBuilder {

    private String razaoSocial;
    private String cnpj;
    private double valorBruto;
    private double imposto;
    private String observacao;
    private Calendar data;

    public NotaFiscalBuilder(){
        this.todasAcoesASeremExecutadas = new ArrayList<AcaoAposGerarNota>();
    }

    private  List<AcaoAposGerarNota> todasAcoesASeremExecutadas;

    private List<ItemNota> notaItens = new ArrayList<ItemNota>();

    public NotaFiscalBuilder paraEmpresa(String razaoSocial){
        this.razaoSocial = razaoSocial;
        return this;
    }

    public NotaFiscalBuilder comCNPJ(String cnpj){
        this.cnpj = cnpj;
        return this;
    }

    public NotaFiscalBuilder comItem(ItemNota item){
        notaItens.add(item);
        valorBruto += item.getValor();
        imposto += item.getValor()*0.05;
        return this;
    }

    public NotaFiscalBuilder comObservacoes(String observacao){
        this.observacao = observacao;
        return this;
    }

    public NotaFiscalBuilder naDataAtual(){
        this.data = Calendar.getInstance();
        return this;
    }

    public NotaFiscal contruir(){
        NotaFiscal notaFiscal = new NotaFiscal(razaoSocial, cnpj, data, valorBruto, imposto, notaItens, observacao);
        for (AcaoAposGerarNota acao:todasAcoesASeremExecutadas) {
            acao.excutar(notaFiscal);
        }
        return notaFiscal;
    }

    public void adicionarAcao(AcaoAposGerarNota novaAcao){
        this.todasAcoesASeremExecutadas.add(novaAcao);
    }

}
