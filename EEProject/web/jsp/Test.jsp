<%@ page import="javax.naming.InitialContext" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="javax.naming.Context" %>
<%--
СОЗДАНИЕ ФРЕЙМА И РАЗМЕЩЕНИЕ ИНФОРМАЦИИ В НЕМ
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
<p><iframe name="area" width="500" height="200"></iframe></p>
<form action="Main.jsp" target="area">
    <p><input placeholder="Введите текст" name="username">
    <p><input type="submit" value="Отправить"></p>
</form>
<%
    try {
        InitialContext io = new InitialContext();
        DataSource ds = (DataSource) io.lookup("jdbc/Library");

        Connection connection = ds.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from users");
        while (resultSet.next()) {
            out.println("<h1>" + resultSet.getString("id") + "<h1>");
            out.println("<h1>" + resultSet.getString("type") + "<h1>");
        }
    }catch (Exception e)
    {
        out.println("<h1>" + e.toString() + "<h1>");
    }
%>
</body>
</html>
