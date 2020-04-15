package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoPostgres {

    private static Connection conexao;

    public ConexaoPostgres() {
    }

    public boolean conecta(String ip) throws Exception {
        try {
            if (conexao != null && !conexao.isClosed()) {
                return true;
            }
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection(
                     "jdbc:postgresql://ec2-54-226-66-83.compute-1.amazonaws.com/control", "control", "cont987");
//                    "jdbc:postgresql://"+ip+"/mitra", "postgres", "123456");
            conexao.setAutoCommit(true);
            conexao.setTransactionIsolation(
                    Connection.TRANSACTION_READ_COMMITTED);
        } catch (ClassNotFoundException cnf) {
            throw new Exception("Driver não encontrado!");
        } catch (SQLException sql) {
            throw new Exception("Falha ocorrida: " + sql.getMessage());
        }
        return true;
    }

    public Connection getConexao() {
        return conexao;
    }

    public void fechar() throws Exception {
        try {
            if (conexao == null || conexao.isClosed()) {
                return;
            }
            conexao.close();
        } catch (SQLException sql) {
            throw new Exception("Falha ocorrida: " + sql.getMessage());
        }
    }

    public void confirmarTransacao() throws Exception {
        try {
            if (conexao == null || conexao.isClosed()) {
                return;
            }
            conexao.commit();
        } catch (SQLException sql) {
            throw new Exception("Falha ocorrida: " + sql.getMessage());
        }
    }

    public void cancelarTransacao() throws Exception {
        try {
            if (conexao == null || conexao.isClosed()) {
                return;
            }
            conexao.rollback();
        } catch (SQLException sql) {
            throw new Exception("Falha ocorrida: " + sql.getMessage());
        }
    }

    
}