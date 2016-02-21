<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:url value="/j_spring_security_logout" var="logoutUrl" />
    <c:set var="context" value="${pageContext.request.contextPath}" />
    <title>Подтверждение</title>
    <link rel="shortcut icon" href="">
</head>
<body>
Вы вошли в систему как ${user_name}
<br>

<c:if test="${user_name=='admin'}">
    <a href="${pageContext.servletContext.contextPath}/import">Импортировать список</a>
</c:if>
<a href="${context}/viewList">Просмотреть список</a>
<a href="${context}/viewTree">Просмотреть дерево</a>

<br>
<a href="${logoutUrl}">Log Out</a>
</body>
</html>