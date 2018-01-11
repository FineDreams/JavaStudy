import DBCPUtil.dbcpUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class T {
    @Test
    public void t1() throws SQLException {
        Connection conn = dbcpUtil.getConn();
        System.out.println(conn);
        conn.close();
    }
    @Test
    public void t2() throws SQLException {
        for (int i = 0; i <60 ; i++) {
            Connection conn = dbcpUtil.getConn();
            System.out.println(conn+"--"+i);
            conn.close();
        }
    }
    @Test
    public void t3() throws SQLException {
        for (int i = 0; i <17 ; i++) {
            Connection conn = dbcpUtil.getConn();
            System.out.println(conn+"---"+i);
            conn.close();
        }
    }

    @Test
    public void t4() throws SQLException {
        for (int i = 0; i < 1000; i++) {
            Connection conn = dbcpUtil.getConn();
            System.out.println(conn + "--" + i);
            conn.close();
        }
    }

    @Test
    public void t5(){
        for (int i = 0; i < 20; i++) {
            Connection conn = dbcpUtil.getConn();
            System.out.println(conn + "--" + i);
        }
    }


}
