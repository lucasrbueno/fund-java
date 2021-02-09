package com.infnet.exercicios;

//Os endereços IP versão 4 são divididos em cinco classes: A, B, C, D e E. Os
//endereços no intervalo de 0 à 127 são classe A, de 128 à 191 são classe B, de 192 à
//223 são classe C, de 224 à 239 são classe D e a partir de 240 são classe E. Faça um
//algoritmo que leia o primeiro octeto, no formato decimal, de um endereço IP e
//informe a sua classe.

public class Ex18 {
    public static void main(String[] args) {
        String ip = "-1.168.32.1";
        
        String[] campos = ip.split("\\.");
        int pri = Integer.parseInt(campos[0]);

        if(pri >= 0 && pri <= 127){
            System.out.println("O primeiro octeto " + pri + " é de Classe A");
        } else if(pri >= 128 && pri <= 191){
            System.out.println("O primeiro octeto " + pri + " é de Classe B");
        } else if(pri >= 192 && pri <= 223){
            System.out.println("O primeiro octeto " + pri + " é de Classe C");
        } else if(pri >= 224 && pri <= 239){
            System.out.println("O primeiro octeto " + pri + " é de Classe D");
        } else if(pri >= 240){
            System.out.println("O primeiro octeto " + pri + " é de Classe E");
        } else {
            System.out.println("O primeiro octeto " + pri + " é inválido");
        }
    }
}
