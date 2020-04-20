<%--
  Created by IntelliJ IDEA.
  User: zhoumingqiang
  Date: 2020/4/20
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HttpServlet doPost</title>
</head>
<body>
    <form action="/self-study/DoPostApp" method="post">
        用户名:<input type="text" name="username">
        <br>密码:<input type="password" name="password">
        <br>性别:<input type="radio" name="gender" value="male">男<input type="radio" name="gender" value="female">女
        <br>爱好:<input type="checkbox" name="favorite" value="study">学习<input type="checkbox" name="favorite" value="game">游戏<input type="checkbox" name="favorite" value="basketball">篮球
        <br><input type="submit" value="注册">
    </form>
</body>
</html>
