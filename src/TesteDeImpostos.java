public class TesteDeImpostos {
    public static void main(String[] args) {
     Imposto iss = new ISS();
     Imposto icms = new ICMS();

     Orcamento orcamento = new Orcamento(5000.00);

     CalculadorDeImpostos calculadorDeImpostos = new CalculadorDeImpostos();

     calculadorDeImpostos.realizarCalculo(orcamento, iss);
     calculadorDeImpostos.realizarCalculo(orcamento, icms);
    }
}
