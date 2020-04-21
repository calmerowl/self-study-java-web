package pers.calmerowl.javaweb.demos.httpservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequestDispatcher")
public class RequestDispatcher extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("请求转发器get方式来了...");
        //存储数据到request域中
        req.setAttribute("msg","msg-content of doGet");
        //转发到DoGetApp Servlet进行处理
        req.getRequestDispatcher("/DoGetApp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("请求转发器post方式来了...");
        //存储数据到request域中
        req.setAttribute("msg","msg-content of doPost");
        //转发到DoPostApp Servlet进行处理
        req.getRequestDispatcher("/DoPostApp").forward(req,resp);
    }
}
