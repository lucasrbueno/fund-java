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
        materia = materia.substring(0, 1).toUpperCase() + materia.substring(1);
        
        return super.toString() + "\nMatéria: " + materia;
    }
    
    
}
