/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Bruno
 */
public class Endereco {
    private int id_end;
    private Usuario usuario;
    private Cidade cidade;
    private String cep;
    private String bairro;
    private String num_casa;

    public Endereco() {
      
    }

    public Endereco(int id_end, Usuario usuario, Cidade cidade, String cep, String bairro, String num_casa) {
        this.id_end = id_end;
        this.usuario = usuario;
        this.cidade = cidade;
        this.cep = cep;
        this.bairro = bairro;
        this.num_casa = num_casa;
    }

    public int getId_end() {
        return id_end;
    }

    public void setId_end(int id_end) {
        this.id_end = id_end;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNum_casa() {
        return num_casa;
    }

    public void setNum_casa(String num_casa) {
        this.num_casa = num_casa;
    }

}
