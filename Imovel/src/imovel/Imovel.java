/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imovel;

import java.util.Scanner;

/**
 *
 * @author robso
 */
public class Imovel {

   public int endereco;

    public int getEndereco() {
        return endereco;
    }

    public void setEndereco(int endereco) {
        this.endereco = endereco;
    }

   
        
    public static void main(String[] args) {
        
        Scanner val = new Scanner(System.in);
        
        System.out.println("informe o preco novo");
        double preco = val.nextDouble();
        
        System.out.println("inserir o preco velho");
        double desconto = val.nextDouble();
       double conta = desconto -15;
        if(preco == preco){
            System.out.println(preco + "preco sem desconto");
        }
        if(desconto == desconto){
            System.out.println(conta + "preco com desconto");
        }
    }
    
}
