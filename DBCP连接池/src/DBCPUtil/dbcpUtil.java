package DBCPUtil;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class dbcpUtil {
    static {
        Properties properties=new Properties();
        ClassLoader classLoader = dbcpUtil.class.getClassLoader();
        InputStream asStream = classLoader.getResourceAsStream("dbcp.properties");
        try {
            properties.load(asStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static DataSource dataSource;

    public static Connection getConn(){
        Connection connection=null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
     return connection;
    }
}
