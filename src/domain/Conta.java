package domain;

import java.util.Date;

public class Conta {
    private double saldo;
    private String titular;
    private Date dataAbertura;

    public Conta(double saldo, String titular, Date dataAbertura) {
        this.saldo = saldo;
        this.titular = titular;
        this.dataAbertura = dataAbertura;
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

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }
}
