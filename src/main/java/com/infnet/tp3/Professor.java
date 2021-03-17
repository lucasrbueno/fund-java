package com.infnet.tp3;

public class Professor extends Pessoa {
    private String materia;

    public Professor(String nome, int idade, String materia) {
        super(nome, idade);
        this.materia = materia;
    }
    
    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return super.toString() + "\nMatéria: " + materia;
    } 
}
