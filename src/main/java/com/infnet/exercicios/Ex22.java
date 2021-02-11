package com.infnet.exercicios;

//Faça um algoritmo que calcule a soma dos números de 1 a 100.

public class Ex22 {
    public static void main(String[] args) {
        int soma = 0;
        
        for(int i = 0; i <= 100; i++){
            soma += i;
        }
        
        System.out.println("A soma dos números de 1 até 100 é: " + soma);
    }
}
