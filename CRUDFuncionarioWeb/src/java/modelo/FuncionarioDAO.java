/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gerson Risso
 */
public class FuncionarioDAO {

    final private String URL = "jdbc:mysql://localhost:3306/bd";
    final private String USER = "root";
    final private String PASSWORD = "";
    private Connection con;
    private PreparedStatement st;
    private ResultSet rs;

    public void conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão sucesso!!");
        } catch (SQLException e) {
            System.out.println("Falha Conexão: " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("Erro de conexão: " + e);
        }
    }

    public void desconectar() {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("Falha ao fechar!" + e);
        }
    }

    public int inserir(Funcionario f) {
        try {
            String comando = "INSERT INTO `funcionario` (`nome`,`cargo`,`salario`) VALUES(?,?,?)";
            st = con.prepareStatement(comando);
            st.setString(1, f.getNome());
            st.setString(2, f.getCargo());
            st.setFloat(3, f.getSalario());
            st.execute();
            System.out.println("Inserido com sucesso!");
            return 0;
        } catch (SQLException e) {
            System.out.println("Falha ao Inserir!" + e);
            return 1;
        }
    }

    public void consultarID(int id) {
        try {
            String comando = "SELECT * FROM `funcionario` WHERE id=" + id;
            st = con.prepareStatement(comando);
            rs = st.executeQuery();
            if (rs.next()) {
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Cargo: " + rs.getString("cargo"));
                System.out.println("Salário: " + rs.getFloat("salario"));
            } else {
                System.out.println("Não tem funcionário!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar:" + e);
        }
    }

    public List listar() {
        try {
            List<Funcionario> lista = new ArrayList<>();
            String comando = "SELECT * FROM `funcionario` ORDER BY `nome`";
            st = con.prepareStatement(comando);
            rs = st.executeQuery();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setCargo(rs.getString("cargo"));
                f.setSalario(rs.getFloat("salario"));
                lista.add(f);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }
        return null;
    }

    public void deletar(int id) {
        try {
            String comando = "SELECT * FROM `funcionario` WHERE id ='" + id + "'";
            st = con.prepareStatement(comando);
            rs = st.executeQuery();
            if (rs.next()) {
                try {
                    String comando2 = "DELETE FROM `funcionario` WHERE `id` = '" + id + "'";
                    st = con.prepareStatement(comando2);
                    st.execute();
                    System.out.println("Deletado com sucesso!");
                } catch (SQLException e) {
                    System.out.println("Falha ao deletar!" + e);
                }
            } else {
                System.out.println("ID não cadatsro no sistema!");
            }
        } catch (SQLException e) {
            System.out.println("Não encontrado " + e);
        }
    }

    public void atualizar(int id, float salario) {
        try {
            String comando = "SELECT * FROM `funcionario` WHERE id ='" + id + "'";
            st = con.prepareStatement(comando);
            rs = st.executeQuery();
            if (rs.next()) {
                try {
                    String comando2 = "UPDATE `funcionario` SET `salario` = ? WHERE `ID` = ?";
                    st = con.prepareStatement(comando2);
                    st.setFloat(1, salario);
                    st.setInt(2, id);
                    st.executeUpdate();
                    System.out.println("Atualizado com sucesso!");
                } catch (SQLException e) {
                    System.out.println("Falha na inserção dos dados!" + e);
                }
            } else {
                System.out.println("ID não cadastradono sistema!");
            }
        } catch (SQLException e) {
            System.out.println("Não encontrado " + e);
        }
    }
}
