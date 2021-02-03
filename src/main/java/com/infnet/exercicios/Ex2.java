
package com.infnet.exercicios;
import java.util.Scanner;

//Faça um algoritmo para calcular a média de duas notas digitadas pelo usuário.

public class Ex2 {
    public static void main(String[] args) {
        int n1;
        int n2;
        double media;
        
        n1 = oInt("Digite sua nota 1");
        n2 = oInt("Digite sua nota 2");
        
        media = (double) (n1 + n2) / 2;
        
        System.out.println("Média = " + media);
                
    }        
    
    public static int oInt(String msg){
        Scanner scan = new Scanner(System.in);
        int nota;
        
        System.out.println(msg);
        nota = scan.nextInt();
        return nota;
    }

}

