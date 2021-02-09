package com.infnet.tp1;
import java.util.Scanner;

public class TP1 {
    public static void main(String[] args) {
        System.out.println("[1] Registrar as notas de um novo aluno.\n[2] Consultar boletim de um aluno.\n[3] Consultar notas da turma.\n[4] Sair.\n");
        escolha(); 
    }

    public static int escolha(){
        Scanner scan = new Scanner(System.in);
        int escolha;
        String aluno;
        String[] nome = new String[1]; 
        int[] nota1 = new int[1];
        int[] nota2 = new int[1];
        
        System.out.println("Qual opção deseja?");
        escolha = scan.nextInt();

        switch (escolha) {
            case 1:
                notas(nome, nota1, nota2);
                break;
            case 2:
                System.out.println("Insira o nome do aluno: ");
                aluno = scan.next();
                aluno(aluno, nome, nota1, nota2);
                break;
            case 3:
                turmaNotas(nome, nota1, nota2);
                break;
            case 4:
                System.out.println("Saída com sucesso");
                break;
            default:
              System.out.println("Opção inválida.");
                break;          
        }
        return escolha;
    }
    
    public static void notas(String[] nome, int[] nota1, int[]nota2){
        Scanner scan = new Scanner(System.in);

        for(int i = 0; i < nome.length; i++){
            System.out.println("Insira o nome do aluno: ");
            nome[i] = scan.nextLine();
            System.out.println(nome[i]);
        }
        
        for(int i = 0; i < nota1.length; i++){
            System.out.println("Insira a primeira nota: ");
            nota1[i] = scan.nextInt();
            System.out.println(nota1[i]);
        }
        
        for(int i = 0; i < nota2.length; i++){
            System.out.println("Insira a segunda nota: ");
            nota2[i] = scan.nextInt();
            System.out.println(nota2[i]);
        }
    }
    
    public static void aluno(String aluno, String[] nome, int[] nota1, int[]nota2){
        double media;
        String situacao = "";
       
        for(int i = 0; i < nome.length; i++){
            if(aluno.contains(nome[i])){ 
            media = nota1[i] + nota2[i] / 2;
            if(media < 4){
               situacao = "Reprovado";
            } else if(media >= 4 && media < 7){
                situacao = "Prova final";
            } else if(media >= 7){
                situacao = "Aprovado";
            }
            
            System.out.println(nome[i]);
            System.out.println("AV1: " + nota1[i]);
            System.out.println("AV2: " + nota2[i]);
            System.out.println(" Média final: " + media);
            System.out.println("Situação: " + situacao);
            } 
        }        
    }

    public static void turmaNotas(String[] nome, int[] nota1, int[]nota2){        
        double media;
        String situacao = "";
        
        for(int i = 0; i < nome.length; i++){
            
            media = nota1[i] + nota2[i] / 2;
            if(media < 4){
               situacao = "Reprovado";
            } else if(media >= 4 && media < 7){
                situacao = "Prova final";
            } else if(media >= 7){
                situacao = "Aprovado";
            }
        
            System.out.println(nome[i]);
            System.out.println("AV1: " + nota1[i]);
            System.out.println("AV2: " + nota2[i]);
            System.out.println(" Média final: " + media);
            System.out.println("Situação: " + situacao);
        }
    }  
}
