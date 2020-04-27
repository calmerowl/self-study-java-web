package pers.calmerowl.javaweb.apps.test;

import org.junit.Test;
import pers.calmerowl.javaweb.apps.dao.UserDao;
import pers.calmerowl.javaweb.apps.domain.User;

import java.sql.SQLException;

public class UserDaoTest {
    @Test
    public void testLogin() throws SQLException {
        User loginUser =new User();
        loginUser.setUsername("张三");
        loginUser.setPassword("666");

        UserDao dao = new UserDao();
        User user = dao.login(loginUser);

        System.out.println(user);
    }
}
