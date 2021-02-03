package com.infnet.exercicios;

//Faça um algoritmo que valide uma data, formada por dia, mês e ano. Por exemplo, a;
//data 30/2 é inválida, porém a data 29/2/2012 é válida.      

public class Ex20 {
    public static void main(String[] args) {
        String data = "28/2/2019";
        
        String[] campos = data.split("/");
        int dia = Integer.parseInt(campos[0]);
        int mes = Integer.parseInt(campos[1]);
        int ano = Integer.parseInt(campos[2]);

    switch (mes) {
        case 1: case 3: case 5: case 7: case 8: case 10: case 12:
            if(dia < 1 || dia > 31){
                System.out.println("Data Inválido");
        } else {
                System.out.println("Data Válida");
            }
            break;
        case 4: case 6: case 9: case 11:
            if(dia < 1 || dia > 30){
            System.out.println("Data Inválida");
        } else {
            System.out.println("Data Válida");
            }
            break;
            case 2:
            if (ano % 4 == 0){
                if (dia > 29){
                   System.out.print("Dia Inválido");
                } else {
                   System.out.print("Ano Bissexto e data válida");
                }
            } else
                if (dia > 28){
                    System.out.print("Dia Inválido");
                } else {
                   System.out.print("Data Válida");
                } break;
            default:
                System.out.println("Mês Inválido");
        }             
    }   
}
