package com.infnet.tp3;

public class Aluno extends Pessoa {
    private String matricula;

    public Aluno(String nome, int idade, String matricula) {
        super(nome, idade);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        matricula = matricula.substring(0, 1).toUpperCase() + matricula.substring(1);
        
        return super.toString() + "\nMatricula: " + matricula;
    } 
}
