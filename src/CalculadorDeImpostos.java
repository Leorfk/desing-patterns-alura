public class CalculadorDeImpostos {
    public void realizarCalculo(Orcamento orcamento, Imposto impostoQualquer){
        double icms = impostoQualquer.calcular(orcamento);
        System.out.println(icms);
    }
}
