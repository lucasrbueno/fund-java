package com.infnet.AT;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainAT {
    private static Scanner scan;
    private static ArrayList<Contas> contas;
    
    public static void main(String[] args) {
        escolha();
    }
    
    public static void escolha(){
        scan = new Scanner(System.in);
        int conta = 0;
        int escolha;

        escolha = menu();

        while(escolha != 5){
           switch (escolha) {
            case 1:
                incluirConta();
//                cont = cadastrarProfessor(pessoas, cont);
                break;
            case 2:
//                cont = cadastrarAluno(pessoas, cont);
                break;
            case 3:
                relatoriosGerenciais();
//                consultarSituacao(pessoas, cont);
                break; 
            case 4:
                
                break;
            default:
                System.out.println("Opção inválida, escolha outra opção.");
                break;
            }       
           
           escolha = menu();
        }
    }
    
    public static int menu(){
        int escolha = 0;
        boolean bool = false;
        
        do {
            try {
                StringBuilder menu = new StringBuilder();
                menu.append("--------------------------------------------")
                        .append("\n[1] Inclusão de conta")
                        .append("\n[2] Alterar saldo")
                        .append("\n[3] Exclusão de conta")
                        .append("\n[4] Relatórios Gerenciais")
                        .append("\n[5] Sair.")
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
    
    private static void incluirConta(){
        System.out.println("Escolha seu tipo de conta");
        int conta = scan.nextInt();
        
        String nomeCorrentista, cpf, chequeEspecial, nomeEmpresa;
        int contaNumero;
        Float saldo;
        
        if(conta == 1){
            contaNumero = conta;
            nomeCorrentista = insereNome();
            System.out.println("CPF do correntista ");
            cpf = scan.next();
            System.out.println("Correntista está em Cheque Especial?");
            chequeEspecial = scan.next();
            System.out.println("Saldo do correntista: ");
            saldo = scan.nextFloat();
            
            PF pf = new PF(contaNumero, nomeCorrentista, cpf, chequeEspecial, saldo);
            
            contas.add(pf);
            
        } else {
            contaNumero = conta;
            nomeEmpresa = insereNome();
            cpf = scan.next();
            saldo = scan.nextFloat();
            
            PJ pj = new PJ(contaNumero, nomeEmpresa, cpf, saldo);
            
            contas.add(pj);
        }
    }
    
    public static void relatoriosGerenciais(){
        if(contas.size() > 0) {
            System.out.println("Listagem geral de Contas:");
            for(Contas c : contas) {

                String tipo = c instanceof PF ? "1" : "2";

                System.out.println(tipo + " - " + c);
            }
        } else {
            System.out.println("Nenhuma conta cadastrado!");
        }
    }
    
    public static String insereNome(){
        scan = new Scanner(System.in);
        String nome, divisoes[];
        
        do {
            System.out.println("Insira nome de correntista ou de Empresa: ");
            nome = scan.nextLine();
            
            divisoes = nome.split(" ");

        } while(divisoes.length != 2);

        return nome;
    }
    
//    public static void existeConta(){
//        
//    }
}
