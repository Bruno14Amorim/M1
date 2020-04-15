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
import model.Departamento;

/**
 *
 * @author bruno
 */
public class DepartamentoDAO {

    private Connection con = null;

    public DepartamentoDAO() {
        con = ConexaoBanco.getConnection();
    }

    public boolean add_departamento(Departamento c) {

        String sql = "INSERT INTO public.\"Departamento\" (descricao) VALUES (?)";

        try {
            con = ConexaoBanco.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, c.getDescricao());

            stmt.execute();

            System.out.println("\nDepartamento Adicionado no Banco de Dados\n");
            return true;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return false;
        } finally {
            ConexaoBanco.closeConnection(con);
        }

    }

    public ArrayList<Departamento> mostrar_departamento() {

        ArrayList<Departamento> retorno = new ArrayList<>();

        String sql = "SELECT * FROM public.\"Departamento\"";

        try {
            con = ConexaoBanco.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Departamento c = new Departamento();

                c.setId(rs.getInt("id"));
                c.setDescricao(rs.getString("descricao"));

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

    public boolean delete_departamento(int id) {

        String sql = "DELETE FROM public.\"Departamento\" WHERE id = ?";

        try {
            con = ConexaoBanco.getConnection();

            PreparedStatement stmt1 = con.prepareStatement(sql);

            stmt1.setInt(1, id);
            stmt1.executeUpdate();
            System.out.println("\nDepartamento Deletado do Banco de Dados\n");
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return false;
        } finally {
            ConexaoBanco.closeConnection(con);
        }
    }

    public Departamento achar_departamento(int id) {

        Departamento c = new Departamento();
        String sql = "SELECT * FROM public.\"Departamento\" WHERE id = ?";

        try {
            con = ConexaoBanco.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                c.setId(rs.getInt("id"));
                c.setDescricao(rs.getString("descricao"));

            }
            return c;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return null;
        } finally {
            ConexaoBanco.closeConnection(con);
        }
    }

    public void alterar_departamento(int id, String descricao) {

        String sql = "UPDATE public.\"Departamento\" SET descricao = ? WHERE id = ?";

        try {
            con = ConexaoBanco.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, descricao);          
            stmt.setInt(2, id);

            stmt.executeUpdate();

            System.out.println("\nDepartamento Editado no Banco de Dados\n");
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConexaoBanco.closeConnection(con);
        }
    }

}
