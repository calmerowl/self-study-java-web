package pers.calmerowl.jdbc.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String url;
    private static String userName;
    private static String password;
    private static String driver;

    /**
     * 资源文件的读取，只读取一次，使用静态代码块即可
     */
    static {
        //读取资源文件，获取值
        try {
            //1.创建Properties集合类
            Properties pro = new Properties();
            //2.加载文件
            //pro.load(new FileReader("src/jdbc.properties"));
            pro.load(new FileReader(JDBCUtils.class.getClassLoader().getResource("jdbc.properties").getPath()));
            //3.获取数据，赋值
            url = pro.getProperty("url");
            userName = pro.getProperty("username");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取连接
     *
     * @return 连接对象
     */
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 释放资源
     */
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
