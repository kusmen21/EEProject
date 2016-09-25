<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Логин</title>
    <link href="css/style_login.css" rel="stylesheet" type="text/css">
</head>

<div class="main">

    <div class="content">
        <p class="title"><span class="text"><img src="images/lib.png" width="76" height="77" hspace="10" vspace="10" align="middle"></span></p>
        <p class="title">Ничошная соцсеточка</p>
        <p class="text">Это поистине уникальная по функциональности и дизайну соцсетка подарит вам стойкое отторжение к пользованию интернетом и компьютером в частности</p>
        <p class="text">На данный момент мы распологаем следующим огромным списком функций:</p>
        <p class="text">1) Вы можете залогиниться =)</p>
    </div>

    <div class="login_div">
        <p class="title">Для входа введите свои данные:</p>
        <form class="login_form" name="username" action="/EEProject_war_exploded/logging?option=login" method="POST">
            Email: <input type="text" name="email" value="" size="30" />
            <p></p>
            Пароль: <input type="text" name="password" value="" size="30" />
            <p></p>
            <input type="submit" value="Войти" />
        </form>
    </div>

    <div class="content">
        <br>
        <h3 align="center" class="text">Либо вы можете зарегистрироваться:</h3>
    </div>

    <div class="footer" align="center">
        <a href="/EEProject_war_exploded/registration" class="button">Регистрация</a>
    </div>

    <div class="footer">
        <p class="text">Разработка by Димон</p>
        <p class="text">Пишите ваше мнение сюда: <a href="mailto:kusmen21kda@gmail.com">kusmen21kda@gmail.com</a></p>
    </div>
</div>

</body>
</html>