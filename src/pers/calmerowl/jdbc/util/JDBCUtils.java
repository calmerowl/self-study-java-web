package pers.calmerowl.jdbc.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
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
//    static {
//        //Driver方式
//        try {
//            //1.创建Properties集合类
//            Properties pro = new Properties();
//            //2.加载文件
//            //pro.load(new FileReader("src/jdbc.properties"));
//            pro.load(new FileReader(JDBCUtils.class.getClassLoader().getResource("jdbc.properties").getPath()));
//            //3.获取数据，赋值
//            url = pro.getProperty("url");
//            userName = pro.getProperty("username");
//            password = pro.getProperty("password");
//            driver = pro.getProperty("driver");
//            Class.forName(driver);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        }
    private static DataSource ds;
    //c3p0方式
    //ds = new ComboPooledDataSource();
    //Druid方式
    static {
        try {
            //1.加载配置文件
            Properties pro = new Properties();
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //2.获取连接池对象
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取连接
     *
     * @return 连接对象
     */
    public static Connection getConnection() throws SQLException {
//        //Driver方式
//        try {
//            return DriverManager.getConnection(url, userName, password);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
        //c3p0方式  或者 //druid方式
        return ds.getConnection();
    }

    /**
     * 释放资源
     */
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        close(stmt,conn);
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Statement stmt, Connection conn){
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
    }

    public static DataSource getDataSource(){
        return ds;
    }
}
