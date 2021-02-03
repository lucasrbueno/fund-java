package com.infnet.exercicios;
import java.util.Scanner;

//Faça um algoritmo para calcular a média de duas notas digitadas pelo usuário, sendo
//que a segunda nota tem peso dois.

public class Ex3 {
    public static void main(String[] args) {
    int n1;
    int n2;
    double media;
       
    n1 = oInt("Nota 1 = ");
    n2 = oInt("Nota 2 = ");
    
    media = (double) (n1 + n2) / 2;
    
    System.out.println("A Média é: " + media);
}
    public static int oInt(String msg){
        Scanner scan = new Scanner(System.in);
        int nota;
        
        System.out.println(msg);
        nota = scan.nextInt();
        return nota;
    }
}
