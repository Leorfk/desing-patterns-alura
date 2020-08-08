import java.util.Random;

public class InvestimentoArrojado implements Investimento {
    private static final double TAXA_MENOR = 0.006;
    private static final double TAXA_MEDIA = 0.03;
    private static final double TAXA_MAIOR = 0.05;
    private Random random;

    public InvestimentoArrojado() {
        this.random = new Random();
    }

    @Override
    public double calcularInvestimento(Conta conta) {
        int estimativa = random.nextInt(10);
        if(estimativa >= 0 && estimativa <= 1) return conta.getSaldo() * 0.05;
        else if (estimativa >= 2 && estimativa <= 4) return conta.getSaldo() * 0.03;
        else return conta.getSaldo() * 0.006;
    }
}
