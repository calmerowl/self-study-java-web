package pers.calmerowl.javaweb.apps.dao;

import pers.calmerowl.javaweb.apps.domain.User;
import pers.calmerowl.jdbc.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 操作数据库中User表的类
 */
public class UserDao {

    //声明JDBCTemplate
    //private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 登录方法
     * @param loginUser 只有用户名和密码
     * @return user包含用户全部数据
     */
    public User login(User loginUser) throws SQLException {
        User user=null;
        //1.编写sql
        String sql = "select * from user where username = ? and password = ?";
        //2.获取连接对象
        Connection conn = JDBCUtils.getConnection();
        //3.获取操作Sql的prePareStatement对象
        //user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),loginUser.getUsername(),loginUser.getPassword());
        PreparedStatement preStmt = conn.prepareStatement(sql);
        //4.prepareStatement参数数据赋值
        preStmt.setString(1,loginUser.getUsername());
        preStmt.setString(2,loginUser.getPassword());
        //5.调用query方法
        ResultSet rs = preStmt.executeQuery();
        if (rs.next()){
            user = loginUser;
        }
        JDBCUtils.close(rs,preStmt,conn);
        return user;
    }
}
