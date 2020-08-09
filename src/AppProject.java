import domain.*;
import domain.builder.ItemNota;
import domain.builder.ItemNotaBuilder;
import domain.builder.NotaFiscal;
import domain.builder.NotaFiscalBuilder;
import domain.enums.Formato;
import domain.observer.EnviadorDeEmail;
import domain.observer.EnviadorDeSMS;
import domain.observer.Impressora;
import domain.observer.NotaFiscalDAO;
import service.*;
import service.chanFileFormat.ChainFiles;
import domain.Imposto;
import service.interfaces.Investimento;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AppProject {
    public static void main(String[] args) {
//        testeInvestimento();
//        testeOrcamento();
        //testeDescontos();
        //testeFileFormat();
//        testeInpostoComposto();
//        testeImpostoBrasileiro();
        //testeDescontoExtraUsandoState();
        //testeSaldoConta();
        testeNotaFiscalBuilder();
        testeNotaFiscalObserver();
    }

    public static void testeNotaFiscalObserver(){
        NotaFiscalBuilder builder = new NotaFiscalBuilder();
        builder.adicionarAcao(new EnviadorDeEmail());
        builder.adicionarAcao(new NotaFiscalDAO());
        builder.adicionarAcao(new EnviadorDeSMS());
        builder.adicionarAcao(new Impressora());

        NotaFiscal nf = builder.paraEmpresa("Teste")
                .comCNPJ("00.000.000/0001-91")
                .comItem(new ItemNota("XAP", 30.00))
                .comItem(new ItemNota("Caminhão", 150000.00))
                .comObservacoes("Aquisição de nova frota XPTO")
                .naDataAtual()
                .contruir();
    }

    public static void testeNotaFiscalBuilder(){
        NotaFiscalBuilder builder = new NotaFiscalBuilder();
        ItemNotaBuilder itemNotaBuilder = new ItemNotaBuilder();
        itemNotaBuilder.comNome("Carreta").comPreco(50000.00);
        builder.paraEmpresa("Teste")
                .comCNPJ("00.000.000/0001-91")
                .comItem(itemNotaBuilder.montarItem())
                .comItem(new ItemNota("Caminhão", 150000.00))
                .comObservacoes("Aquisição de nova frota XPTO")
                .naDataAtual();
        NotaFiscal nf = builder.contruir();
        System.out.println(nf.getValorBruto());
//        List<ItemNota> itens = Arrays.asList(
//                new ItemNota("Carreta", 50000.00),
//                new ItemNota("Caminhão", 150000.00)
//        );
//        double valorTotal = 0;
//        for (ItemNota item:itens) {
//            valorTotal += item.getValor();
//        }
//
//        double imposto = valorTotal*0.05;
//
//        NotaFiscal nf = new NotaFiscal("Teste", "00000000000191", Calendar.getInstance(), valorTotal, imposto, itens,
//                "Items referentes a frota XPTO");
    }

    public static void testeSaldoConta(){
        Conta conta = new Conta(1000.00, "Leonardo", new Date());
        conta.depositar(1000.00);
        System.out.println(conta.getSaldo());
        conta.saca(2500.00);
        System.out.println(conta.getSaldo());
        conta.saca(2500.00);
        System.out.println(conta.getSaldo());
    }

    public static void testeDescontoExtraUsandoState(){
        Orcamento orcamento = new Orcamento(500.00);
        orcamento.aplicaDescontoExtra();
        System.out.println(orcamento.getValor());
        orcamento.aprova();
        orcamento.aplicaDescontoExtra();
        System.out.println(orcamento.getValor());
        orcamento.finaliza();
        orcamento.aplicaDescontoExtra();
        System.out.println(orcamento.getValor());
    }

    public static void testeImpostoBrasileiro(){
        Imposto icms = new ICMS();
        Imposto impostoComposto = new ImpostoBrasileiro(icms);

        Orcamento orcamento = new Orcamento(5000.00);

        double valor = impostoComposto.calcular(orcamento);

        System.out.println(valor);
    }

    public static void testeInpostoComposto(){
        Imposto impostoComplexo = new ISS(new ICMS());

        Orcamento orcamento = new Orcamento(500.0);

        double valor = impostoComplexo.calcular(orcamento);

        System.out.println(valor);

    }

    public static void testeFileFormat(){
        ChainFiles chainFiles = new ChainFiles();
        Conta conta = new Conta(1000.00, "Leonardo Rodrigues Ferreira", new Date());
        Requisicao request = new Requisicao(Formato.NO_FORMAT);
        chainFiles.generateFile(request, conta);
    }

    public static void testeDescontos(){
        CalculadorDeDescontos descontos = new CalculadorDeDescontos();
        Item lapis = new Item("LAPIS", 15.00);
        Item caneta = new Item("CANETA", 15.00);
        Item borracha = new Item("borracha", 15.00);

        Orcamento orcamento = new Orcamento(500);
        orcamento.addItem(caneta);
        orcamento.addItem(borracha);
        orcamento.addItem(lapis);

        double descontoFinal = descontos.cacula(orcamento);
        System.out.println(descontoFinal);
    }

    public static void testeInvestimento(){
        Conta conta = new Conta(1000.00, "", new Date());

        Investimento arrojado = new InvestimentoArrojado();
        Investimento moderado = new InvestimentoModerado();
        Investimento conservador = new InvestimentoConservador();
        RealizadorDeInvestimentos realizadorDeInvestimentos = new RealizadorDeInvestimentos();
        realizadorDeInvestimentos.realiza(conta, arrojado);
        realizadorDeInvestimentos.realiza(conta, moderado);
        realizadorDeInvestimentos.realiza(conta, conservador);
    }

    public static void testeOrcamento(){
        Imposto iss = new ISS();
        Imposto icms = new ICMS();
        Imposto iccc = new ICCC();

        Orcamento orcamento = new Orcamento(5000.00);

        CalculadorDeImpostos calculadorDeImpostos = new CalculadorDeImpostos();

        calculadorDeImpostos.realizarCalculo(orcamento, iss);
        calculadorDeImpostos.realizarCalculo(orcamento, icms);
        calculadorDeImpostos.realizarCalculo(orcamento, iccc);
    }
}
