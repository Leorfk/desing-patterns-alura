package domain;

import service.conta.ContaStatus;
import service.conta.Positivo;

import java.util.Date;

public class Conta {
    private double saldo;
    private String titular;
    private Date dataAbertura;
    public ContaStatus estado;

    public Conta(double saldo, String titular, Date dataAbertura) {
        this.saldo = saldo;
        this.titular = titular;
        this.dataAbertura = dataAbertura;
        estado = new Positivo();
    }

    public Conta() {
        estado = new Positivo();
    }

    public double getSaldo(){
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
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

    public void depositar(double valor){
        estado.depositar(this, valor);
    }
    public void saca(double valor){
        estado.saca(this, valor);
    }
}
