package com.infnet.exercicios;

//Faça um algoritmo que leia três números e mostre o maior número.

public class Ex14 {
    public static void main(String[] args) {
        int n1, n2, n3;
        
        n1 = 15;
        n2 = 14;
        n3 = 28;
        
        if(n1 > n2 && n1 > n3){
            System.out.println("O maior número é " + n1);
        } else if(n2 > n3){
            System.out.println("O maior número é " + n2);
        } else {
            System.out.println("O maior número é " + n3);
        }
    } 
}
