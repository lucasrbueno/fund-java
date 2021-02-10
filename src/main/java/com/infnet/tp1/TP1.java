package com.infnet.tp1;
import java.util.Scanner;

public class TP1 {
    public static void main(String[] args) {
        escolha(); 
    }

    public static void escolha(){
        Scanner scan = new Scanner(System.in);
        int escolha;
        String aluno;
        String[] nomes = new String[100]; 
        int[] nota1 = new int[100];
        int[] nota2 = new int[100];
        
        int j = 1;
        
        while(j == 1){
           System.out.println("--------------------------------------------");
           System.out.println("[1] Registrar as notas de um novo aluno.\n[2] Consultar boletim de um aluno.\n[3] Consultar notas da turma.\n[4] Sair.\n");
           System.out.println("Qual opção deseja?");
           escolha = scan.nextInt();
           
           switch (escolha) {
            case 1:
                notas(nomes, nota1, nota2);
                break;
            case 2:
                System.out.println("Insira o nome do aluno: ");
                aluno = scan.next();
                aluno(aluno, nomes, nota1, nota2);
                break;
            case 3:
                turmaNotas(nomes, nota1, nota2);
                break;
            case 4:
                j = 2;
                System.out.println("Saída com sucesso");
                break;
            default:
                System.out.println("Opção inválida, escolha outra opção.");
                break;    
            }
        }
    }
    
    public static void notas(String[] nome, int[] nota1, int[]nota2){
        Scanner scan = new Scanner(System.in);

        for(int i = 0; i < nome.length; i++){
            System.out.println("Insira o nome do aluno: ");
            nome[i] = scan.next();
            System.out.println("Insira a primeira nota: ");
            nota1[i] = scan.nextInt();
            System.out.println("Insira a segunda nota: ");
            nota2[i] = scan.nextInt();
            System.out.println("O registro foi feito na posição: " + i);
            System.out.println("Próxima posição a ser ocupada: " + (i + 1));
        }     
    }
    
    public static void aluno(String aluno, String[] nome, int[] nota1, int[]nota2){
        double media;
        String situacao = "";
       
        for(int i = 0; i < nome.length; i++){
            if(aluno.equals(nome[i])){ 
            media = (nota1[i] + nota2[i]) / 2;
            if(media < 4){
               situacao = "Reprovado";
            } else if(media >= 4 && media < 7){
                situacao = "Prova final";
            } else if(media >= 7){
                situacao = "Aprovado";
            }
            
            System.out.println("Aluno: " + nome[i]);
            System.out.println("AV1: " + nota1[i]);
            System.out.println("AV2: " + nota2[i]);
            System.out.println("Média final: " + media);
            System.out.println("Situação: " + situacao);
            } else {
                System.out.println("Aluno inexistente");
                break;
            }
        }       
    }

    public static void turmaNotas(String[] nome, int[] nota1, int[]nota2){        
        double media;
        String situacao = ""; 
        
        for(int i = 0; i < nome.length; i++){      
            media = (nota1[i] + nota2[i]) / 2;
            if(media < 4){
               situacao = "Reprovado";
            } else if(media >= 4 && media < 7){
                situacao = "Prova final";
            } else if(media >= 7){
                situacao = "Aprovado";
            }
             
            System.out.println("--------------------------------------------");
            System.out.println("Aluno: " + nome[i]);
            System.out.println("AV1: " + nota1[i]);
            System.out.println("AV2: " + nota2[i]);
            System.out.println("Média final: " + media);
            System.out.println("Situação: " + situacao);
        }
    }  
}
