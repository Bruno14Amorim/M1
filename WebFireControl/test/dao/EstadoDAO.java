package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Estado;

public class EstadoDAO {
    
    ConexaoPostgres conexao;

    public EstadoDAO() throws Exception {
        this.conexao = new ConexaoPostgres();
        this.conexao.conecta("");
    }
    
    public List<Estado> consulta(){
        String sql = "SELECT * FROM estado";
        List<Estado> estados = new ArrayList();
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Estado u = new Estado();
                
                u.setId_estado(rs.getInt("id_estado"));
                u.setNom_estado(rs.getString("nom_estado"));
                estados.add(u);
            }
            
            pst.close();
            conexao.fechar();
            
        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estados;
    }
    
    public Estado consulta(int codigo){
        String sql = "SELECT * FROM estado WHERE codigo = ?";
        Estado u = new Estado();
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            pst.setInt(1, codigo);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                
                
                u.setId_estado(rs.getInt("id_estado"));
                u.setNom_estado(rs.getString("nom_estado"));
                
             
            }
            
            pst.close();
            conexao.fechar();
            
        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
    
    
    
    public boolean inserir(Estado estado){
        String sql = "INSERT INTO estado (id_estado, nom_estado) "
                + "VALUES (?,?)";
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            
            pst.setInt(1, estado.getId_estado());
            pst.setString(2, estado.getNom_estado());


            pst.executeUpdate();
            conexao.confirmarTransacao();
            pst.close();
            conexao.fechar();
            
        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return true;
    }   
    
     
    public boolean atualizar(Estado estado){
        String sql = "UPDATE estado SET id_estado = ?, nom_estado = ?"
                + " WHERE codigo = ?";
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            
            pst.setInt(1, estado.getId_estado());
            pst.setString(2, estado.getNom_estado());
            

            pst.executeUpdate();
            conexao.confirmarTransacao();
            pst.close();
            conexao.fechar();
            
        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return true;
    }
    
     
    public boolean excluir(int estado){
        String sql = "DELETE FROM estado "
                + " WHERE codigo = ?";
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            
            pst.setInt(1, estado);

            pst.executeUpdate();
            conexao.confirmarTransacao();
            pst.close();
            conexao.fechar();
            
        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return true;
    }
    
}
