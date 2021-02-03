package com.infnet.exercicios;
import java.util.Scanner;

//Faça um algoritmo que calcule a área de um quadrado, sendo que o comprimento do
//lado é informado pelo usuário. A área do quadrado é calculada elevando-se o lado
//ao quadrado.

public class Ex6 {
    public static void main(String[] args) {
        double area;
        
        area = lado("Insira o lado do quadrado: ");
        
        System.out.println("Área do quadrado é: " + area);
    }
    
    public static int lado(String msg){
        Scanner scan = new Scanner(System.in);
        int lado;
        
        System.out.println(msg);
        lado = (int) Math.pow(scan.nextInt(), 2);
        return lado;
    }
}
