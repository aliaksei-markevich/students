<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:set var="context" value="${pageContext.request.contextPath}"/>
    <title>Login</title>
    <link rel="shortcut icon" href="">
</head>
<body>
<form action="/login" method="post">
    Логин: <input type="text" name="login" id="login"/>
    Пароль: <input type="password" name="password" id="password"/>
    <input type="submit" value="LogIn"/>
</form>
<p>admin - 1 (/import)</p>

<p>user1 - 2 (view lists)</p>

<p>user2 - 3 (view lists)</p>
<br>
<core:if test="${not empty error}">
    <div class="error">${error}</div>
</core:if>
<a href="${context}/login?new">Регистрация  нового пользователя</a>
</body>
</html>
