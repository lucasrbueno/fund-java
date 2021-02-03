package com.infnet.oo;

public class Carro {
    private String modelo;
    private Motor motor;
    
    public Carro(String modelo, float cilindrada){
        this.modelo = modelo;
        motor = new Motor(cilindrada);
    }
    
    public void velocidadeMaxima(){
        if(motor.cilindrada <= 1.0){
            System.out.println(modelo + " possui velocidade máxima de 140 km/h");
        } else if(motor.cilindrada <= (float) 1.6){
            System.out.println(modelo + " possui velocidade máxima de 180 km/h");
        } else if(motor.cilindrada <= 2.0){
            System.out.println(modelo + " possui velocidade máxima de 200 km/h");
        } else {
            System.out.println(" possui velocidade máxima de 260 km/h");
        }
    }
    
    public static void main(String[] args) {
        Carro c1 = new Carro("Fox", (float) 1.0);
        c1.velocidadeMaxima();
        Carro c2 = new Carro("Fiesta", (float) 1.6);
        c2.velocidadeMaxima();
        Carro c3 = new Carro("Jetta", (float) 2.0);
        c3.velocidadeMaxima();
    }
}
