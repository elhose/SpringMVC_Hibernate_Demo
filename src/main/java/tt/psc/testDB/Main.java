package tt.psc.testDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        String user = "springstudent";
        String pass = "springstudent";
        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection connection = DriverManager.getConnection(jdbcUrl, user, pass)) {
            if (connection.isValid(100)){
                System.out.println(connection.getCatalog());
                System.out.println("XDDDD");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
