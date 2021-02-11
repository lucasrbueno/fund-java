package com.infnet.exercicios;

//Faça um algoritmo que leia uma sequência de caracteres terminada por um ponto e
//mostre o numero de vogais da frase.

public class Ex21 {
    public static void main(String[] args) {
        String frase = "O Tempo perguntou ao tempo quanto tempo o tempo tem, o Tempo respondeu ao tempo que o tempo tem tanto tempo quanto tempo, tempo tem.";
        int contagem = 0;
        
        for(int i = 0; i < frase.length(); i++){
            char carac = frase.charAt(i);
            if(carac == 'a' || carac == 'A' || carac == 'e' || carac =='E' ||
            carac == 'i' || carac =='I' || carac =='o' || carac =='O' ||
            carac == 'u' || carac == 'U'){
                contagem++;
            } 
        }
        
        System.out.println("A quantidade de vogais na frase é: " + contagem); 
    }
}
