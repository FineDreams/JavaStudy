package dao;

import domain.PageBean;
import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import service.ShowService;
import util.C3POUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDao {

    public List<User> queryByGroup(int begin,String uname, String gender,String score,String age){
        Connection connection = C3POUtil.getConnection();
        PageBean pageBean=new PageBean();
        String[] pageInfo={"uname","gender","score","age"};
        String[] pageValue={uname,gender,score,age};


        StringBuilder sb=new StringBuilder();
        sb.append(" select * from table_user ");

        if ((uname!=null&&uname!="")||(gender!=null&&gender!="")||(score!=null&&score!="")||(age!=null&&age!="")){
            sb.append(" where ");
            Boolean isNeedAnd=false;
            for (int i = 0; i < pageValue.length; i++) {
                if (pageValue[i]!=null&&pageValue[i]!=""){
                    if (isNeedAnd){
                        sb.append(" and ");
                    }
                    sb.append(pageInfo[i]+"='"+pageValue[i]+"'");
                    isNeedAnd=true;
                }
            }
        }
        sb.append(" limit "+begin+",10");
        try {
            List<User> users = new QueryRunner().query(connection, sb.toString(), new BeanListHandler<User>(User.class));
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3POUtil.release(connection);
        }
        return null;
    }

    public int queryCount(String uname, String gender,String score,String age){
        Connection connection = C3POUtil.getConnection();
        PageBean pageBean=new PageBean();
        String[] pageInfo={"uname","gender","score","age"};
        String[] pageValue={uname,gender,score,age};


        StringBuilder sb=new StringBuilder();
        sb.append(" select count(*) from table_user ");

        if ((uname!=null&&uname!="")||(gender!=null&&gender!="")||(score!=null&&score!="")||(age!=null&&age!="")){
            sb.append(" where ");
            Boolean isNeedAnd=false;
            for (int i = 0; i < pageValue.length; i++) {
                if (pageValue[i]!=null&&pageValue[i]!=""){
                    if (isNeedAnd){
                        sb.append(" and ");
                    }
                    sb.append(pageInfo[i]+"='"+pageValue[i]+"'");
                    isNeedAnd=true;
                }
            }
        }
//        sb.append(" limit "+begin+",10");
        try {
            long query = new QueryRunner().query(connection, sb.toString(), new ScalarHandler<Long>());

            return (int) query;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3POUtil.release(connection);
        }
        return 0;
    }

}
