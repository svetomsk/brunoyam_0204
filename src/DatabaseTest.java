import java.sql.*;

public class DatabaseTest {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:sqlite:Z:/Общая преподавателей/Милых Светозар/brunoyam_0204/database.db";

        // create database file and connection
        Connection conn = DriverManager.getConnection(url);
        if (conn != null) {
            System.out.println("Connection esteblished");
        } else {
            System.exit(0);
        }

        // create table if necessary
        String createTable =
                "CREATE TABLE IF NOT EXISTS clients ( \n " +
                        " id integer PRIMARY KEY AUTOINCREMENT,\n" +
                        " name text NOT NULL,\n" +
                        " age integer\n);";

        Statement statement = conn.createStatement();
        statement.execute(createTable);

        // insert values
        String insertValue =
                "INSERT INTO clients (name, age) VALUES (\"Ivan\", 13);";
//        statement.execute(insertValue);

        String updateValue = "UPDATE clients SET name = 'Kirill', age = 26 WHERE name = 'Ivan'";
        statement.execute(updateValue);

        // select values
        String selectValues = "SELECT * FROM clients;";
        ResultSet results = statement.executeQuery(selectValues);
        final int NAME_COLUMN = 2;
        while (results.next()) {
            System.out.println("id = " + results.getInt("id"));
            System.out.println("name = " + results.getString(NAME_COLUMN));
            System.out.println("age = " + results.getInt("age"));
        }

        String deleteValue = "DELETE FROM clients WHERE id > 2";
        statement.execute(deleteValue);

        selectValues = "SELECT * FROM clients;";
        results = statement.executeQuery(selectValues);
//        final int NAME_COLUMN = 2;
        while (results.next()) {
            System.out.println("id = " + results.getInt("id"));
            System.out.println("name = " + results.getString(NAME_COLUMN));
            System.out.println("age = " + results.getInt("age"));
        }

        System.out.println("===");

        String name = "Svetozar";
        int age = 24;
        String preparedInsert = "INSERT INTO clients (name, age) VALUES (?, ?)";
        PreparedStatement preparedStatement = conn.prepareStatement(preparedInsert);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, age);
        preparedStatement.execute();

        selectValues = "SELECT * FROM clients;";
        results = statement.executeQuery(selectValues);
//        final int NAME_COLUMN = 2;
        while (results.next()) {
            System.out.println("id = " + results.getInt("id"));
            System.out.println("name = " + results.getString(NAME_COLUMN));
            System.out.println("age = " + results.getInt("age"));
        }
    }
}
