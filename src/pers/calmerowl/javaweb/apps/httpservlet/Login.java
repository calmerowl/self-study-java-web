package pers.calmerowl.javaweb.apps.httpservlet;

import org.apache.commons.beanutils.BeanUtils;
import pers.calmerowl.javaweb.apps.dao.UserDao;
import pers.calmerowl.javaweb.apps.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet("/Login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码
        req.setCharacterEncoding("utf-8");
//        //2.获取请求参数
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        //3.封装User对象
//        User loginUser = new User();
//        loginUser.setUsername(username);
//        loginUser.setPassword(password);
        //2获取所有请求参数
        Map<String , String[]> map = req.getParameterMap();
        //3.创建User对象
        User loginUser =new User();
        //3.1使用BeanUtils封装
        try {
            BeanUtils.populate(loginUser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //4.调用UserDao的login方法
        UserDao userDao = new UserDao();
        User user = null;
        try {
            user = userDao.login(loginUser);
            //5.判断user
            if (user == null){
                //登录失败
                //存储数据
                req.getRequestDispatcher("/FailLogin").forward(req,resp);
            }else{
                //登录成功
                //存储数据
                req.setAttribute("user",user);
                //转发
                req.getRequestDispatcher("/SuccessLogin").forward(req,resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println(user);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
