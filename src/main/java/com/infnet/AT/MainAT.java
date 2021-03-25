package com.infnet.AT;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainAT {
    private static Scanner scan;
    private static final ArrayList<Contas> contas = new ArrayList<>();
    
    public static void main(String[] args) {
        escolhaMenuOriginal();       
    }
    
    public static void escolhaMenuOriginal(){
        scan = new Scanner(System.in);
        int escolha;

        escolha = menuOriginal();

        while(escolha != 5){
           switch (escolha) {
            case 1:
                incluirConta(contas);
                break;
            case 2:
                alterarSaldo(contas);
                break;
            case 3:
                removerConta();
                break; 
            case 4:
                escolhaMenuRelatorio();
                break;
            default:
                System.out.println("Opção inválida, escolha outra opção.");
                break;
            }

           escolha = menuOriginal();
        }
    }
    
    public static int menuOriginal(){
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
    
    private static void incluirConta(ArrayList<Contas> contas){

        System.out.println("Escolha seu tipo de conta\n[1] Pessoa Física\n[2] Pessoa Jurídica");
        int conta = scan.nextInt(); 
        boolean existe = pesquisaConta(contas, conta);
        
        if(conta == 1){
            if(existe){
            System.out.println("Não é permitido criar mais contas");
            } else {
                pf(conta);
            } 
        } else if(conta == 2){
            if(existe){
            System.out.println("Não é permitido criar mais contas");
            } else {
                pj(conta);
            } 
        } 
    }
    
    public static void listagemDeContas(ArrayList<Contas> contas){
        if(contas.size() > 0) {
            System.out.println("Listagem geral de Contas:");
            for(Contas c : contas) {
                if(c instanceof PF){
                    System.out.println("--------------------------------------------");
                    System.out.println("PF:\n" + c);
                } else {
                    System.out.println("--------------------------------------------");
                    System.out.println("PJ:\n" + c);
                }
            }
        } else {
            System.out.println("Nenhuma conta cadastrada!");
        }
    }
    
    public static String insereNome(){
        scan = new Scanner(System.in);
        String nome, divisoes[];
        
        do {
            nome = scan.nextLine();
            
            divisoes = nome.split(" ");

        } while(divisoes.length != 2);

        return nome;
    }
    
    public static void removerConta(){
         
        if(contas.size() > 0) {
            System.out.println("Qual tipo conta você quer apagar? ");
            int conta = scan.nextInt();
            
            for(Contas c : contas) {
                if(c instanceof PF){
                   contas.remove(c);
                } else if(c instanceof PJ){
                    contas.remove(c);
                }  
            }
        } else {
            System.out.println("Nenhuma conta cadastrada para ser removida.");
        }
    }
    
    public static int menuRelatório(){
        int escolha = 0;
        boolean bool = false;
        
        do {
            try {
                StringBuilder menu = new StringBuilder();
                menu.append("--------------------------------------------")
                        .append("\n[1] Listar Clientes com saldo negativo")
                        .append("\n[2] Listar Clientes com saldo acima de 50 reais")
                        .append("\n[3] Listar todas as contas")
                        .append("\n[4] Listar operações feitas nas contas")
                        .append("\n[5] Voltar")
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
    
    public static void escolhaMenuRelatorio(){
        scan = new Scanner(System.in);
        int escolha;

        escolha = menuRelatório();

        while(escolha != 5){
           switch (escolha) {
            case 1:

                break;
            case 2:

                break;
            case 3:
                listagemDeContas(contas);
                break; 
            case 4:
                
                break;
            default:
                System.out.println("Opção inválida, escolha outra opção.");
                break;
            }

           escolha = menuRelatório();
        }
    }
    
    public static void alterarSaldo(ArrayList<Contas> contas){
        
        int escolha;

        if(contas.size() > 0) {
            for(Contas c : contas) {
                if(c instanceof PF){
                    escolha = scan.nextInt();
                    
                    if(escolha == 1){
                        System.out.println("Quanto de saldo quer creditar na conta de Pessoa Física? ");
                        float saldo = scan.nextFloat();
                        c.credito(saldo);
                    } else if(escolha == 2){
//                        c.debito();
                        System.out.println("sme ebitro");
                    }
                } else if(c instanceof PJ){
                    System.out.println("Quanto de saldo quer creditar na conta de Pessoa Jurídica?? ");
                    float saldo = scan.nextFloat();
                    c.credito(saldo);
                }  
            }
        } else {
            System.out.println("Nenhuma conta cadastrada para ter alteração de saldo.");
        }
    }
    
    public static void pf(int conta){
        String nomeCorrentista, cpf, cnpj, nomeEmpresa;
        int contaNumero;
        float saldo, chequeEspecial;
        
        contaNumero = conta;
        System.out.println("Insira nome do correntista");
        nomeCorrentista = insereNome();
        System.out.println("CPF do correntista: ");
        cpf = scan.next();
        System.out.println("Cheque Especial do correntista: ");
        chequeEspecial = scan.nextFloat();
        System.out.println("Saldo do correntista: ");
        saldo = scan.nextFloat();

        PF pf = new PF(contaNumero, nomeCorrentista, cpf, chequeEspecial, saldo);

        contas.add(pf);
    }
    
    public static void pj(int conta){
        String cnpj, nomeEmpresa;
        int contaNumero;
        float saldo;
        
        contaNumero = conta;
        System.out.println("Nome da Empresa: ");
        nomeEmpresa = insereNome();
        System.out.println("CNPJ da Empresa: ");
        cnpj = scan.next();
        System.out.println("Saldo da conta: ");
        saldo = scan.nextFloat();

        PJ pj = new PJ(contaNumero, nomeEmpresa, cnpj, saldo);

        contas.add(pj);
    }
    
    public static boolean pesquisaConta(ArrayList<Contas> contas, int opcao){
        boolean existe = false;
        
        for(Contas c : contas) {
                if(c.getNumeroDaConta() == opcao){
                    existe = true;
                    break;
                } 
            }
       return existe; 
    }
}
