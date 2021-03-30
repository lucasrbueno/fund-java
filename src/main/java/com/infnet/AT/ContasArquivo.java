package com.infnet.AT;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContasArquivo {
    private static Map<Integer, Contas> mapaContas = new HashMap<>();
    
    public static void main(String[] args) {
        
        init("C:/dev/", "lucas.txt");
        
        for(Contas c: mapaContas.values()){
            System.out.println(c);
        }
    }
    
    public static void incluir(Contas conta){
        mapaContas.put(conta.getNumeroDaConta(), conta);
    }
    
    private static void init(String diretorio, String arquivo){
        try {
            FileReader file = new FileReader(diretorio + arquivo);
            BufferedReader leitura = new BufferedReader(file);
            
            String linha = leitura.readLine();
            String[] campos = null;
            
//            Integer id = 0;
            
            while(linha != null){
                campos = linha.split(";");
                                
                switch(campos[0]){
                    case "PF":
                    int contaNumero = 0;
                    float chequeEspecial = 0, saldo = 0;
                    String nomeCorrentista = "", cpf = "";
                    
                    PF pf = new PF(contaNumero, nomeCorrentista, cpf, chequeEspecial, saldo);
                    
//                    programador.setId(id++);
                    
                    pf.setNumeroDaConta(Integer.valueOf(campos[0]));

                    pf.setNomeDoCorrentista(campos[1]);

                    pf.setCpf(campos[2]);

                    pf.setChequeEspecial(Float.valueOf(campos[3]));

                    pf.setSaldo(Float.valueOf(campos[6]));

                    incluir(pf);
                    
                        break;
                    case "PJ":
                        
                    String cnpj = "", nomeEmpresa = "";
                    contaNumero = 0;
                    saldo = 0;
                    
                    PJ pj = new PJ(contaNumero, nomeEmpresa, cnpj, saldo);

//                    pj.setId(id++);
                    
                    pj.setNumeroDaConta(Integer.valueOf(campos[0]));

                    pj.setNomeDaEmpresa(campos[1]);

                    pj.setCnpj(campos[2]);

                    pj.setSaldo(Float.valueOf(campos[3]));             
                    
                    incluir(pj);
          
                    
                        break;
                    default:
                        System.out.println("Não existe " + campos[0]);
                        break;
                }
                
                linha = leitura.readLine();
            }      

            leitura.close();
            file.close();
        } catch (FileNotFoundException ex) {
            System.out.println("problemas na leitura");       
        } catch (IOException ex) {
            
        }
    }
}
