<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Просмотр таблицы .xsl списком </title>
    <link rel="shortcut icon" href="">
    <c:set var="context" value="${pageContext.request.contextPath}"/>
</head>
<body>
<table border="1">
    <tr>
        <td>Код клиента:</td>
        <td>Фамилия клиента:</td>
        <td>Имя клиента:</td>
        <td>Телефон:</td>
        <td>Какой-то код:</td>
        <td>Профессии:</td>
    </tr>
    <c:forEach items="${data}" var="data" varStatus="status">
        <tr valign="top"
                <c:if test="${data.getIdClient()==index}">
                    bgcolor="#FF0000"
                </c:if>
        >
            <td>${data.getIdClient()}</td>
            <td>${data.getLastName()}</td>
            <td>${data.getFirstName()}</td>
            <td>${data.getNumberPhone()}</td>
            <td>${data.getAnotherId()}</td>
            <td>${data.showPositions()}</td>
        </tr>
    </c:forEach>
</table>
<hr>
<a href="${context}/convert">Конвентировать</a>
<a href="${context}/import">Импорт в таблицу</a>
<a href="${context}/viewTree">Просмотреть дерево</a>
<a href="${context}/search">Поиск</a>
<a href="${context}/login">Сменить логин</a>
<br>
</body>
</html>
