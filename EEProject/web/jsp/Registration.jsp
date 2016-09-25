<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Регистрация</title>
    <link href="css/style_login.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="main">

    <div class="content">
        <p class="title"><span class="text"><img src="images/lib.png" width="76" height="77" hspace="10" vspace="10" align="middle"></span></p>
        <p class="title">Заполните регистрационную форму</p>
    </div>

    <div class="login_div">
        <form class="login_form" name="username" action="/EEProject_war_exploded/logging?option=registration" method="POST">
            <p class="text">Имя:</p>
            <input type="text" name="fname" value="" size="30" />
            <p class="text">Пароль:</p>
            <input type="text" name="password" value="" size="30" />
            <p class="text">Email:</p>
            <input type="text" name="email" value="" size="30" />
            <p></p>
            <br>
            <input type="submit" value="Зарегистрироваться" />
        </form>
    </div>

    <div class="footer">
        <p class="text">Разработка by Димон</p>
        <p class="text">Пишите ваше мнение сюда: <a href="mailto:kusmen21kda@gmail.com">kusmen21kda@gmail.com</a></p>
    </div>
</div>

</body>
</html>
