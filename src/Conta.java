public class Conta {
    private double saldo;

    public Conta(double valor){
        saldo = valor;
    }

    public void depositar(double valor){
        this.saldo+=saldo;
    }

    public double getSaldo(){
        return this.saldo;
    }
}
