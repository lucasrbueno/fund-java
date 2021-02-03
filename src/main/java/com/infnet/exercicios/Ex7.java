package com.infnet.exercicios;
import java.util.Scanner;

//Faça um algoritmo que calcule a área de um retângulo, sendo que os comprimentos;
//da altura e da base são informados pelo usuário. A área do retângulo é calculada
//multiplicando-se a altura pela base.

public class Ex7 {
    public static void main(String[] args) {
        int altura, lado, area;
        
        altura = calculo("Coloque o valor da altura: ");
        lado = calculo("Coloque o valor da lado: ");
        area = altura * lado;
        System.out.println("A área do retângulo é: " + area);
    }
    
    public static int calculo(String msg){
        Scanner scan = new Scanner(System.in);
        int valor;
        
        System.out.println(msg);
        valor = scan.nextInt();
        return valor;
    }
}
