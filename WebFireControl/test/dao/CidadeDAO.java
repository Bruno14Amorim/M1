package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Cidade;
import modelos.Estado;

public class CidadeDAO {
    
    ConexaoPostgres conexao;

    public CidadeDAO() throws Exception {
        this.conexao = new ConexaoPostgres();
        this.conexao.conecta("");
    }
    
    public List<Cidade> consulta(){
        String sql = "SELECT * FROM cidade";
        List<Cidade> cidades = new ArrayList();
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Cidade u = new Cidade();
                
                u.setId_cidade(rs.getInt("id_cidade"));
                u.setEstado((Estado) rs.getObject("estado"));
                u.setNom_cidade(rs.getString("nome_cidade"));
                cidades.add(u);
            }
            
            pst.close();
            conexao.fechar();
            
        } catch (SQLException ex) {
            Logger.getLogger(CidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cidades;
    }
    
    public Cidade consulta(int codigo){
        String sql = "SELECT * FROM cidade WHERE codigo = ?";
        Cidade u = new Cidade();
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            pst.setInt(1, codigo);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                
                
                u.setId_cidade(rs.getInt("id_cidade"));
                u.setEstado((Estado) rs.getObject("estado"));
                u.setNom_cidade(rs.getString("nome_cidade"));
                
             
            }
            
            pst.close();
            conexao.fechar();
            
        } catch (SQLException ex) {
            Logger.getLogger(CidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
    
    
    
    public boolean inserir(Cidade cidade){
        String sql = "INSERT INTO cidade (id_cidade,estado, nome_cidade) "
                + "VALUES (?,?,?)";
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            
            pst.setInt(1, cidade.getId_cidade());
            pst.setObject(2, cidade.getEstado());
            pst.setString(3, cidade.getNom_cidade());


            pst.executeUpdate();
            conexao.confirmarTransacao();
            pst.close();
            conexao.fechar();
            
        } catch (SQLException ex) {
            Logger.getLogger(CidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return true;
    }   
    
     
    public boolean atualizar(Cidade cidade){
        String sql = "UPDATE cidade SET id_cidade = ?, estado = ?,nome_cidade = ?"
                + " WHERE codigo = ?";
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            
            pst.setInt(1, cidade.getId_cidade());
            pst.setString(2, cidade.getNom_cidade());
            

            pst.executeUpdate();
            conexao.confirmarTransacao();
            pst.close();
            conexao.fechar();
            
        } catch (SQLException ex) {
            Logger.getLogger(CidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return true;
    }
    
     
    public boolean excluir(int cidade){
        String sql = "DELETE FROM cidade "
                + " WHERE codigo = ?";
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            
            pst.setInt(1, cidade);

            pst.executeUpdate();
            conexao.confirmarTransacao();
            pst.close();
            conexao.fechar();
            
        } catch (SQLException ex) {
            Logger.getLogger(CidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return true;
    }
    
}
