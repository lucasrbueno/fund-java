package com.infnet.exercicios;
import java.util.Scanner;

//Faça um algoritmo que calcule a gorjeta a ser paga de uma conta de restaurante. A
//gorjeta é calculada como sendo 10% do valor da conta, que deve ser informado pelo
//usuário.

public class Ex4 {
    public static void main(String[] args) {
    int conta;
    double gorjeta = 0.10;
    
    conta = dez("Coloque o valor da conta: ");
    gorjeta = conta * gorjeta;
    System.out.println("Valor final da gorjeta é: " + gorjeta);
    }
    
    public static int dez(String msg){
        Scanner scan = new Scanner(System.in);
        int dinheiro;
        
        System.out.println(msg);
        dinheiro = scan.nextInt();
        return dinheiro;
    }
}
