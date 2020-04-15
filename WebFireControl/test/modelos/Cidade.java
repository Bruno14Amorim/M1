
package modelos;





/**
 *
 * @author Bruno
 */
public class Cidade {
    private int id_cidade;
    private Estado estado;
    private String nom_cidade;

    public Cidade() {
        this.estado = new Estado();
    }

    public void Cidade (int id_cidade, Estado estado, String nom_cidade) {
        this.id_cidade = id_cidade;
        this.estado = estado;
        this.nom_cidade = nom_cidade;
    }
    

    public int getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(int id_cidade) {
        this.id_cidade = id_cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getNom_cidade() {
        return nom_cidade;
    }

    public void setNom_cidade(String nom_cidade) {
        this.nom_cidade = nom_cidade;
    }
    
    
    
}
