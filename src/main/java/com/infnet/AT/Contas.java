package com.infnet.AT;

public abstract class Contas {
    private int numeroDaConta;
    private float saldo;

    public Contas(int numeroDaConta, float saldo) {
        this.numeroDaConta = numeroDaConta;
        this.saldo = saldo;
    }
 
    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta(int numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
       return "Número da conta: " + numeroDaConta + "\nSaldo: "+ saldo; 
    } 
}
