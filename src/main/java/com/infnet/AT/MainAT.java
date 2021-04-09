package com.infnet.AT;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainAT {
    private static Scanner scan;
    private static Scanner in;
    private static final ArrayList<Contas> contas = new ArrayList<>();
    
    public static void main(String[] args) {
        
        escolhaMenuOriginal();       
    }
    
    public static void escolhaMenuOriginal(){
        scan = new Scanner(System.in);
        in = new Scanner(System.in);
        int escolha;
        final String nome = "contas.txt";
        Formatter saida;
        
        ContasArquivo.setNome(nome);
        in = ContasArquivo.abreLeitura();
        if (in != null) {
            ContasArquivo.leArquivo(in, contas);
            ContasArquivo.fechaArquivo(in);
        } 

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
        
        System.out.println("Gravando arquivo...");
        saida = ContasArquivo.abreGravacao();
        ContasArquivo.gravaContas(saida, contas);
        ContasArquivo.fechaArquivo(saida);
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
//        int tipoConta = scan.nextInt();
//        System.out.println("Escolha uma conta:");
        int conta = scan.nextInt();
        boolean existe = pesquisaConta(contas, conta);
        
        if(existe == false){
            switch (conta){
                case 1:
                    pf(conta);
                    break;
                case 2:
                    pj(conta);
                    break;
                default:
                 System.out.println("Valor inválido");   
            }
        }

//        if(conta == 1){
//            if(existe){
//            System.out.println("Não é permitido criar mais contas Pessoa Física");
//            } else {
//                pf(conta);
//            } 
//        } else if(conta == 2){
//            if(existe){
//            System.out.println("Não é permitido criar mais contas Pessoa Jurídica");
//            } else {
//                pj(conta);
//            } 
//        } 
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
            System.out.println("Qual conta você quer apagar? \n[1] Conta de Pessoa Física \n[2] Conta de Pessoa Jurídica");
            int escolha = scan.nextInt();
            
            for(int i = 0; i < contas.size(); i++){
                if(escolha == contas.get(i).getNumeroDaConta()){
                    contas.remove(i);
                } else{
                    System.out.println("Não existem contas com o número: " + escolha);
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
                        .append("\n[2] Listar Clientes com saldo acima de 100 reais")
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
                clienteNegativo();
                break;
            case 2:
                clienteAcima();
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
        
        int contaEscolha;

        if(contas.size() > 0) {  
                System.out.println("Qual tipo de conta? \n[1] Pessoa Física \n[2] Pessoa Jurídica");
                contaEscolha = scan.nextInt();
                
                switch (contaEscolha) {
                    case 1:
                        calculoPF(contas);
                        break;
                    case 2:
                        calculoPJ(contas);
                        break;
                    default:
                        System.out.println("Nenhuma conta cadastrada com esse número para ter alteração de saldo.");
                        break;
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
            System.out.println("Listagem de contas negativadas:");
            for(Contas c : contas) {     
                if(c instanceof PF){
                    saldo = c.getSaldo();
                    if(saldo < 0){
                        System.out.println("--------------------------------------------");
                        System.out.println("PF:\n" + c);
                    } else {
                        System.out.println("Conta de pessoa física não está negativa");
                    }
                } else if(c instanceof PJ) {
                    saldo = c.getSaldo();
                    if(saldo < 0){
                        System.out.println("--------------------------------------------");
                        System.out.println("PJ:\n" + c);
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
        float saldo;
        
        if(contas.size() > 0) {
            System.out.println("Listagem de contas acima de um valor previsto:");
            for(Contas c : contas) {
                saldo = c.getSaldo();

                if(c instanceof PF){
                    if(saldo > 100){
                        System.out.println("--------------------------------------------");
                        System.out.println("PF:\n" + c);
                    } else {
                        System.out.println("Conta de pessoa física está abaixo de 100 reais de saldo");
                    }
                } else if(c instanceof PJ) {
                    if(saldo > 100){
                        System.out.println("--------------------------------------------");
                        System.out.println("PJ:\n" + c);
                    } else {
                        System.out.println("Conta de pessoa jurídica está abaixo de 100 reais de saldo");
                    }
                }
            }
        } else {
            System.out.println("Nenhuma conta cadastrada!");
        }
    }
    
    public static void mostraContas(ArrayList<Contas> contas) {  
            for (Contas c: contas) {
                System.out.println(c);
            }
    }
    
    public static void operacoesFeitas(){
        
    }
    
    public static void calculoPF(ArrayList<Contas> contas){
            for(int i = 0; i < contas.size(); i++){
                System.out.println("PESSOA FÍSICA");
                System.out.println("Quer: \n[1] Crédito \n[2] Débito");
                int escolha = scan.nextInt();
                float saldo;

                float devendo = -((PF) contas.get(i)).getChequeEspecial();
                switch (escolha) {
                    case 1:
                        if(contas.get(i) instanceof PF){
                            System.out.println("Quanto de saldo quer creditar na conta de Pessoa Física? ");
                            saldo = scan.nextFloat();
                            contas.get(i).credito(saldo);
                        } else {
                            System.out.println("Não existem contas PF para crédito");
                        } break;
                    case 2:
                        if(contas.get(i) instanceof PF){
                                System.out.println("Quanto de saldo quer debitar na conta de Pessoa Física? ");
                                saldo = scan.nextFloat();
                                float calculo = contas.get(i).getSaldo() - saldo;
                            if((contas.get(i).getSaldo() == devendo) || calculo < devendo){
                                System.out.println("Saldo insuficiente para débito.");
                            } else {
                                contas.get(i).debito(saldo);
                            }
                        } break;
                    default:
                        System.out.println("Não existem contas PF para débito");
                        break;
                }   
            }
    }
    
    public static void calculoPJ(ArrayList<Contas> contas){   
        for(int i = 0; i < contas.size(); i++){ 
            System.out.println("PESSOA JURÍDICA");
            System.out.println("Quer: \n[1] Crédito \n[2] Débito");
            int escolha = scan.nextInt();
            float saldo;
            
            if(escolha == 1){
                if(contas.get(i) instanceof PJ){
                    System.out.println("Quanto de saldo quer creditar na conta de Pessoa Jurídica? ");
                    saldo = scan.nextFloat();
                    contas.get(i).credito(saldo);
                } else {
                    System.out.println("Não existem contas PJ para crédito");
                }
                } else if (escolha == 2){
                    if(contas.get(i) instanceof PJ){
                        System.out.println("Quanto de saldo quer debitar na conta de Pessoa Jurídica? ");
                        saldo = scan.nextFloat();
                        float calculo = contas.get(i).getSaldo() - saldo;
                    if((contas.get(i).getSaldo() < 0) || (calculo < 0) ){
                        System.out.println("Saldo insuficiente para débito.");
                    } else {
                        contas.get(i).debito(saldo);
                    }
                } else {
                    System.out.println("Não existem contas PJ para débito");
                }
            }
        }
    }
}
