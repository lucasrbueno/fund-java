package com.infnet.exercicios;
import java.text.DecimalFormat;
import java.util.Scanner;

//Faça um algoritmo que calcule o volume de uma caixa de água cilíndrica, sendo que
//os comprimentos do raio e a altura são informados pelo usuário. O volume é
//calculado multiplicando-se Pi, ao raio ao quadrado, a altura.

public class Ex10 {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##");
        
        System.out.println("O valor final do volume do cilindro é: " + df.format(calculo()) );
    }
    
    public static double calculo(){
        Scanner scan = new Scanner(System.in);
        double raio;
        double altura;
        
        System.out.println("Qual o valor do raio? ");
        raio = scan.nextDouble();
        System.out.println("Qual o valor da altura? ");
        altura = scan.nextDouble();
        
        double calculo = Math.PI * Math.pow(raio, 2) * altura;
        
        return calculo;
    }
}
