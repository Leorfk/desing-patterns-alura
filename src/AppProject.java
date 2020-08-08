import domain.*;
import domain.enums.Formato;
import service.*;
import service.chanFileFormat.ChainFiles;
import service.interfaces.Imposto;
import service.interfaces.Investimento;
import service.interfaces.Response;

public class AppProject {
    public static void main(String[] args) {
//        testeInvestimento();
//        testeOrcamento();
        //testeDescontos();
        testeFileFormat();


    }

    public static void testeFileFormat(){
        ChainFiles chainFiles = new ChainFiles();
        Conta conta = new Conta(1000.00, "Leonardo Rodrigues Ferreira");
        Requisicao request = new Requisicao(Formato.XML);
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
        Conta conta = new Conta(1000.00, "");

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
