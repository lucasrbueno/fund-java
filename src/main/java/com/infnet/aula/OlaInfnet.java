package com.infnet.aula;
import java.util.Scanner;

public class OlaInfnet {
    public static void main(String[] args) {
//     System.out.println("Olá, Infnet!"); 
    int n1, n2, pf;
    double m;
    
    n1 = oInt("Nota 1: ");
    n2 = oInt("Nota 2: ");
    
    m = (double) (n1 + n2) / 2;
    
    System.out.println("Media = " + m);
    
    if(m >= 6){
        System.out.println("Aluno aprovado");
    }
    else {
        System.out.println("Aluno em prova final");
        pf = oInt("Nota Prova Final: ");
        m = (m + pf) / 2;
        System.out.println("Media nova = " + m);
        
        if(m >= 6){
        System.out.println("Aluno aprovado na prova final");
    }
        else {
            System.out.println("Aluno reprovado na prova final");
        }
    }
            
}
    public static int oInt(String msg){
        Scanner scan = new Scanner(System.in);
        int nota;
        
        System.out.println(msg);
        nota = scan.nextInt();
        return nota;
    }

}


