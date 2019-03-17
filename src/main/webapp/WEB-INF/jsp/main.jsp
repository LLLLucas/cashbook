<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/28
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html xmlns:th="http://www.thymeleaf.org">


<script src="http://how2j.cn/study/jquery.min.js"></script>
<head>
    <title>主頁面</title>
        <style type="text/css">
            .thinkcss-left{ float:right; border:1px solid #F00}
                              table
                              {
                                  border-collapse:collapse;
                              }
    </style>
</head>
<body style="text-align:center;">
<span class="thinkcss-left"> <font color="red">用户名：${sessionScope.user.userName}</font></span>
<table border="0" align="center"><thead>
<tr>
    <td width="80">ID</td>
    <td width="80"></td>
    <td width="80">类别</td>
    <td width="80">操作</td>
</tr>
</thead>
    <c:forEach items="${cs}" var="c">
        <tr>

            <td>${c.id}</td>
            <td><img src="${c.imgName}"></td>
            <td >${c.name}</td>
          <td>
              <a href="orderItem?cid=${c.id}&&userName=${sessionScope.user.userName}"><img src="img\click.png">
                  </a>
          </td>
        </tr>
    </c:forEach>
</table>
<table border="1" align="center"><thead>
<tr>
    <td>ID</td>
    <td>用户名</td>
    <td>类型</td>
    <td width="300">日期</td>
    <td>金额</td>
    <td>操作</td>
    <td></td>
</tr>
</thead>
    <c:forEach items="${page.list}" var="o" varStatus="st">
        <tr>
            <td>${o.id}</td>
            <td>${o.userName}</td>
            <td>${o.cateName}</td>
            <td>${o.date}</td>
            <td>${o.money}</td>
            <td><a href="update?id=${o.id}"   >编辑</a>
            </td>
            <td><a href="delete?id=${o.id}"  onclick = ' return confirm("确认要删除吗？"); '>删除</a></td>

        </tr>
    </c:forEach>
</table>
<br>
<div>
    <a href="?start=1">[首页]</a>
    <a href="?start=${page.pageNum-1}">[上一页]</a>
    <a href="?start=${page.pageNum+1}">[下一页]</a>
    <a href="?start=${page.pages}">[末页]</a>
    <span>${page.pages}</span>


</div>
<h1><font color="red">total:${sum}</font> </h1>
</body>
</html>