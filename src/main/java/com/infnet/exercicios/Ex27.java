package com.infnet.exercicios;

//Faça um algoritmo para mostrar a tabuada de 1 a 10.

public class Ex27 {
    public static void main(String[] args) {
        int dez = 10;
        
        for(int i = 0; i <= 10; i++){
            int tabuada = dez * i;
            System.out.println(i + " x " + dez + " = " + tabuada);
        }
    }
}
