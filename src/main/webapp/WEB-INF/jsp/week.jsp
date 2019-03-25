<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/24
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html xmlns:th="http://www.thymeleaf.org">


<script src="http://how2j.cn/study/jquery.min.js"></script>
<link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table class="table table-hover" border="1" align="center"><thead>
<tr>
    <td>ID</td>
    <td>用户名</td>
    <td>类型</td>
    <td width="300">日期</td>
    <td>金额</td>
    <td colspan="2">操作</td>
    <td></td>
</tr>
</thead>
    <c:forEach items="${page.list}" var="o" varStatus="st">
        <tr>
            <td>${o.id}</td>
            <td>${o.userName}</td>
            <td>${o.cateName}</td>
            <td>${o.shijian}</td>
            <td>${o.money}</td>
            <td><a href="#" onclick="editOrderItem(${o.id})"  data-toggle="modal" data-target="#myModal">修改</a>
            </td>
            <td><a href="delete?id=${o.id}"  onclick = ' return confirm("确认要删除吗？"); '>删除</a></td>

        </tr>
    </c:forEach>
</table>
<h1><font color="red">total:${sum}</font> </h1>
<a href="next_week_category?weekId=${weekId}">下周</a>
<a href="last_week_category?weekId=${weekId}">上周</a>


</body>
</html>
