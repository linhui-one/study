<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/11/7
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <%
      request.setAttribute("name","zhangsan");
      session.setAttribute("agge",23);


  %>
  ${requestScope.name}<br>
  ${sessionScope.agge}<br>
  ${pageContext.request.contextPath}
  </body>
</html>
