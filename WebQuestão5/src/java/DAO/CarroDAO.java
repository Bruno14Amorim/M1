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
import model.Carro;

/**
 *
 * @author bruno
 */
public class CarroDAO {

    private Connection con = null;

    public CarroDAO() {
        con = ConexaoBanco.getConnection();
    }

    public boolean add_carro(Carro c) {

        String sql = "INSERT INTO public.\"Carro\" (modelo, cor, ano, preco) VALUES (?, ?, ?, ?)";

        try {
            con = ConexaoBanco.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, c.getModelo());
            stmt.setString(2, c.getCor());
            stmt.setInt(3, c.getAno());
            stmt.setFloat(4, c.getPreco());

            stmt.execute();

            System.out.println("\nCarro Adicionado no Banco de Dados\n");
            return true;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return false;
        } finally {
            ConexaoBanco.closeConnection(con);
        }

    }

    public ArrayList<Carro> mostrar_carro() {

        ArrayList<Carro> retorno = new ArrayList<>();

        String sql = "SELECT * FROM public.\"Carro\"";

        try {
            con = ConexaoBanco.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Carro c = new Carro();

                c.setId(rs.getInt("id"));
                c.setAno(rs.getInt("ano"));
                c.setModelo(rs.getString("modelo"));
                c.setCor(rs.getString("cor"));
                c.setPreco(rs.getFloat("preco"));

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

    public boolean delete_carro(int id) {

        String sql = "DELETE FROM public.\"Carro\" WHERE id = ?";

        try {
            con = ConexaoBanco.getConnection();

            PreparedStatement stmt1 = con.prepareStatement(sql);

            stmt1.setInt(1, id);
            stmt1.executeUpdate();
            System.out.println("\nCarro Deletado do Banco de Dados\n");
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return false;
        } finally {
            ConexaoBanco.closeConnection(con);
        }
    }

    public Carro achar_carro(int id) {

        Carro c = new Carro();
        String sql = "SELECT * FROM public.\"Carro\" WHERE id = ?";

        try {
            con = ConexaoBanco.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                c.setId(rs.getInt("id"));
                c.setAno(rs.getInt("ano"));
                c.setModelo(rs.getString("modelo"));
                c.setCor(rs.getString("cor"));
                c.setPreco(rs.getFloat("preco"));
            }
            return c;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return null;
        } finally {
            ConexaoBanco.closeConnection(con);
        }
    }

    public void alterar_carro(int id, String cor, String modelo, int ano, float preco) {

        String sql = "UPDATE public.\"Carro\" SET modelo = ?, ano = ?, cor = ?, preco = ? WHERE id = ?";

        try {
            con = ConexaoBanco.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, modelo);
            stmt.setInt(2, ano);
            stmt.setString(3, cor);
            stmt.setFloat(4, preco);
            stmt.setInt(5, id);

            stmt.executeUpdate();

            System.out.println("\nCarro Editado no Banco de Dados\n");
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConexaoBanco.closeConnection(con);
        }
    }
}
