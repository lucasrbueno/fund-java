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
        String[] divisoes; 
        StringBuilder nomeCompleto = new StringBuilder();
        boolean bool = false;
                
         do {
            try {
                divisoes = nome.split(" ");
                String part1 = divisoes[0];
                String part2 = divisoes[1];
                nome = nomeCompleto.append(part2.toUpperCase())
                    .append(", ")
                    .append(part1.substring(0, 1).toUpperCase())
                    .append(part1.substring(1)).toString();
                bool = true;
            }
            catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("Escreva nome e sobrenome, por favor");
                bool = true;
            }
        } while (!bool);

        return "Nome: " + nome + "\nIdade: " + idade;
    }
}
