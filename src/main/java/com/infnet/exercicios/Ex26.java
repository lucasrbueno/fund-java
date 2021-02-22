package com.infnet.exercicios;

//Faça um algoritmo que leia um intervalo inferior e superior, e mostre os números
//primos existentes no intervalo. Por exemplo, o algoritmo recebe 5 e 10, e mostra
//como saída 5 e 7. Além disso, o algoritmo deve mostrar a quantidade de números
//primos encontrados no intervalo.

public class Ex26 {
    public static void main(String[] args) {
        int inferior = 0, superior = 100, contar;
        
        for(int i = inferior; i <= superior; i++){
            contar = 0;
            for(int j = 1; j <= i; j++){
                if(i % j == 0){
                    contar = ++contar;
                }
            }
            if(contar == 2){
                System.out.println(i);
            }
        }
    }
}
