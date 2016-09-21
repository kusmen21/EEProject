<%--
  Created by IntelliJ IDEA.
  User: Дима
  Date: 19.09.2016
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    <% request.setCharacterEncoding("UTF-8"); %>
    <%=
        "Hey " + request.getParameter("username")
    %>
</h1>
</body>
</html>
