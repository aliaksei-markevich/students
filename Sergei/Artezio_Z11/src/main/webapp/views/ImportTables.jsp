<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Загурзка справочников</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/import" method="post" enctype="multipart/form-data">
    <p>Если файл с расширение xls, то импорт идет в список, а если csv, то в дерево.</p>
    <input type="file" name="file" size="50" />
    <br>
    <br>
    <input type="submit" name="buttonImport" value="Импортировать данные" />
</form>
<hr>
<a href="${pageContext.servletContext.contextPath}/viewList">Просмотреть список</a>
<a href="${pageContext.servletContext.contextPath}/viewTree">Просмотреть дерево</a>
<br>
<a href="${pageContext.servletContext.contextPath}/import?clear=1" >Очистить список</a>
<a href="${pageContext.servletContext.contextPath}/import?clear=2" >Очистить дерево</a>
<br>
</body>
</html>
