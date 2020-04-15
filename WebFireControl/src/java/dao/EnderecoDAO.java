package dao;

import dao.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Cidade;
import modelos.Endereco;
import modelos.Usuario;


public class EnderecoDAO {
    
    ConexaoPostgres conexao;

    public EnderecoDAO() throws Exception {
        this.conexao = new ConexaoPostgres();
        this.conexao.conecta("");
    }
    
    public List<Endereco> consulta(){
        String sql = "SELECT * FROM endereco";
        List<Endereco> enderecos = new ArrayList();
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Endereco u = new Endereco();
                
                u.setId_end(rs.getInt("id_end"));
                u.setUsuario((Usuario) rs.getObject("usuario"));
                u.setCidade((Cidade) rs.getObject("cidade"));
                u.setCep(rs.getString("set_cep"));
                u.setBairro(rs.getString("bairro"));
                u.setNum_casa(rs.getString("num_casa"));
                enderecos.add(u);
            }
            
            pst.close();
            conexao.fechar();
            
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return enderecos;
    }
    
    public Endereco consulta(int codigo){
        String sql = "SELECT * FROM endereco WHERE codigo = ?";
        Endereco u = new Endereco();
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            pst.setInt(1, codigo);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                
                
                u.setId_end(rs.getInt("id_end"));
                u.setUsuario((Usuario) rs.getObject("usuario"));
                u.setCidade((Cidade) rs.getObject("cidade"));
                u.setCep(rs.getString("cep"));
                u.setBairro(rs.getString("bairro"));
                u.setNum_casa(rs.getString("num_casa"));
             
            }
            
            pst.close();
            conexao.fechar();
            
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
    
    
    
    public boolean inserir(Endereco endereco){
        String sql = "INSERT INTO endereco (id_end, usuario, cidade,cep,bairro,num_casa) "
                + "VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            
            pst.setInt(1, endereco.getId_end());
            pst.setObject(2, endereco.getUsuario());
            pst.setObject(3, endereco.getCidade());
            pst.setString(4, endereco.getCep());
            pst.setString(5, endereco.getBairro());
            pst.setString(6, endereco.getNum_casa());

            pst.executeUpdate();
            conexao.confirmarTransacao();
            pst.close();
            conexao.fechar();
            
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return true;
    }   
    
     
    public boolean atualizar(Endereco endereco){
        String sql = "UPDATE endereco SET id_end = ?, usuario = ?, cidade =? ,cep = ?, bairro = ?,num_casa = ?"
                + " WHERE codigo = ?";
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            
            pst.setInt(1, endereco.getId_end());
            pst.setObject(2, endereco.getUsuario());
            pst.setObject(3, endereco.getCidade());
            pst.setString(4, endereco.getCep());
            pst.setString(5, endereco.getBairro());
            pst.setString(6, endereco.getNum_casa());
            

            pst.executeUpdate();
            conexao.confirmarTransacao();
            pst.close();
            conexao.fechar();
            
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return true;
    }
    
     
    public boolean excluir(int endereco){
        String sql = "DELETE FROM endereco "
                + " WHERE codigo = ?";
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            
            pst.setInt(1, endereco);

            pst.executeUpdate();
            conexao.confirmarTransacao();
            pst.close();
            conexao.fechar();
            
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return true;
    }
    
}
