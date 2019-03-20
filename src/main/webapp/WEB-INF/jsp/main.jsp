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
<link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
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
          <td><a href="#" onclick="addOrderItem(${c.id},${sessionScope.user.userName})"  data-toggle="modal" data-target="#myModal2"><img src="img\click.png"></a>
             <%-- <a href="orderItem?cid=${c.id}&&userName=${sessionScope.user.userName}"><img src="img\click.png">--%>
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
            <td><a href="#" onclick="editOrderItem(${o.id})"  data-toggle="modal" data-target="#myModal">修改</a>
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
<script type="text/javascript">

    function addOrderItem(id,userName) {
        $.ajax({
            type: "get",
            url: "orderItem2",
            data: {"cid": id,"userName":userName},
            success: function (data) {
                $("#cid2").val(data.categoryId);
                $("#userName2").val(data.userName);

            }
        });
    }
    function parseDateTime(date)
    {
        var date = new Date(date);
        var Y = date.getFullYear() + '-';
        var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
        var D = date.getDate() + '';

        return Y+M+D;
    }


    function editOrderItem(id){
        $.ajax({
            type:"get",
            url:"update2",
            data:{"id":id},
            success:function(data) {  //Customer对象json
            var date=parseDateTime(data.date);
            $("#id").val(data.id);
            $("#userName").val(data.userName);
            $("#userId").val(data.userId);
            $("#date").val(date);
            $("#cateName").val(data.cateName);
            $("#categoryId").val(data.categortId);

            $("#money").val(data.money);

            },
            error:function (data) {
                alert(JSON.stringify(data));
            }

        });
    }
</script>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title">修改页面</h4>
            </div>
            <div class="modal-body">
                <form action="edit" method="post">
                    <input type="hidden" name="id" id="id" ><br>
                    用户名：<input type="text" name="userName" id="userName"  disabled="disabled"><br>
                    <input type="hidden" name="userId" id="userId" ><br>
                    日期：<input type="text" name="date"  id="date"   disabled="disabled"><br>
                    <input type="hidden" name="dateId" id="dateId" ><br>
                原来类别名称： <input type="text" id="cateName"><br>



              选择新的记账花费类型：
                    <select name="categoryId"  id="categoryId">
                        <c:forEach items="${cs}" var="c">
                            <option value="${c.id}" <%--<c:if test="${c.id==categoryId}">selected</c:if>--%>>${c.name}</option>
                        </c:forEach>
                    </select><br>
                    花费金额：<input type="number" name="money" id="money" >
                    <button data-dismiss="modal" class="btn btn-primary" type="button">关闭</button>
                    <input type="submit" value="修改" class="btn btn-primary">
                </form>


            </div>

        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>

<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title">记账界面</h4>
            </div>
            <div class="modal-body">
                <form action="do_orderItem" method="post">
                    金额：<input type="number" name="money" id="money2">
                    <input type="hidden" name="userName" id="userName2">
                    <input type="hidden" name="cid" id="cid2"><br><br>
                    <button data-dismiss="modal" class="btn btn-primary" type="button">关闭</button>
                    <input type="submit" value="添加" class="btn btn-primary">
                </form>
            </div>

        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>


</body>
</html>