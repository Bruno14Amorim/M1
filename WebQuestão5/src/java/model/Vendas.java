/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author bruno
 */
public class Vendas {
    
    private int id;
    private int id_funcionario;
    private int id_carro;
    private int id_pessoaFisica;
    private float preco;

    public Vendas(int id, int id_funcionario, int id_carro, int id_pessoaFisica, float preco) {
        this.id = id;
        this.id_funcionario = id_funcionario;
        this.id_carro = id_carro;
        this.id_pessoaFisica = id_pessoaFisica;
        this.preco = preco;
    }

    public Vendas() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public int getId_carro() {
        return id_carro;
    }

    public void setId_carro(int id_carro) {
        this.id_carro = id_carro;
    }

    public int getId_pessoaFisica() {
        return id_pessoaFisica;
    }

    public void setId_pessoaFisica(int id_pessoaFisica) {
        this.id_pessoaFisica = id_pessoaFisica;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    
    
    
}
