package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Usuario;

public class UsuarioDAO {
    
    ConexaoPostgres conexao;

    public UsuarioDAO() throws Exception {
        this.conexao = new ConexaoPostgres();
        this.conexao.conecta("");
    }
    
    public List<Usuario> consulta(){
        String sql = "SELECT * FROM usuario";
        List<Usuario> usuarios = new ArrayList();
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Usuario u = new Usuario();
                
                u.setEmail(rs.getString("email"));
                u.setNome(rs.getString("nome"));
                u.setSobrenome(rs.getString("sobrenome"));
                u.setTelefone(rs.getString("telefone"));
                u.setSenha(rs.getString("senha"));
                usuarios.add(u);
            }
            
            pst.close();
            conexao.fechar();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }
    
    public Usuario consulta(int codigo){
        String sql = "SELECT * FROM usuario WHERE codigo = ?";
        Usuario u = new Usuario();
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            pst.setInt(1, codigo);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                
                
                u.setEmail(rs.getString("email"));
                u.setNome(rs.getString("nome"));
                u.setSobrenome(rs.getString("sobrenome"));
                u.setTelefone(rs.getString("telefone"));
                u.setSenha(rs.getString("senha"));
             
            }
            
            pst.close();
            conexao.fechar();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
    
    
    
    public String inserir(Usuario usuario){
        String sql = "INSERT INTO usuario (email, nome, sobrenome,telefone,senha) "
                + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            
            pst.setString(2, usuario.getNome());
            pst.setString(3, usuario.getSobrenome());
            pst.setString(1, usuario.getEmail());
            pst.setString(4, usuario.getTelefone());
            pst.setString(5, usuario.getSenha());

            pst.executeUpdate();
            conexao.confirmarTransacao();
            pst.close();
            conexao.fechar();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return sql;
    }   
    
     
    public boolean atualizar(Usuario usuario){
        String sql = "UPDATE usuario SET email = ?, nome = ?, sobrenome =? ,telefone = ?, senha = ?"
                + " WHERE codigo = ?";
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            
            pst.setString(2, usuario.getNome());
            pst.setString(3, usuario.getSobrenome());
            pst.setString(1, usuario.getEmail());
            pst.setString(4, usuario.getTelefone());
            pst.setString(5, usuario.getSenha());
            

            pst.executeUpdate();
            conexao.confirmarTransacao();
            pst.close();
            conexao.fechar();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return true;
    }
    
     
    public boolean excluir(int usuario){
        String sql = "DELETE FROM usuario "
                + " WHERE codigo = ?";
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            
            pst.setInt(1, usuario);

            pst.executeUpdate();
            conexao.confirmarTransacao();
            pst.close();
            conexao.fechar();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return true;
    }
    
}
