package com.infnet.exercicios;

//Faça um algoritmo que leia uma sequência de n números inteiros e mostre a soma,
//média, o maior número e o menor número da sequência.

public class Ex24 {
    public static void main(String[] args) {
        int n = 1000;
        int[] numeros = new int[n];
        int soma = 0, menor = 0, maior = 0;
        
        for(int i = 0; i <= numeros.length; i++){
            soma += i;
            if(i > maior){
                maior = i;
            } else if (i < menor) {
                menor = i;
            }
        }
        
        double media = (double) soma / numeros.length;
        System.out.println("A soma dos números da sequência é: " + soma);
        System.out.println("A média dos números da sequência é: " + media);
        System.out.println("O maior dos números da sequência é: " + maior);
        System.out.println("O menor dos números da sequência é: " + menor); 
    } 
}
