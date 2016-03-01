<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <title>Загрузка справочников</title>
    <link rel="shortcut icon" href="">
    <script src="/js/jquery.js" type='text/javascript'></script>
    <script src='/js/newInputFiles.js' type='text/javascript'></script>
    <script src='/js/prototypeJSON.js' type='text/javascript'></script>
    <script src='/js/uploadFiles.js' type='text/javascript'></script>
    <script  type='text/javascript'>
            $(document).ready(function(){
                $('div','form').first().find("input[type='button']").first().click(uploadFiles);
            });
    </script>
    <c:set var="context" value="${pageContext.request.contextPath}"/>
</head>
<body>
<form action="${pageContext.request.contextPath}/import" method="post" enctype="multipart/form-data">
    <div>
        <p>Если файл с расширение xls, то импорт идет в список, а если csv, то в дерево.</p>
        <input type='file' class ='file' size='50' name='file'/><input type='button' value='Загрузить'/>
        <input id='addInput' type='button' onclick='addInputFile()' value='Загрузить еще'/>
        <br>
        <span></span>
    </div>
    <div id="template" style="display: none">
        <input type='file' class ='file' size='50' name='file'/>
        <input type='button' value='Загрузить'/>
        <br>
        <span></span>
    </div>
</form>
<hr>
<a href="${context}/viewList">Просмотреть список</a>
<a href="${context}/viewTree">Просмотреть дерево</a>
<a href="${context}/convert">Конвентировать</a>
<br>
<a href="${context}/import?clear=1">Очистить список</a>
<a href="${context}/import?clear=2">Очистить дерево</a>
<a href="${context}/search">Поиск</a>
<br>
</body>
</html>
