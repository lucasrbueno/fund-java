package com.infnet.exercicios;

//Faça um algoritmo que calcule e mostre o novo valor de um salário a partir das
//seguintes regras: salários de até R$ 1.000,00 inclusive recebem 30% de aumento,
//salários de até R$ 2.000,00 inclusive recebem 25%, salários de até R$ 3.000,00
//inclusive recebem 20%, salários de até R$ 4.000,00 inclusive recebem 15% e
//salários acima de R$ 4.000,00 recebem apenas 10%.

public class Ex17 {
    public static void main(String[] args) {
        double salario = 5000;
        double aumento;
        
        if (salario <= 1000){
            aumento = 0.3;
            salario += salario * aumento;
            System.out.println("O novo salário é de " + salario);
        } else if (salario <= 2000){
            aumento = 0.25;
            salario += salario * aumento;
            System.out.println("O novo salário é de " + salario);
        } else if (salario <= 3000){
            aumento = 0.20;
            salario += salario * aumento;
            System.out.println("O novo salário é de " + salario);
        } else if (salario <= 4000){
            aumento = 0.15;
            salario += salario * aumento;
            System.out.println("O novo salário é de " + salario);
        } else if (salario >= 4000){
            aumento = 0.10;
            salario += salario * aumento;
            System.out.println("O novo salário é de " + salario + " " + aumento);
        }
    }
}
