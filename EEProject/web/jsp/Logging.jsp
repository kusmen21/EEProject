<%@ page import="sn.SQLHelper" %>
<%@ page import="sn.exception.UniqueValueException" %>
<%@ page import="sn.exception.NullValueException" %>
<%@ page import="sn.exception.UnexpectedException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Вход...</title>
    <meta http-equiv="refresh" content="3;URL=/EEProject_war_exploded/main" />
</head>
<body>
<%
    //setting charset for request
    request.setCharacterEncoding("UTF-8");

    String option = request.getParameter("option");
    String fname = request.getParameter("fname");
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    //from registration page
    if (option.equals("registration"))
    {
        try
        {
            SQLHelper.addUser(fname, email, password);

        }
        catch (UniqueValueException e1)
        {
            out.println("<h1>Поле Email должно быть уникальным</h1>");
        }
        catch (NullValueException e2)
        {
            out.println("<h1>Все поля дожны быть заполнены</h1>");
        }
        catch (UnexpectedException e3)
        {
            out.println("<h1>Неизвестная ошибка</h1>");
        }
    }

    //from login page
    if (option.equals("login"))
    {
        if (SQLHelper.isSomethingFound("SELECT id FROM users WHERE email = '" + email +
                "' AND password = '" + password + "'"))
        {
            out.println("<h1> Вы успешно вошли!</h1>");
        }
        else
        {
            out.println("<h1> Пользователь с такими email или паролем не найдены </h1>");
        }
    }

    //shows user which founded
    out.println("<h1>" + SQLHelper.getResultAsString("SELECT * FROM users WHERE email = '" + email + "'") + "</h1>");



%>
</body>
</html>
