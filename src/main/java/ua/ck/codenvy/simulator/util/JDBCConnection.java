package ua.ck.codenvy.simulator.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by sergey on 24.03.14.
 */
public class JDBCConnection {
    private static final String USER = "root";
    private static final String PASSWORD= "12345";
    private static final String URL = "jdbc:mysql://localhost:3306/employees";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
