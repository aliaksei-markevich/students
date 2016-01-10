<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Загурзка справочников</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/import" method="post">
    <input type="submit" name="buttonXls" value="Импортировать данные из xls файла" />
    <input type="submit" name="buttonCsv" value="Импортировать данные из csv файла" />
</form>
<hr>
<a href="${pageContext.servletContext.contextPath}/viewList">Просмотреть список</a>
<a href="${pageContext.servletContext.contextPath}/viewTree">Просмотреть дерево</a>
<br>
</body>
</html>
