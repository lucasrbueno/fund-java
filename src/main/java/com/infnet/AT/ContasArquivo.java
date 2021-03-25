//package com.infnet.AT;
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class ContasArquivo {
//    private static Map<Integer, Funcionario> mapaFuncionario = new HashMap<>();
//    
//    public static void main(String[] args) {
//        
//        init("C:/dev/", "lucas.txt");
//        
//        for(Funcionario f: mapaFuncionario.values()){
//            f.impressao();
//        }
//    }
//    
//    public static void incluir(Funcionario funcionario){
//        mapaFuncionario.put(funcionario.getId(), funcionario);
//    }
//    
//    private static void init(String diretorio, String arquivo){
//        try {
//            FileReader file = new FileReader(diretorio + arquivo);
//            BufferedReader leitura = new BufferedReader(file);
//            
//            String linha = leitura.readLine();
//            String[] campos = null;
//            
//            Integer id = 0;
//            
//            while(linha != null){
//                campos = linha.split(";");
//                                
//                switch(campos[0]){
//                    case "A":
//                    AnalistaSistema analista = new AnalistaSistema();
//
//                    analista.setId(id++);
//                    
//                    analista.setNome(campos[1]);
//
//                    analista.setEmail(campos[2]);
//
//                    analista.setSalario(Float.valueOf(campos[3]));
//
//                    analista.setIdade(Integer.valueOf(campos[4]));
//
//                    analista.setQtdeSistema(Integer.valueOf(campos[5]));
//
//                    analista.setTempoExperiencia(Integer.valueOf(campos[6]));              
//                    
//                    incluir(analista);
//
//                        break;
//                    case "P":
//                    Programador programador = new Programador();
//                    
//                    programador.setId(id++);
//
//                    programador.setNome(campos[1]);
//
//                    programador.setEmail(campos[2]);
//
//                    programador.setSalario(Float.valueOf(campos[3]));
//
//                    programador.setIdade(Integer.valueOf(campos[4]));
//
//                    programador.setLinguagem(campos[5]);
//
//                    programador.setValorAdicional(Float.valueOf(campos[6]));
//                    
//                    incluir(programador);
//                    
//                        break;
//                    default:
//                        System.out.println("Não existe " + campos[0]);
//                        break;
//                }
//                
//                linha = leitura.readLine();
//            }      
//
//            leitura.close();
//            file.close();
//        } catch (FileNotFoundException ex) {
//            System.out.println("problemas na leitura");       
//        } catch (IOException ex) {
//            
//        }
//    }
//}
