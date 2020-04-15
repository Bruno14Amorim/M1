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
import model.PessoaFisica;

/**
 *
 * @author bruno
 */
public class PessoaFisicaDAO {
    
    private Connection con = null;

    public PessoaFisicaDAO() {
        con = ConexaoBanco.getConnection();
    }

    public boolean add_pessoaFisica(PessoaFisica c) {

        String sql = "INSERT INTO public.\"Pessoa_fisica\" (nome, profissao, endereco, telefone, cpf) VALUES (?,?,?,?,?)";

        try {
            con = ConexaoBanco.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getProfissao());
            stmt.setString(3, c.getEndereco());
            stmt.setString(4, c.getTelefone());
            stmt.setString(5, c.getCpf());
            

            stmt.execute();

            System.out.println("\nPessoaFisica Adicionado no Banco de Dados\n");
            return true;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return false;
        } finally {
            ConexaoBanco.closeConnection(con);
        }

    }

    public ArrayList<PessoaFisica> mostrar_pessoaFisica() {

        ArrayList<PessoaFisica> retorno = new ArrayList<>();

        String sql = "SELECT * FROM public.\"Pessoa_fisica\"";

        try {
            con = ConexaoBanco.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                PessoaFisica c = new PessoaFisica();

                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setProfissao(rs.getString("profissao"));
                c.setEndereco(rs.getString("profissao"));
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

    public boolean delete_pessoaFisica(int id) {

        String sql = "DELETE FROM public.\"Pessoa_fisica\" WHERE id = ?";

        try {
            con = ConexaoBanco.getConnection();

            PreparedStatement stmt1 = con.prepareStatement(sql);

            stmt1.setInt(1, id);
            stmt1.executeUpdate();
            System.out.println("\nPessoaFisica Deletado do Banco de Dados\n");
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return false;
        } finally {
            ConexaoBanco.closeConnection(con);
        }
    }

    public PessoaFisica achar_pessoaFisica(int id) {

        PessoaFisica c = new PessoaFisica();
        String sql = "SELECT * FROM public.\"Pessoa_fisica\" WHERE id = ?";

        try {
            con = ConexaoBanco.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setProfissao(rs.getString("profissao"));
                c.setEndereco(rs.getString("profissao"));
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

    public void alterar_pessoaFisica(int id, String nome, String profissao, String endereco, String telefone, String cpf) {

        String sql = "UPDATE public.\"Pessoa_fisica\" SET nome = ?, profissao = ?, endereco = ?, telefone = ?, cpf = ? WHERE id = ?";

        try {
            con = ConexaoBanco.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, nome);
            stmt.setString(2, profissao);
            stmt.setString(3, endereco);
            stmt.setString(4, telefone);
            stmt.setString(5, cpf);
            stmt.setInt(6, id);

            stmt.executeUpdate();

            System.out.println("\nPessoaFisica Editado no Banco de Dados\n");
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConexaoBanco.closeConnection(con);
        }
    }
    
}
