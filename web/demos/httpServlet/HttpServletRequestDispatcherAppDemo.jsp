<%--
  Created by IntelliJ IDEA.
  User: zhoumingqiang
  Date: 2020/4/21
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HttpServlet RequestDispatcher</title>
</head>
<body>
    <form action="/self-study/RequestDispatcher" method="get">
        用户名:<input type="text" name="username">
        <br><input type="submit" value="get请求注册">
    </form>
    <form action="/self-study/RequestDispatcher" method="post">
        用户名:<input type="text" name="username">
        <br><input type="submit" value="post请求注册">
    </form>
</body>
</html>
