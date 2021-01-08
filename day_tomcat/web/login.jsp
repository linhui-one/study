<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/11/11
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<style>
    div{
        color: darkred;
    }
</style>
<script>
    window.onload=function () {
        document.getElementById("img").onclick=function () {
            this.src="/day/checkCode_session?time="+new Date().getTime();
        }
    }
</script>

<form action="/day/loginServlet" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td>
                <input type="text" name="username">
            </td>
        </tr>
        <tr>
            <td>密码</td>
            <td>
                <input type="password" name="password">
            </td>
        </tr>
        <tr>
            <td>验证码</td>
            <td>
                <input type="text" name="checkcode">
            </td>
        </tr>
        <tr>
            <td colspan="2">
               <img id="img" src="/day/checkCode_session">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="登陆">
            </td>
        </tr>
    </table>
<div>
    <%= request.getAttribute("cc_error")==null ? "": request.getAttribute("cc_error")%></div>
        <div>   <%= request.getAttribute("login_error")== null ? "": request.getAttribute("login_error")%></div>
</form>
</body>
</html>
