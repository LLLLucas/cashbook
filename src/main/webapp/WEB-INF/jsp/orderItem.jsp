<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/1
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table
        {
            border-collapse:collapse;
        }

        table, td, th
        {
            border:1px solid black;
        }

    </style>
</head>
<body style="text-align:center;">
记账页面
<form action="do_orderItem?cid=${cid}&&userName=${userName}" method="post">
    <input name="money">
    <button type="submit">记账</button>


</form>
</body>
</html>
