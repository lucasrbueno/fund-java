package com.infnet.exercicios;
import java.text.DecimalFormat;
import java.util.Scanner;

//Faça um algoritmo que calcule a área de um círculo, sendo que o comprimento do
//raio é informado pelo usuário. A área do círculo é calculada multiplicando-se Pi ao
//raio ao quadrado.

public class Ex8 {
    public static void main(String[] args) {
        double resolucao;
        
        resolucao = calculo("Qual o raio do círculo? ");
        DecimalFormat df = new DecimalFormat("#.##");
        
        System.out.println("A área do círculo é: " + df.format(resolucao));
    }
    
    public static double calculo(String msg){
        Scanner scan = new Scanner(System.in);
        double valor;
        
        System.out.println(msg);
        valor = Math.PI * Math.pow(scan.nextDouble(), 2);
        return valor;
    }
}
