/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author bruno
 */
public class ConexaoBanco {

    //Classe responsavel de abrir e fechar conexão do banco.
    private static final String DRIVER = "org.postgresql.Driver";

    private static final String URL = "jdbc:postgresql://localhost:5432/lojaCarro";

    private static final String USER = "postgres";
    private static final String PASS = "bruno";

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Erro: " + ex);
            return null;
        }
    }

    //Fecha conexão com o banco.
    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("Erro: " + ex);
            }
        }
    }

}
