<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <link rel="shortcut icon" href="">
</head>
<body>
<form action="/login" method="post">
    Логин: <input type="text" name="name"/>
    Пароль: <input type="password" name="password"/>
    <input type="submit" value="LogIn"/>
</form>
<p>admin - 1 (/import)</p>

<p>user1 - 2 (view lists)</p>

<p>user2 - 3 (view lists)</p>
<br>
<c:if test="${user.getName()!=null}">
    <p>
        Сейчас Вы в системе как ${user.getName()}
    </p>
</c:if>
</body>
</html>
