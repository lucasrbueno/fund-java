package com.infnet.exercicios;

//Faça um algoritmo que troque o valor de duas variáveis. Por exemplo, o algoritmo
//lê n1 igual a 3 e n2 a 17, e mostra n1 igual a 17 e n2 a 3.

public class Ex1 {
    public static void main(String[] args) {
    int n1 = 3;
    int n2 = 17;
    int troca;
    
    System.out.println("n1 = " + (n1) + " e n2 = " + (n2));
    
    troca = n1;
    n1 = n2;
    n2 = troca;

    System.out.println("n1 = " + (n1) + " e n2 = " + (n2));
    }
    
}
