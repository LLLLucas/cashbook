<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/14
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>修改页面</title>
   <%-- <script>

        var select=document.getElementById("select");
        var cateId=document.getElementById("categoryId").value;
        alert(cateId);
        for(var i=0;i<select.length;i++){
            if(select.options[i].value==cateId){
                document.getElementById("select")[i].selected=true;
            }
        }

    </script>--%>
</head>
<body>
<div align="center">
<form action="edit" method="post">
<input type="hidden" name="id" value="${o.id}"><br>
用户名：<input type="text" name="userName" value="${o.userName}" disabled="disabled"><br>
    <input type="hidden" name="userId" value="${o.userId}"><br>
    日期<input type="text" name="date" value="${o.date}"  disabled="disabled"><br>
    <input type="hidden" name="dateId" value="${o.dateId}"><br>

    选择新的记账花费类型：
    <select name="categoryId">
<c:forEach items="${categories}" var="c">
    <option value="${c.id}" <c:if test="${c.id==o.categoryId}">selected</c:if>>${c.name}</option>
</c:forEach>
    </select><br>
    花费金额：<input type="number" name="money" value="${o.money}">
    <input type="submit" value="修改">
</form>
</div>
</body>
</html>
