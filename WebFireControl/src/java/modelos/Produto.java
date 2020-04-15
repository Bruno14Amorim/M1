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
public class Produto {
    
    private int cod_pro;
    private Tipo_Produto tipo_prod;
    private String validade;
    private String dat_cadastro;
    private Endereco endereco;

    public Produto() {
    }

    public Produto(int cod_pro, Tipo_Produto tipo_prod, String validade, String dat_cadastro, Endereco endereco) {
        this.cod_pro = cod_pro;
        this.tipo_prod = tipo_prod;
        this.validade = validade;
        this.dat_cadastro = dat_cadastro;
        this.endereco = endereco;
    }

    public int getCod_pro() {
        return cod_pro;
    }

    public void setCod_pro(int cod_pro) {
        this.cod_pro = cod_pro;
    }

    public Tipo_Produto getTipo_prod() {
        return tipo_prod;
    }

    public void setTipo_prod(Tipo_Produto tipo_prod) {
        this.tipo_prod = tipo_prod;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getDat_cadastro() {
        return dat_cadastro;
    }

    public void setDat_cadastro(String dat_cadastro) {
        this.dat_cadastro = dat_cadastro;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    
    
}
