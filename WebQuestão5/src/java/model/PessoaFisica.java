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
public class PessoaFisica extends Pessoa{
    
    private int id;
    private String profissao;

    public PessoaFisica(int id, String profissao, String nome, String endereco, String telefone, String cpf) {
        super(nome, endereco, telefone, cpf);
        this.id = id;
        this.profissao = profissao;
    }

    public PessoaFisica() {
    }   
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }    
}
