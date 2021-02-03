package com.infnet.oo.loja;

import java.util.Scanner;


public class Produto {
    protected int codigo;
    protected String descricao;
    protected double preço;
    protected double peso;

    public Produto(int codigo, String descricao, double preço, double peso) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preço = preço;
        this.peso = peso;
    }

    public static void main(String[] args) {
        Livro a = new Livro("Tolkien", 2, "Fantasia", 5.99, 3.99);
        Cd c = new Cd("Epica", 5, "Metal", 7.99, 1.50);
        Software s = new Software("Anti-vírus", 7, "Proteção", 50.99, 1);
      
        System.out.println("A entrega do Livro custa: " + (float) entrega(a.peso));
        System.out.println("A entrega do CD custa: " + entrega(c.peso));
        System.out.println("A entrega do Software custa: " + entrega(s.peso));
    }
    
    public static double entrega(double peso){
        double entregar;
   
        entregar = peso * 6.50;
        return entregar;
    }
}
