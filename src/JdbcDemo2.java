import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo2 {
    @Test
    public void insert() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            String sql = "insert into users (id,name,password,email,birthday) values (4,'白虎神皇','123','bhsh@sina.com','1980-09-09')";
            int  num = st.executeUpdate(sql);
            if(num>0) {
                System.out.println("插入成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn, st, rs);
        }
    }

    @Test
    public void delete() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            String sql = "delete from users where id=3";
            int num = st.executeUpdate(sql);
            if(num>0) {
                System.out.println("删除成功");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn, st, rs);
        }
    }
}
