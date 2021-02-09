package com.infnet.exercicios;

//Faça um algoritmo que leia um caractere e informe se o mesmo é uma vogal ou não.

public class Ex16 {
    public static void main(String[] args) {
        char l = 'A';
        
        if(l == 'a' || l == 'A' || l == 'e' || l =='E' ||
        l == 'i' || l =='I' || l =='o' || l =='O' ||
        l == 'u' || l == 'U'){
            System.out.println("A letra " + l + " é uma vogal.");
        } else {
            System.out.println("A letra " + l + " não é uma vogal.");
        }
    }
}
