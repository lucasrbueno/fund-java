package com.infnet.oo.loja;


public class Livro extends Produto {
    public String autor;

    public Livro(String autor, int codigo, String descricao, double preço, double peso) {
        super(codigo, descricao, preço, peso);
        this.autor = autor;
    }
  
}
