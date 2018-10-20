package aluno;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    

    final private String URL = "jdbc:mysql://localhost:3306/aluno";
    final private String USER = "root";
    final private String PASSWORD = "";
    private Connection con;
    private PreparedStatement st;
    private ResultSet rs;

    public void conectar() {

        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão com sucesso!");

        } catch (SQLException e) {
            System.out.println("Falha na conexão!" + e);

        }
    }

    public void desconectar() {

        try {
            con.close();
            System.out.println("Desconectado com sucesso");
        } catch (SQLException e) {
            System.out.println("Falha ao fechar!" + e);
        }
    }

    public void inserir(Aluno a) {
        try {
            String comando = "INSERT INTO `aluno`(`nome`,`curso`) VALUES(?,?)";
            st = con.prepareStatement(comando);
            st.setString(1, a.getNome());
            st.setString(2, a.getCurso());
            st.execute();
            System.out.println("Inserido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Falha na inserção dos dados!" + e);
        }

    }

    public void consultar(long ra) {
        try {
            String comando = "SELECT * FROM `aluno` WHERE ra ='" + ra + "'";
            st = con.prepareStatement(comando);
            rs = st.executeQuery();
            if (rs.next()) {
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Curso: " + rs.getString("curso"));
            } else {
                System.out.println("Não tem registro!");
            }
        } catch (SQLException e) {
            System.out.println("Não encontrado " + e);
        }

    }

    public List listar() {
        try {
            List<Aluno> lista = new ArrayList<>();
            String comando = "SELECT * FROM `aluno` ORDER BY `nome`";
            st = con.prepareStatement(comando);
            rs = st.executeQuery();
            while (rs.next()) {
                Aluno a = new Aluno();
                a.setRa(rs.getLong("ra"));
                a.setNome(rs.getString("nome"));
                a.setCurso(rs.getString("curso"));
                lista.add(a);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }
        return null;
    }

    public void deletar(long ra) {
        try {
            String comando = "SELECT * FROM `aluno` WHERE ra ='" + ra + "'";
            st = con.prepareStatement(comando);
            rs = st.executeQuery();
            if (rs.next()) {
                try {
                    String comando2 = "DELETE FROM `aluno` WHERE `ra` = '" + ra + "'";
                    st = con.prepareStatement(comando2);
                    st.execute();
                    System.out.println("Deletado com sucesso!");
                } catch (SQLException e) {
                    System.out.println("Falha ao deletar!" + e);
                }
            } else {
                System.out.println("RA não cadatsro no sistema!");
            }
        } catch (SQLException e) {
            System.out.println("Não encontrado " + e);
        }
    }

    public void atualizar(long ra, String curso) {
        try {
            String comando = "SELECT * FROM `aluno` WHERE ra ='" + ra + "'";
            st = con.prepareStatement(comando);
            rs = st.executeQuery();
            if (rs.next()) {
                try {
                    String comando2 = "UPDATE `aluno` SET `curso` = ? WHERE `ra` = ?";
                    st = con.prepareStatement(comando2);
                    st.setString(1, curso);
                    st.setLong(2, ra);
                    st.executeUpdate();
                    System.out.println("Atualizado com sucesso!");
                } catch (SQLException e) {
                    System.out.println("Falha na inserção dos dados!" + e);
                }
            } else {
                System.out.println("RA não cadastradono sistema!");
            }
        } catch (SQLException e) {
            System.out.println("Não encontrado " + e);
        }
    }
}
