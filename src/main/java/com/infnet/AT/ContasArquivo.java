package com.infnet.AT;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ContasArquivo {
    private static String nomeArq;
    
    public static void setNome(String nome) {
        
        nomeArq = nome;
    }
    
    public static Scanner abreLeitura() {
        Scanner entrada = null;
        
        try {
            entrada = new Scanner(new File(nomeArq));
        }
        catch (FileNotFoundException erro) {
            System.out.println("Erro: arquivo nao existe");
        }
        return entrada;
    }    
    
    public static Formatter abreGravacao() {
        Formatter saida = null;
        
        try {
            saida = new Formatter(nomeArq);
        }
        catch (FileNotFoundException erro) {
            System.out.println("Erro: criacao do arquivo");
            System.exit(1);
        }
        catch (SecurityException erro) {
            System.out.println("Erro: problema de acesso ao arquivo");
            System.exit(1);
        }
        return saida;
    }    
    
    public static void leArquivo(Scanner entrada, ArrayList<Contas> conta) {
        
        try {
            String linha;
            String[] campos;
            while(entrada.hasNext()) {
                linha = entrada.nextLine();
                campos = linha.split(";");
                conta.setNumeroDaConta(Integer.valueOf(campos[0]));
                aluno.setNota(Integer.parseInt(campos[1]));
                alunos.add(aluno);      
            }
        }
        catch (NoSuchElementException erro) {
            System.out.println("Erro: formatacao do arquivo");
        }
        catch (IllegalStateException erro) {
            System.out.println("Erro: leitura do arquivo");
        }
    }
        
    public static void gravaContas(Formatter saida, ArrayList<Contas> conta) {
    
        for (int i = 0; i < conta.size(); i++) {
            
            System.out.println(conta.get(i));
            
            System.out.println(conta instanceof PF);    
            
            
            try {
                saida.format("%s;%d\n", conta.get(i).getNome(), conta.get(i).getNota());
            }
            catch (FormatterClosedException erro) {
                System.err.println("Erro: gravação no arquivo" );
            }
        }
    }
    
    public static void fechaArquivo(Scanner entrada) {
        
        if (entrada != null) {
            entrada.close();
        }
    }    
    
    public static void fechaArquivo(Formatter saida) {
        
        if (saida != null) {
            saida.close();
        }
    }    
}
