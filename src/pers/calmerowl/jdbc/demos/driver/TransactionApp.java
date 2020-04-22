package pers.calmerowl.jdbc.demos.driver;

import pers.calmerowl.jdbc.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class TransactionApp {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement preStmt = null;
        try {
            //1.获取连接
            conn = JDBCUtils.getConnection();
            //开启事务
            conn.setAutoCommit(false);
            //2.定义SQL
            String sql = "update user set password = ? where username = ?";
            //3.获取操作Sql的PrePareStatement对象
            preStmt = conn.prepareStatement(sql);
            //4.PrepareStatement参数数据赋值
            preStmt.setString(1, "999");
            preStmt.setString(2, "李四");
            //5.执行SQL
            int count = preStmt.executeUpdate();
            //制造异常~~~~
            int i = 3 / 0;
            //提交事务
            conn.commit();
            System.out.println(count);
        } catch (Exception e) {
            //事务回滚
            try {
                if(conn!=null){
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            //6.关闭资源
            JDBCUtils.close(null, preStmt, conn);
        }
    }
}
