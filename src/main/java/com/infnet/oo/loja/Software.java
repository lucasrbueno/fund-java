package com.infnet.oo.loja;


public class Software extends Produto {
    private String categoria;

    public Software(String categoria, int codigo, String descricao, double preço, double peso) {
        super(codigo, descricao, preço, peso);
        this.categoria = categoria;
    }

   


    
}
