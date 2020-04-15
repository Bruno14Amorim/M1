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
public class Tipo_Produto {
    private int tipo_prod;
    private String nom_prod;

    public Tipo_Produto() {
    }

    public Tipo_Produto(int tipo_prod, String nom_prod) {
        this.tipo_prod = tipo_prod;
        this.nom_prod = nom_prod;
    }

    public int getTipo_prod() {
        return tipo_prod;
    }

    public void setTipo_prod(int tipo_prod) {
        this.tipo_prod = tipo_prod;
    }

    public String getNom_prod() {
        return nom_prod;
    }

    public void setNom_prod(String nom_prod) {
        this.nom_prod = nom_prod;
    }
    
    
    
}
