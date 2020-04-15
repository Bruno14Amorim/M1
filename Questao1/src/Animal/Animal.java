/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animal;

/**
 *
 * @author bruno
 */
public class Animal {
    private String nome;
    Cachorro raca_canina;
    Gato raca_felina;

    public Animal() {
    }

    public Animal(String nome, Cachorro raca_canina, Gato raca_felina) {
        this.nome = nome;
        this.raca_canina = raca_canina;
        this.raca_felina = raca_felina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cachorro getRaca_canina() {
        return raca_canina;
    }

    public void setRaca_canina(Cachorro raca_canina) {
        this.raca_canina = raca_canina;
    }

    public Gato getRaca_felina() {
        return raca_felina;
    }

    public void setRaca_felina(Gato raca_felina) {
        this.raca_felina = raca_felina;
    }
    
    
        
        
        
    }
    

