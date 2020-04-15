package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Tipo_Produto;

public class TipoProdutoDAO {
    
    ConexaoPostgres conexao;

    public TipoProdutoDAO() throws Exception {
        this.conexao = new ConexaoPostgres();
        this.conexao.conecta("");
    }
    
    public List<Tipo_Produto> consulta(){
        String sql = "SELECT * FROM tipo_produto";
        List<Tipo_Produto> tipo_produtos = new ArrayList();
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Tipo_Produto u = new Tipo_Produto();
                
                u.setTipo_prod(rs.getInt("id_tipo_produto"));
                u.setNom_prod(rs.getString("nom_tipo_produto"));
                tipo_produtos.add(u);
            }
            
            pst.close();
            conexao.fechar();
            
        } catch (SQLException ex) {
            Logger.getLogger(TipoProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TipoProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tipo_produtos;
    }
    
    public Tipo_Produto consulta(int codigo){
        String sql = "SELECT * FROM tipo_produto WHERE codigo = ?";
        Tipo_Produto u = new Tipo_Produto();
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            pst.setInt(1, codigo);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                
                
                u.setTipo_prod(rs.getInt("id_tipo_produto"));
                u.setNom_prod(rs.getString("nom_tipo_produto"));
                
             
            }
            
            pst.close();
            conexao.fechar();
            
        } catch (SQLException ex) {
            Logger.getLogger(TipoProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TipoProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
    
    
    
    public boolean inserir(Tipo_Produto tipo_produto){
        String sql = "INSERT INTO tipo_produto (id_tipo_produto, nom_tipo_produto) "
                + "VALUES (?,?)";
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            
            pst.setInt(1, tipo_produto.getTipo_prod());
            pst.setString(2, tipo_produto.getNom_prod());


            pst.executeUpdate();
            conexao.confirmarTransacao();
            pst.close();
            conexao.fechar();
            
        } catch (SQLException ex) {
            Logger.getLogger(TipoProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TipoProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return true;
    }   
    
     
    public boolean atualizar(Tipo_Produto tipo_produto){
        String sql = "UPDATE tipo_produto SET id_tipo_produto = ?, nom_tipo_produto = ?"
                + " WHERE codigo = ?";
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            
            pst.setInt(1, tipo_produto.getTipo_prod());
            pst.setString(2, tipo_produto.getNom_prod());
            

            pst.executeUpdate();
            conexao.confirmarTransacao();
            pst.close();
            conexao.fechar();
            
        } catch (SQLException ex) {
            Logger.getLogger(TipoProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TipoProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return true;
    }
    
     
    public boolean excluir(int tipo_produto){
        String sql = "DELETE FROM tipo_produto "
                + " WHERE codigo = ?";
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            
            pst.setInt(1, tipo_produto);

            pst.executeUpdate();
            conexao.confirmarTransacao();
            pst.close();
            conexao.fechar();
            
        } catch (SQLException ex) {
            Logger.getLogger(TipoProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TipoProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return true;
    }
    
}
