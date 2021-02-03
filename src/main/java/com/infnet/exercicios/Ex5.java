package com.infnet.exercicios;
import java.text.DecimalFormat;
import java.util.Scanner;

//Faça um algoritmo que calcule o novo valor de um salário a partir de um valor
//percentual de reajuste. O valor atual do salário e o valor percentual do reajuste
//devem ser informados pelo usuário como, por exemplo, 7,3%.

public class Ex5 {
    public static void main(String[] args) {
        double liquido;
        
        liquido = reajuste();
        
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Valor final do salário é de: " + df.format(liquido));   
    }
  
    public static double reajuste(){
        Scanner scan = new Scanner(System.in);
        double valor;
        String porc;
        
        System.out.println("Informe o valor do salario:");
        valor = scan.nextDouble();
        System.out.println("Qual o valor do reajuste?");
        porc = scan.next();
        
        double calculo = Double.parseDouble(porc.replace("%", "")) / 100;
        double bruto = valor + (valor * calculo);
        
        return bruto;
    }
}
