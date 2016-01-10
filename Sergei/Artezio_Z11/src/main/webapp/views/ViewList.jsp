<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Просмотр таблицы .xsl списком </title>
</head>
<body>
<table border="1">
    <tr>
        <td>Код клиента:</td>
        <td>Фамилия клиента:</td>
        <td>Имя клиента:</td>
        <td>Телефон:</td>
        <td>Какой-то код:</td>
    </tr>
    <c:forEach items="${data}" var="data" varStatus="status">
        <tr valign="top">
            <td>${data.getIdClient()}</td><td>${data.getLastName()}</td>
            <td>${data.getFirstName()}</td><td>${data.getNumberPhone()}</td>
            <td>${data. getAnotherId()}</td>
        </tr>
    </c:forEach>
</table>
<hr>
<a href="${pageContext.servletContext.contextPath}/import">Импорт в таблицу</a>
<a href="${pageContext.servletContext.contextPath}/viewTree">Просмотреть дерево</a>
<a href="${pageContext.servletContext.contextPath}/viewList?clear=1" >Очистить список</a>
<br>
</body>
</html>
