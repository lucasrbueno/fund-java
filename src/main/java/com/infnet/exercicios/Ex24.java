package com.infnet.exercicios;

//Faça um algoritmo que leia uma sequência de n números inteiros e mostre a soma,
//média, o maior número e o menor número da sequência.

public class Ex24 {
    public static void main(String[] args) {
        final int N = 850;
        int[] numeros = new int[N];
        int soma = 0, menor = numeros[0], maior = 0;
        
        for(int i = 0; i < numeros.length; i++){
            numeros[i] = i + 1;
            soma += numeros[i];
            if(numeros[i] > maior){
                maior = numeros[i];
            } else if (numeros[i] < menor) {
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
