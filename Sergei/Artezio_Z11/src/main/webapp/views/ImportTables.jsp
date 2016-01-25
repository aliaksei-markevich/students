<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Загрузка справочников</title>
    <script src='./js/jquery.js' type='text/javascript'></script>
    <script src='./js/newInputFiles.js' type='text/javascript'></script>
    <script src='./js/prototypeJSON.js' type='text/javascript'></script>
    <script src='./js/uploadFiles.js' type='text/javascript'></script>
</head>
<body>
<div id="count" hidden>${count}</div>
<form action="${pageContext.request.contextPath}/import" method="post" enctype="multipart/form-data">
    <p>Если файл с расширение xls, то импорт идет в список, а если csv, то в дерево.</p>
    <input type="file" id="uploadFile1" size="50" name="file"/><input id='uploadButton1' type='button' onclick='uploadFiles(1)' value='Загрузить'/>
    <input id='addInput' type='button' onclick='addInputFile()' value='Загрузить еще'/>
   <!-- <input type="submit" name="buttonImport" value="Импортировать данные" /> -->
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
