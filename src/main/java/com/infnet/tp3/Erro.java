package com.infnet.tp3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Erro {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int op1, op2;
        double result;
        boolean divOk = false;
        
        do {
            try {
                System.out.print("Entre com um número: ");
                op1 = entrada.nextInt();
                System.out.print("Entre com um número: ");
                op2 = entrada.nextInt();
                result = op1 / op2;
                System.out.println("Resultado = " + result);
                divOk = true;
            }
            catch (InputMismatchException ex) {
                System.out.println("Erro: entrada inválida");
                entrada.next();
            }
            catch (ArithmeticException ex) {
                System.out.println("Erro: divisão por zero");
            }
        } while (!divOk);
    }    
    
    public static int leInteiro(String msg) {
        Scanner entrada = new Scanner(System.in);
        int num = 0;
        boolean ok = false;
        
        do {
            try {
                System.out.print(msg);
                num = entrada.nextInt();
                ok = true;
            }
            catch (Exception ex) {
                System.out.println("Erro: entrada inválida");
                entrada.next();
            }
        } while (!ok);
        return num;
    }
}