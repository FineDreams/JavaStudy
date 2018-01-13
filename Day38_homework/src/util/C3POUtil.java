package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class C3POUtil {

    // 得到一个数据源(连接池)
    private static DataSource dataSource = new ComboPooledDataSource();

    public static Connection getConnection() {

        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("服务器忙...");
        }
    }

    public static void release(ResultSet resultSet, Statement stmt, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            resultSet = null;
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection = null;
        }
    }
    public static void release(Connection connection){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection = null;
        }
    }
    public static void release(Connection connection, PreparedStatement preparedStatement){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection = null;
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            preparedStatement = null;
        }
    }
}
