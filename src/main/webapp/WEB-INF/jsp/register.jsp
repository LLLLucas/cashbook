<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/28
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>注册页面</title>


</head>
<body style="text-align:center;">

<form action="register" method="post">



    <input id="userName" name="userName" placeholder="手机/会员名/邮箱" type="text"><br/>
    <input id="password" name="password" type="password" placeholder="密码" ><br/><br/><br/><br/>
    <button type="submit">注册</button><br/>
    <span><font color="#a52a2a">${msg}</font></span>
</form>

</body>
</html>
