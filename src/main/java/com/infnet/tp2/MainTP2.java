package com.infnet.tp2;

import java.util.Scanner;

public class MainTP2 {
    final static int QUANT = 100;
    
    public static void main(String[] args) {
        escolha();   
    }
    
    public static void escolha(){
        Scanner scan = new Scanner(System.in);
        int cont = 0;
        int escolha;
        Pessoa[] pessoas = new Pessoa[QUANT];
        
        System.out.println("--------------------------------------------");
        System.out.println("[1] Cadastrar professor.\n[2] Cadastrar aluno.\n[3] Consultar situação de um docente/discente.\n[4] Sair.\n");
        System.out.println("Qual opção deseja?");
        escolha = scan.nextInt();

        while(escolha != 4){
           switch (escolha) {
            case 1:
                cont = cadastrarProfessor(pessoas, cont);
                break;
            case 2:
                cont = cadastrarAluno(pessoas, cont);
                break;
            case 3:
                consultarSituacao(pessoas, cont);
                break;
            default:
                System.out.println("Opção inválida, escolha outra opção.");
                break;    
            }
        System.out.println("--------------------------------------------");
        System.out.println("[1] Cadastrar professor.\n[2] Cadastrar aluno.\n[3] Consultar situação de um docente/discente.\n[4] Sair.\n");
        System.out.println("Qual opção deseja?");
        escolha = scan.nextInt();
        }
    }
    
    public static int cadastrarProfessor(Pessoa[] pessoas, int cont){
        Scanner scan = new Scanner(System.in);
        String nome, materia;
        int idade;
       
        System.out.println("Insira o nome do professor: ");
        nome = scan.nextLine();
        System.out.println("Insira a idade do professor: ");
        idade = scan.nextInt();
        System.out.println("Insira a materia do professor: ");
        materia = scan.next();
        
        Professor professor = new Professor(nome, idade, materia);
        pessoas[cont] = professor;
        cont++;
        
        return cont;
    }
    
    public static int cadastrarAluno(Pessoa[] pessoas, int cont){
        Scanner scan = new Scanner(System.in);
        String nome, matricula;
        int idade;
       
        System.out.println("Insira o nome do aluno: ");
        nome = scan.nextLine();
        System.out.println("Insira a idade do aluno: ");
        idade = scan.nextInt();
        System.out.println("Insira a matricula do aluno: ");
        matricula = scan.next();
        
        Pessoa aluno = new Aluno(nome, idade, matricula);
        pessoas[cont] = aluno;
        cont++;
        
        return cont;
    }
    
    public static void consultarSituacao(Pessoa[] pessoas, int cont){
        
        for(int i = 0; i < cont; i++){
            if(pessoas[i] instanceof Aluno){
            System.out.println("--------------------------------------------");
            System.out.println("Aluno:\n" + pessoas[i]);
            } else {
                System.out.println("Professor:\n" + pessoas[i]);
            }
        }
    }
}
