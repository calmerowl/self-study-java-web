package pers.calmerowl.jdbc.demos.driver;

import pers.calmerowl.jdbc.util.JDBCUtils;

import java.sql.*;

public class DriverImp {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.导入驱动jar包
        //2.注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //3.获取数据库连接对象
        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaweb", "root", "root");
        Connection conn = JDBCUtils.getConnection();
        //4.定义sql语句
        String sql = "update user set password = 666 where id = 1";
        String sqlQuery = "select * from user";
        String sqlPreStmt = "select * from user where username= ?";
        //5.获取执行sql的对象Statement
        Statement stmt = conn.createStatement();
        PreparedStatement preStmt = conn.prepareStatement(sqlPreStmt);
        preStmt.setString(1,"李四");
        //6.执行sql
        int count = stmt.executeUpdate(sql);//返回的是影响的行数
        ResultSet rs = stmt.executeQuery(sqlQuery);
        ResultSet rsPre=preStmt.executeQuery();
        //7.处理结果输出
        System.out.println(count);
//        while(rs.next()){//游标移到下一行
//            System.out.println("ResultSet:" + rs.getInt(1) + "," + rs.getString("username") + "," + rs.getString(3));
//         }
        while(rsPre.next()){//游标移到下一行
            System.out.println("ResultSet:" + rsPre.getInt(1) + "," + rsPre.getString("username") + "," + rsPre.getString(3));
        }
        //8.释放资源
        //stmt.close();
        //conn.close();
        JDBCUtils.close(rsPre,preStmt,conn);
    }
}
