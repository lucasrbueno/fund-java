package com.infnet.tp3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainTP3 {
    final static int QUANT = 100;
    
    public static void main(String[] args) {
        escolha();   
    }
    
    public static void escolha(){
        int cont = 0;
        int escolha;
        Pessoa[] pessoas = new Pessoa[QUANT];

        escolha = menu();

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
           
           escolha = menu();
        }
    }
    
    public static int menu(){
        Scanner scan = new Scanner(System.in);
        int escolha = 0;
        boolean bool = false;
        
        do {
            try {
                StringBuilder menu = new StringBuilder();
                menu.append("--------------------------------------------")
                        .append("\n[1] Cadastrar professor.")
                        .append("\n[2] Cadastrar aluno.")
                        .append("\n[3] Consultar situação de um docente/discente.")
                        .append("\n[4] Sair.")
                        .append("\nQual opção deseja?");        
                System.out.println(menu);
                escolha = scan.nextInt();
                bool = true;
            }
            catch (InputMismatchException ex) {
                System.out.println("Se atenha aos números, por favor");
            } finally {
                scan.nextLine();
            }
        } while (!bool);

        return escolha;
    }
    
    public static int cadastrarProfessor(Pessoa[] pessoas, int cont){
        Scanner scan = new Scanner(System.in);
        String nome, materia;
        int idade;
       
        nome = insereNome();
        System.out.println("Insira a idade do professor: ");
        idade = scan.nextInt();
        System.out.println("Insira a materia do professor: ");
        materia = insereSituacao(scan.next());
        
        Professor professor = new Professor(nome, idade, materia);
        pessoas[cont] = professor;
        cont++;
        
        return cont;
    }
    
    public static int cadastrarAluno(Pessoa[] pessoas, int cont){
        Scanner scan = new Scanner(System.in);
        String nome, matricula;
        int idade;
       
        nome = insereNome();
        System.out.println("Insira a idade do aluno: ");
        idade = scan.nextInt();
        System.out.println("Insira a matricula do aluno: ");
        matricula = insereSituacao(scan.next());
        
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
    
    public static String insereNome(){
        Scanner scan = new Scanner(System.in);
        String nome, divisoes[];
        
        do {
            System.out.println("Insira o nome e sobrenome: ");
            nome = scan.nextLine();
            
            divisoes = nome.split(" ");

        } while(divisoes.length != 2);

        return nome;
    }
    
    public static String insereSituacao(String situacao){
        situacao = situacao.substring(0, 1).toUpperCase() + situacao.substring(1);
        
        return situacao;
    }
}
