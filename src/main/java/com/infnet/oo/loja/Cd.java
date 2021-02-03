package com.infnet.oo.loja;

public class Cd extends Produto {
    private String banda;

    public Cd(String banda, int codigo, String descricao, double preço, double peso) {
        super(codigo, descricao, preço, peso);
        this.banda = banda;
    }

   
  
    
}
