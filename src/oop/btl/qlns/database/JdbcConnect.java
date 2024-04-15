package oop.btl.qlns.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnect {
    private static String url = "jdbc:mysql://localhost:3306/quan_li_nhan_su";
    private static String password = "1234";
    private static String username = "root";

    public static Connection getJdbcConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        try {
            // đăng ký Driver với DriverManager
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            // Các thông số
            String url = "jdbc:mySQL://localhost:3306/quan_li_nhan_su";
            String username = "root";
            String password = "1234";

            // tạo kết nối
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}