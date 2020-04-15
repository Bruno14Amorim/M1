/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingresso;

import java.util.Scanner;

/**
 *
 * @author robso
 */
public class Ingresso{

    private double reais;
    public void imprimevalor(){
        
    }
    public static void main(String[] args) {
        Scanner val = new Scanner(System.in);
        System.out.println("informe o valor vip");
        double vip = val.nextDouble();
        System.out.println("informe o valor normal");
        double normal = val.nextDouble();
        System.out.println("informe o valor camarote");
        double camarote = val.nextDouble();
       
        if(vip == vip){
            System.out.println(vip + " Voce é vip");
        }
        if(normal==normal){
            System.out.println(normal + " preço normal");
        }
        if(camarote==camarote){
            System.out.println(camarote + " preço camarote");
        }
    }
    
}
