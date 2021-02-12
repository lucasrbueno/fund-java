package com.infnet.exercicios;

//Faça um algoritmo que leia uma sequência de números inteiros terminado por zero e
//mostre a soma, média, o maior número e o menor número da sequência.

public class Ex25 {
    public static void main(String[] args) {
        int[] numeros = {50, 40, 60};
        int soma = 0, maior = 0, menor = numeros[0];
        
        
        for(int i = 0; i < numeros.length; i++){
            soma += numeros[i];
            
            if(numeros[i] > maior){
                maior = numeros[i];
            } else if (numeros[i] < menor){
                menor = numeros[i];
            }
        }
        
        double media = (double) soma / numeros.length;
        
        System.out.println("A soma dos números da sequência é: " + soma);
        System.out.println("A média dos números da sequência é: " + media);
        System.out.println("O maior dos números da sequência é: " + maior);
        System.out.println("O menor dos números da sequência é: " + menor); 
    }
}
