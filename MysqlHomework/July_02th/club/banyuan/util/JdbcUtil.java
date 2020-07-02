package club.banyuan.util;


import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtil {

    private static String url;
    private static String userName;
    private static String pwd;

    static {
        Properties properties = new Properties();
        InputStream is = JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        url = properties.getProperty("url");
        userName = properties.getProperty("USERNAME");
        pwd = properties.getProperty("PASSWORD");
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, userName, pwd);
        return connection;
    }

    public static void close(Connection connection, Statement statement) throws SQLException {
        if (connection != null) {
            connection.close();
        }
        if (statement != null) {
            statement.close();
        }
    }

    public static void close(Connection connection, Statement statement, ResultSet rs) throws SQLException {
        if (connection != null) {
            connection.close();
        }
        if (statement!=null){
            statement.close();
        }
        if (rs!=null){
            rs.close();
        }
    }

}
