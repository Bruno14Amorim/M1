package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Endereco;
import modelos.Produto;
import modelos.Tipo_Produto;

public class ProdutoDAO {
    
    ConexaoPostgres conexao;

    public ProdutoDAO() throws Exception {
        this.conexao = new ConexaoPostgres();
        this.conexao.conecta("");
    }
    
    public List<Produto> consulta(){
        String sql = "SELECT * FROM produto";
        List<Produto> produtos = new ArrayList();
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Produto u = new Produto();
                
                u.setCod_pro(rs.getInt("cod_pro"));
                u.setTipo_prod((Tipo_Produto) rs.getObject("tipo_produto"));
                u.setValidade(rs.getString("validade"));
                u.setDat_cadastro(rs.getString("dat_cadastro"));
                u.setEndereco_prod((Endereco) rs.getObject("endereco_produto"));
                produtos.add(u);
            }
            
            pst.close();
            conexao.fechar();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;
    }
    
    public Produto consulta(int codigo){
        String sql = "SELECT * FROM produto WHERE codigo = ?";
        Produto u = new Produto();
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            pst.setInt(1, codigo);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                
                
                u.setCod_pro(rs.getInt("cod_pro"));
                u.setTipo_prod((Tipo_Produto) rs.getObject("tipo_produto"));
                u.setValidade(rs.getString("validade"));
                u.setDat_cadastro(rs.getString("dat_cadastro"));
                u.setEndereco_prod((Endereco) rs.getObject("endereco_produto"));
             
            }
            
            pst.close();
            conexao.fechar();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
    
    
    
    public boolean inserir(Produto produto){
        String sql = "INSERT INTO produto (cod_pro, tipo_prod, validade,dat_cadastro,endereco_prod) "
                + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            
            pst.setInt(1, produto.getCod_pro());
            pst.setObject(2, produto.getTipo_prod());
            pst.setString(3, produto.getValidade());
            pst.setString(4, produto.getDat_cadastro());
            pst.setObject(5, produto.getEndereco_prod());

            pst.executeUpdate();
            conexao.confirmarTransacao();
            pst.close();
            conexao.fechar();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return true;
    }   
    
     
    public boolean atualizar(Produto produto){
        String sql = "UPDATE produto SET cod_pro = ?, tipo_prod = ?, validade =? ,dat_cadastro = ?, endereco_prod = ?"
                + " WHERE codigo = ?";
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            
            pst.setInt(1, produto.getCod_pro());
            pst.setObject(2, produto.getTipo_prod());
            pst.setString(3, produto.getValidade());
            pst.setString(4, produto.getDat_cadastro());
            pst.setObject(5, produto.getEndereco_prod());
            

            pst.executeUpdate();
            conexao.confirmarTransacao();
            pst.close();
            conexao.fechar();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return true;
    }
    
     
    public boolean excluir(int produto){
        String sql = "DELETE FROM produto "
                + " WHERE codigo = ?";
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            
            pst.setInt(1, produto);

            pst.executeUpdate();
            conexao.confirmarTransacao();
            pst.close();
            conexao.fechar();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return true;
    }
    
}
