
import java.sql.Connection;
import java.sql.*;

public class Database {
    protected Connection con;

    public Database() {
        String jdbcURL = "jdbc:mysql://localhost/java";
        String jdbcUsername = "root";
        String jdbcPassword = "";
        try {
            con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi Kết Nối CSDL");
        }
    }
}