<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Подтверждение</title>
</head>
<body>
Вы вошли в систему как ${user.getName()}
<br>
<c:if test="${user.getName()=='admin'}">
    <a href="${pageContext.servletContext.contextPath}/import">Импортировать список</a>
</c:if>
<a href="${pageContext.servletContext.contextPath}/viewList">Просмотреть список</a>
<a href="${pageContext.servletContext.contextPath}/viewTree">Просмотреть дерево</a>
</body>
</html>