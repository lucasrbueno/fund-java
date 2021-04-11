package com.infnet.AT;

import java.util.ArrayList;

public abstract class Contas {
    private int numeroDaConta;
    private float saldo;
    
    StringBuilder operacoes = new StringBuilder();

    public Contas(int numeroDaConta, float saldo) {
        this.numeroDaConta = numeroDaConta;
        this.saldo = saldo;
    }
    
    public Contas(float saldo) {
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
    
    public void credito(float valor){
        saldo += valor;
    }
    
    public void debito(float valor){
        saldo -= valor;
    }
    
    public void salvarOperacoes(String data, String hora, String tipoOperacoes, float valor){
        operacoes.append(data+" - "+hora+";"+tipoOperacoes+";"+valor);
	operacoes.append("\n");
    }
    
    public StringBuilder impressaoOperacoes(){
        return operacoes;
    }
    
    @Override
    public String toString() {
       return numeroDaConta + ";" + saldo; 
    } 
}
