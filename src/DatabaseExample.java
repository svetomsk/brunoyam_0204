import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseExample {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
    }
}
