<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:url value="/j_spring_security_logout" var="logoutUrl" />
    <title>Ошибка</title>
    <link rel="shortcut icon" href="">
</head>
<body>
Неверный логин/пароль<br/>
<a href="${logoutUrl}">Log Out</a>
</body>
</html>
