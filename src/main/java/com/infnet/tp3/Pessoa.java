package com.infnet.tp3;

public abstract class Pessoa {
    private String nome;
    private int idade;
    
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    } 

    @Override
    public String toString() {
        String[] divisoes = nome.split(" ");
        StringBuilder nomeCompleto = new StringBuilder();
        
        nome = nomeCompleto.append(divisoes[1].toUpperCase())
                    .append(", ")
                    .append(divisoes[0].substring(0, 1).toUpperCase())
                    .append(divisoes[0].substring(1)).toString();
        
        return "Nome: " + nome + "\nIdade: " + idade;
    }
}
