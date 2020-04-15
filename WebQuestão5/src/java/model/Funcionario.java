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
public class Funcionario extends Pessoa {

    private int id;
    private int id_departamentos;

    public Funcionario(int id, int id_departamentos, String nome, String endereco, String telefone, String cpf) {
        super(nome, endereco, telefone, cpf);
        this.id = id;
        this.id_departamentos = id_departamentos;
    }

    public Funcionario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_departamentos() {
        return id_departamentos;
    }

    public void setId_departamentos(int id_departamentos) {
        this.id_departamentos = id_departamentos;
    }

}
