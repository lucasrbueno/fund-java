package com.infnet.exercicios;
import java.text.DecimalFormat;
import java.util.Scanner;

//Faça um algoritmo que calcule a área de uma esfera, sendo que o comprimento do
//raio é informado pelo usuário. A área da esfera é calculada multiplicando-se 4 vezes
//Pi ao raio ao quadrado.

public class Ex9 {
    public static void main(String[] args) {
        double resolucao;
        
        DecimalFormat df = new DecimalFormat("#.##");
        resolucao = calculo("Qual o valor do raio da esfera? ");
        System.out.println("O valor final é :" + df.format(resolucao));
    }
    
    public static double calculo(String msg){
        Scanner scan = new Scanner(System.in);
        double valor;
        
        System.out.println(msg);
        valor = 4 * Math.PI * Math.pow(scan.nextDouble(),2);

        return valor;
    }
}
