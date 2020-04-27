package pers.calmerowl.jdbc.demos.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.util.Properties;

public class DruidImp {
    public static void main(String[] args) throws Exception {
        //1.加载配置文件
        Properties pro =new Properties();
        pro.load(new FileReader(DruidImp.class.getClassLoader().getResource("druid.properties").getPath()));
        //2.获取连接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        //3.获取连接
        Connection conn = ds.getConnection();

        System.out.println(conn);
    }
}
