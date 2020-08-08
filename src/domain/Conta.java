package domain;

public class Conta {
    private double saldo;
    private String titular;

    public Conta(double saldo, String titular) {
        this.saldo = saldo;
        this.titular = titular;
    }

    public Conta() {
    }

    public void depositar(double valor){
        this.saldo+=saldo;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public String getTitular() {
        return titular;
    }

}
