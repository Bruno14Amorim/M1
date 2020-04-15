/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexao.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Funcionario;

/**
 *
 * @author bruno
 */
public class FuncionarioDAO {
    
    private Connection con = null;

    public FuncionarioDAO() {
        con = ConexaoBanco.getConnection();
    }

    public boolean add_funcionario (Funcionario c) {

        String sql = "INSERT INTO public.\"Funcionario\" (nome, id_departamentos, endereco, telefone, cpf) VALUES (?,?,?,?,?)";

        try {
            con = ConexaoBanco.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, c.getNome());
            stmt.setInt(2, c.getId_departamentos());
            stmt.setString(3, c.getEndereco());
            stmt.setString(4, c.getTelefone());
            stmt.setString(5, c.getCpf());
            

            stmt.execute();

            System.out.println("\nFuncionário Adicionado no Banco de Dados\n");
            return true;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return false;
        } finally {
            ConexaoBanco.closeConnection(con);
        }

    }

    public ArrayList<Funcionario> mostrar_funcionario() {

        ArrayList<Funcionario> retorno = new ArrayList<>();

        String sql = "SELECT * FROM public.\"Funcionario\"";

        try {
            con = ConexaoBanco.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Funcionario c = new Funcionario();

                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setId_departamentos(rs.getInt("id_departamentos"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));
                c.setCpf(rs.getString("cpf"));

                retorno.add(c);

            }

            rs.close();

            return retorno;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConexaoBanco.closeConnection(con);
        }
        return null;
    }

    public boolean delete_funcionario(int id) {

        String sql = "DELETE FROM public.\"Funcionario\" WHERE id = ?";

        try {
            con = ConexaoBanco.getConnection();

            PreparedStatement stmt1 = con.prepareStatement(sql);

            stmt1.setInt(1, id);
            stmt1.executeUpdate();
            System.out.println("\nFuncionário Deletado do Banco de Dados\n");
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return false;
        } finally {
            ConexaoBanco.closeConnection(con);
        }
    }

    public Funcionario achar_funcionario(int id) {

        Funcionario c = new Funcionario();
        String sql = "SELECT * FROM public.\"Funcionario\" WHERE id = ?";

        try {
            con = ConexaoBanco.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setId_departamentos(rs.getInt("id_departamentos"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));
                c.setCpf(rs.getString("cpf"));

            }
            return c;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return null;
        } finally {
            ConexaoBanco.closeConnection(con);
        }
    }

    public void alterar_funcionario(int id, String nome, int id_departamentos, String endereco, String telefone, String cpf) {

        String sql = "UPDATE public.\"Funcionario\" SET nome = ?, id_departamentos = ?, endereco = ?, telefone = ?, cpf = ? WHERE id = ?";

        try {
            con = ConexaoBanco.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, nome);
            stmt.setInt(2, id_departamentos);
            stmt.setString(3, endereco);
            stmt.setString(4, telefone);
            stmt.setString(5, cpf);
            stmt.setInt(6, id);

            stmt.executeUpdate();

            System.out.println("\nFuncionário Editado no Banco de Dados\n");
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConexaoBanco.closeConnection(con);
        }
    }
    
}
