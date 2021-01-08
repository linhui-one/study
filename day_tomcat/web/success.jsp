<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/11/11
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="" errorPage=""  %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String user = (String) session.getAttribute("user");
    out.write(user+"登陆成功");
%>

</body>
</html>
