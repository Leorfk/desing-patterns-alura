import domain.*;
import service.*;
import service.interfaces.Imposto;
import service.interfaces.Investimento;

public class AppProject {
    public static void main(String[] args) {
//        testeInvestimento();
//        testeOrcamento();
        testeDescontos();

    }

    public static void testeDescontos(){
        CalculadorDeDescontos descontos = new CalculadorDeDescontos();
        Orcamento orcamento = new Orcamento(500);
        orcamento.getItems().add(new Item("Calculadora", 700));
        orcamento.getItems().add(new Item("Pasta", 300));
        orcamento.getItems().add(new Item("Calculadora", 700));
        orcamento.getItems().add(new Item("Pasta", 300));
        orcamento.getItems().add(new Item("Calculadora", 700));
        orcamento.getItems().add(new Item("Pasta", 300));
        orcamento.getItems().add(new Item("Calculadora", 700));
        orcamento.getItems().add(new Item("Pasta", 300));
        double descontoFinal = descontos.cacula(orcamento);
        System.out.println(descontoFinal);
    }

    public static void testeInvestimento(){
        Conta conta = new Conta(1000.00);

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
