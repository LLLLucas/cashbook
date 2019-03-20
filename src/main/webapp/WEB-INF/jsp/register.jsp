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

    <script src="http://how2j.cn/study/jquery.min.js"></script>
</head>
<body style="text-align:center;">
<script type="text/javascript">
    function check(){
        var userName=$("#userName").val();
        $.ajax({
           type:"get",
           url:"check" ,
            data:{"userName":userName},
            success:function(data){
               if(data){

                   $("#span").text("用户名可以使用");
                   $("#span").css("color","green");


                   return true;
               }else{
                   $("#span").text("用户名存在");
                   $("#span").css("color","red");




                   return false;
               }

            },
            error:function(data){
               alert("没吃过");
            }

        });
    }
    function register(){
        var userName=$("#userName").val();
        var password=$("#password").val();
        if(userName.length==0){
            $("#span").text("用户名为空");
            return false;

        }else if(password.length==0){
            $("#span").text("密码名为空");
            return false;
        }

        $.ajax({
            type:"post",
            url:"register",
            data:{"userName":userName,"password":password},
            success:function(data){
                alert("注册成功");
            },
            error:function(data){
              alert("注册失败。");
            }


        });
    }


</script>
<style>
    #span{
        font-size: 10px;
    }


</style>

<%--<form action="register" method="post">--%>
    用户名：<input id="userName" name="userName"  placeholder="手机/会员名/邮箱" type="text" onblur="check()"><br>
    <p id="p"></p>
    <span id="span" ></span><br>
   密码： <input id="password" name="password" type="password" placeholder="密码" ><br><br>
    <button type="button" onclick="register()">注册</button><br/>
    <span><font color="#a52a2a">${msg}</font></span>
<%--</form>--%>

</body>
</html>
