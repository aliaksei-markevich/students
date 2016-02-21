<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:url value="/j_spring_security_logout" var="logoutUrl" />
    <title>Нет доступа</title>
    <link rel="shortcut icon" href="">
</head>
<body>
<p>Данная старница вам не доступна</p>
<a href="${logoutUrl}">Log Out</a>
</body>
</html>
