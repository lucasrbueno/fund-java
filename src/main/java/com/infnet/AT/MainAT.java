package com.infnet.AT;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainAT {
    private static Scanner scan;
    private static final ArrayList<Contas> contas = new ArrayList<>();
    private static final ArrayList<Contas> arquivo = new ArrayList<>();
    
    public static void main(String[] args) {
        
        escolhaMenuOriginal();       
    }
    
    public static void escolhaMenuOriginal(){
        scan = new Scanner(System.in);
        int escolha;

        escolha = menuOriginal();

        while(escolha != 6){
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
            case 5:
                final String nome = "contas.txt";
                Formatter saida;
                ContasArquivo.setNome(nome);
                
                System.out.println("Lendo arquivo...");
                scan = ContasArquivo.abreLeitura();
                if (scan != null) {
                    ContasArquivo.leArquivo(scan, arquivo);
                    ContasArquivo.fechaArquivo(scan);
                    mostraContas(contas);
                }    
                
                System.out.println("Gravando arquivo...");
                saida = ContasArquivo.abreGravacao();
                ContasArquivo.gravaContas(saida, arquivo);
                ContasArquivo.fechaArquivo(saida);
                
                escolha = 6;
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
            System.out.println("Não é permitido criar mais contas Pessoa Física");
            } else {
                pf(conta);
            } 
        } else if(conta == 2){
            if(existe){
            System.out.println("Não é permitido criar mais contas Pessoa Jurídica");
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
//            int escolha = scan.nextInt();
            
            for(Contas c : contas) {
                if(c instanceof PF){
                    contas.remove(c);
//                   contas.removeIf(escolha -> escolha.equals(1));
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
        
        int escolha1, escolha2, contaEscolha;
        float saldo;

        if(contas.size() > 0) {  
            for(Contas c : contas){
                System.out.println("Qual tipo de conta? \n[1] Pessoa Física \n[2] Pessoa Jurídica");
                contaEscolha = scan.nextInt();
                
                switch (contaEscolha) {
                    
                    case 1:
                        System.out.println("PESSOA FÍSICA");
                        System.out.println("Quer: \n[1] Crédito \n[2] Débito");
                        escolha1 = scan.nextInt();
                        if(escolha1 == 1){
                            if(c instanceof PF){
                                System.out.println("Quanto de saldo quer creditar na conta de Pessoa Física? ");
                                saldo = scan.nextFloat();
                                c.credito(saldo);
                            }
                        } else if (escolha1 == 2){
                            if(c instanceof PF){
                                System.out.println("Quanto de saldo quer debitar na conta de Pessoa Física? ");
                                saldo = scan.nextFloat();
                                c.debito(saldo);
                                scan.nextLine();
                            }
                        }                       
                        break;
                    case 2:
                        System.out.println("PESSOA JURÍDICA");
                        System.out.println("Quer: \n[1] Crédito \n[2] Débito");
                        escolha2 = scan.nextInt();
                        if(escolha2 == 1){
                            if(c instanceof PJ){
                                System.out.println("Quanto de saldo quer creditar na conta de Pessoa Jurídica? ");
                                saldo = scan.nextFloat();
                                c.credito(saldo);
                            }
                        } else if (escolha2 == 2){
                            if(c instanceof PJ){
                                System.out.println("Quanto de saldo quer debitar na conta de Pessoa Jurídica? ");
                                saldo = scan.nextFloat();
                                c.debito(saldo);
                            }
                        }
                        break;
                    default:
                        System.out.println("Nenhuma conta cadastrada com esse número para ter alteração de saldo.");
                        break;
                }
            }
        } else {
            System.out.println("Nenhuma conta cadastrada para ter alteração de saldo.");
        }
    }
    
    public static void pf(int conta){
        String nomeCorrentista, cpf;
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
    
    public static void clienteNegativo(){
        float saldo;
        
        if(contas.size() > 0) {
            System.out.println("Listagem geral de Contas:");
            for(Contas c : contas) {
                saldo = c.getSaldo();
                if(c instanceof PF){
                    if(saldo < 0){
                        System.out.println(saldo);
                    } else {
                        System.out.println("Conta de pessoa física não está negativa");
                    }
                } else {
                    if(saldo < 0){
                        System.out.println(saldo);
                    } else {
                        System.out.println("Conta de pessoa jurídica não está negativa");
                    }
                }
            }
        } else {
            System.out.println("Nenhuma conta cadastrada!");
        }
    }
    
    public static void clienteAcima(){
        
    }
    
        public static void mostraContas(ArrayList<Contas> contas) {  
        for (Contas c: contas) {
            System.out.println(c);
        }
    }
}
