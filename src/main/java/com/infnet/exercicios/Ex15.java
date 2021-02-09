package com.infnet.exercicios;
import java.util.Arrays;

//Faça um algoritmo que leia três números e mostre-os em ordem crescente.

public class Ex15 {
    public static void main(String[] args) {
        int n1 = 15;
        int n2 = 20;
        int n3 = 13;
        int[] vet = {n1, n2, n3};
        
        Arrays.sort(vet);

        for(int i : vet){
            System.out.println(i);
        }
    }
}
