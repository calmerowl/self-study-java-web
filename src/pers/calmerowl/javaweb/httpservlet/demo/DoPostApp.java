package pers.calmerowl.javaweb.httpservlet.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/DoPostApp")
public class DoPostApp extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //----请求行相关------------------------------------------------------------------------
        System.out.println("----请求行相关------------------------------------------------------------------------");
        //获取url
        System.out.println(req.getRequestURL());
        //获取协议及版本
        System.out.println(req.getProtocol());
        //获取请求方式
        System.out.println(req.getMethod());
        //获取uri
        System.out.println(req.getRequestURI());
        //获取虚拟路径
        System.out.println(req.getContextPath());
        //获取Servlet路径
        System.out.println(req.getServletPath());
        //获取客户机的IP地址
        System.out.println(req.getRemoteAddr());
        //----请求头相关--------------------------------------------------------------------------
        System.out.println("----请求头相关--------------------------------------------------------------------------");
        //获取所有的头信息
        Enumeration<String> headerNames = req.getHeaderNames();
        String headerName;
        String headerValue;
        while (headerNames.hasMoreElements()) {
            headerName = headerNames.nextElement();
            headerValue = req.getHeader(headerName);
            System.out.println(headerName + ":" + headerValue);
        }
        //使用user-agent头信息
        String useragent = req.getHeader("user-agent");
        if (useragent.contains("Edge")) {
            System.out.println("使用Edge浏览器访问的");
        } else if (useragent.contains("Chrome")) {
            System.out.println("使用Chrome浏览器访问的");
        } else if (useragent.contains("FireFox")) {
            System.out.println("使用FireFox浏览器访问的");
        }
        //使用referer头信息
        String referer = req.getHeader("referer");
        if (null != referer) {
            if (referer.contains("/self-study/HttpServletDoPostAppDemo.jsp")) {
                System.out.println("正常路径来的，热烈欢迎!");
            } else {
                System.out.println("盗链过来的,请使用正常路径访问!");
            }
        }
        //----请求体相关--------------------------------------------------------------------------
        System.out.println("----请求体相关--------------------------------------------------------------------------");
        //中文乱码问题处理
        req.setCharacterEncoding("utf-8");
//        //获取请求体注意事项，使用流读和getParameter方式是有冲突的，不能同时使用
//        //获取请求体数据
//        BufferedReader br = req.getReader();
//        String line = null;
//        while ((line = br.readLine()) != null) {
//            System.out.println(line);
//        }
        //获取所有参数-method3,使用map集合
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> keySet = parameterMap.keySet();
        String[] values;
        String outString;
        for (String key : keySet) {
            outString=key+":";
            values=req.getParameterValues(key);
            for (String value:values){
                outString+=value+";";
            }
            System.out.println(outString);
        }
    }
}
