package com.infnet.tp1;
import java.util.Scanner;

public class TP1 {
    public static void main(String[] args) {
        int[] alunos = new int[1];
        
        System.out.println("[1] Registrar as notas de um novo aluno.\n[2] Consultar boletim de um aluno.\n[3] Consultar notas da turma.\n[4] Sair.\n");
        escolha();
        
        for(int i = 0; i > alunos.length; i++){
            int nota = notas();
            alunos[i] = nota;
        }
    }

    public static int escolha(){
        Scanner scan = new Scanner(System.in);
        int escolha;
        String aluno;
//        int[] alunos = new int[100];
        String[] nome = new String[100]; 
        int[] nota1 = new int[100];
        int[] nota2 = new int[100];
        
        System.out.println("Qual opção deseja?");
        escolha = scan.nextInt();

        switch (escolha) {
            case 1:
                notas();
                break;
            case 2:
                System.out.println("Insira o nome do aluno: ");
                aluno = scan.nextLine();
                aluno(aluno);
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
    
    public static int notas(){
        Scanner scan = new Scanner(System.in);
        String nome;
        int nota1, nota2;
        
        System.out.println("Insira o nome do aluno: ");
        nome = scan.nextLine();
        System.out.println("Insira a primeira nota: ");
        nota1 = scan.nextInt();
        System.out.println("Insira a segunda nota: ");
        nota2 = scan.nextInt();
        
        return 0;
    }
    
    public static void aluno(String aluno){
        String[] nome = new String[100]; 
        int[] nota1 = new int[100];
        int[] nota2 = new int[100];

        for(int i = 0; i < nome.length; i++){
            if(aluno.equals(nome[i])){
            System.out.println(nome[i] + ": AV1 = " + nota1[i] + "e AV2 = " + nota2[i]);
            } 
            break;
        }        
    }
    
    public static void turmaNotas(String[] nome, int[] nota1, int[]nota2){
        for(int i = 0; i < nome.length; i++){
            System.out.println(nome[i] + ": AV1 = " + nota1[i] + "e AV2 = " + nota2[i]);
        }
    }
}
