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
import model.Vendas;

/**
 *
 * @author bruno
 */
public class VendasDAO {
    
    private Connection con = null;

    public VendasDAO() {
        con = ConexaoBanco.getConnection();
    }

    public boolean add_venda (Vendas c) {

        String sql = "INSERT INTO public.\"Vendas\" (preco, id_funcionario, id_carro, \"id_pessoaFisica\") VALUES (?,?,?,?)";

        try {
            con = ConexaoBanco.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setFloat(1, c.getPreco());
            stmt.setInt(2, c.getId_funcionario());
            stmt.setInt(3, c.getId_carro());
            stmt.setInt(4, c.getId_pessoaFisica());

            stmt.execute();

            System.out.println("\nVenda Adicionado no Banco de Dados\n");
            return true;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return false;
        } finally {
            ConexaoBanco.closeConnection(con);
        }

    }

    public ArrayList<Vendas> mostrar_vendas() {

        ArrayList<Vendas> retorno = new ArrayList<>();

        String sql = "SELECT * FROM public.\"Vendas\"";

        try {
            con = ConexaoBanco.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Vendas c = new Vendas();

                c.setId(rs.getInt("id"));
                c.setId_carro(rs.getInt("id_carro"));
                c.setId_funcionario(rs.getInt("id_funcionario"));
                c.setId_pessoaFisica(rs.getInt("id_pessoaFisica"));
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

    public boolean delete_vendas (int id) {

        String sql = "DELETE FROM public.\"Vendas\" WHERE id = ?";

        try {
            con = ConexaoBanco.getConnection();

            PreparedStatement stmt1 = con.prepareStatement(sql);

            stmt1.setInt(1, id);
            stmt1.executeUpdate();
            System.out.println("\nVenda Deletado do Banco de Dados\n");
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return false;
        } finally {
            ConexaoBanco.closeConnection(con);
        }
    }

    public Vendas achar_vendas(int id) {

        Vendas c = new Vendas();
        String sql = "SELECT * FROM public.\"Vendas\" WHERE id = ?";

        try {
            con = ConexaoBanco.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                
                c.setId(rs.getInt("id"));
                c.setId_carro(rs.getInt("id_carro"));
                c.setId_funcionario(rs.getInt("id_funcionario"));
                c.setId_pessoaFisica(rs.getInt("id_pessoaFisica"));
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

    public void alterar_venda(int id, int id_carro, int id_funcionario, int id_pessoaFisica, float preco) {

        String sql = "UPDATE public.\"Vendas\" SET id_carro = ?, id_funcionario = ?, \"id_pessoaFisica\" = ?, preco = ? WHERE id = ?";

        try {
            con = ConexaoBanco.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id_carro);
            stmt.setInt(2, id_funcionario);
            stmt.setInt(3, id_pessoaFisica);
            stmt.setFloat(4, preco);
            stmt.setInt(5, id);

            stmt.executeUpdate();

            System.out.println("\nVenda Editado no Banco de Dados\n");
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConexaoBanco.closeConnection(con);
        }
    }
    
}
