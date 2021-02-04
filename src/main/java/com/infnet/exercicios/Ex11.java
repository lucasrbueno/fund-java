package com.infnet.exercicios;

//Faça um algoritmo que leia um número e mostre se o mesmo é positivo, negativo ou;
//zero.

public class Ex11 {
    public static void main(String[] args) {
        int n = 10;
        if(n > 0){
            System.out.print("Número positivo");
        }  else if(n < 0){
            System.out.print("Número negativo");
        } else{
            System.out.print("Número zero");
        }
    }

}
