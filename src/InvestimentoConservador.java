public class InvestimentoConservador implements Investimento{
    private static final double TAXA = 0.008;
    @Override
    public double calcularInvestimento(Conta conta) {
        return conta.getSaldo()*TAXA;
    }
}
