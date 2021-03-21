package com.infnet.AT;

public class PF extends Contas {
    public String nomeDoCorrentista;
    public String cpf;
    public String chequeEspecial;

    public PF(int numeroDaConta, String nomeDoCorrentista, String cpf, String chequeEspecial, float saldo) {
        super(numeroDaConta, saldo);
        this.nomeDoCorrentista = nomeDoCorrentista;
        this.cpf = cpf;
        this.chequeEspecial = chequeEspecial;
    } 
    
    public String getNomeDoCorrentista() {
        return nomeDoCorrentista;
    }

    public void setNomeDoCorrentista(String nomeDoCorrentista) {
        this.nomeDoCorrentista = nomeDoCorrentista;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(String chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }
    
    @Override
    public String toString() {
        String[] divisoes = nomeDoCorrentista.split(" ");
        StringBuilder nomeCompleto = new StringBuilder();
        
        nomeDoCorrentista = nomeCompleto.append(divisoes[1].toUpperCase())
                    .append(", ")
                    .append(divisoes[0].substring(0, 1).toUpperCase())
                    .append(divisoes[0].substring(1)).toString();
        
        return super.toString() + "\nNome: " + nomeDoCorrentista + "\nCPF: " + cpf + "\nCheque Especial: " + chequeEspecial;
    }
    
    
}
