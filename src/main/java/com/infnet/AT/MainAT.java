package com.infnet.AT;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainAT {
    final static int QUANT = 100;
    
    public static void main(String[] args) {
        escolha();
    }
    
    public static void escolha(){
        int cont = 0;
        int escolha;
        Contas[] contas = new Contas[QUANT];

        escolha = menu();

        while(escolha != 4){
           switch (escolha) {
            case 1:
//                cont = cadastrarProfessor(pessoas, cont);
                break;
            case 2:
//                cont = cadastrarAluno(pessoas, cont);
                break;
            case 3:
//                consultarSituacao(pessoas, cont);
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
                        .append("\n[1] Inclusão de conta")
                        .append("\n[2] Cadastrar aluno.")
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
}
