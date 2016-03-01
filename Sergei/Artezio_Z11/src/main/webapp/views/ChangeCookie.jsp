<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cookies</title>
    <c:set var="context" value="${pageContext.request.contextPath}"/>
</head>
<body>
<p>Cookie были изменены</p>
<a href="${context}/success_login">Вернуться на прошлую страницу</a>
</body>
</html>
