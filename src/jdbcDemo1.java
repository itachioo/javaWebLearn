import java.sql.*;

public class jdbcDemo1 {
    private static String driver = null;
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbcStudy";
        String username = "root";
        String password = "123456";
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url,username,password);
        Statement st = conn.createStatement();
        String sql = "select id,name,password,email,birthday from users";
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()) {
            System.out.println("id=" + rs.getObject("id"));
            System.out.println("name=" + rs.getObject("name"));
            System.out.println("password=" + rs.getObject("password"));
            System.out.println("email=" + rs.getObject("email"));
            System.out.println("birthday=" + rs.getObject("birthday"));
        }
        rs.close();
        st.close();
        conn.close();

    }
}
