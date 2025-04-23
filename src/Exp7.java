import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exp7 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/2b", "root", "bavish82");
        System.out.println("Connection established");

        Statement statement = connection.createStatement();
        System.out.println("Database selected");

        ResultSet resultSet = statement.executeQuery("SELECT * FROM department");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
        }
        System.out.println("Data fetched");

        statement.executeUpdate("UPDATE department SET Location='USA' WHERE DepartmentID=1");
        System.out.println("Data updated");

        ResultSet updatedResultSet = statement.executeQuery("SELECT * FROM department");
        while (updatedResultSet.next()) {
            System.out.println(updatedResultSet.getInt(1) + " " + updatedResultSet.getString(2) + " " + updatedResultSet.getString(3));
        }

        statement.executeUpdate("DELETE FROM department WHERE Location='USA'");
        System.out.println("Data deleted");

        connection.close();
    }
}
