import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        try {
            connection = new ConnectionFactory().getConnection();
            System.out.println("Conectado!");
            String sql = "insert into contatos" + " (nome,email,endereco,dataNascimento)" + " values (?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, "Caelum");
            stmt.setString(2, "contato@caelum.com.br");
            stmt.setString(3, "R. Vergueiro 3185 cj57");
            stmt.setDate(4, new java.sql.Date(System.currentTimeMillis()));

            stmt.execute();
            stmt.close();
            System.out.println("Gravado!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }
    }


}
