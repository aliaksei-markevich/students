<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Конвертация справочника в XML</title>
    <c:set var="context" value="${pageContext.request.contextPath}"/>
    <script src="/js/jquery.js" type='text/javascript'></script>
    <script src='/js/convertFiles.js' type='text/javascript'></script>
    <script>
        $(document).ready(function () {
            $('div').find("input[type='button']").first().click(convertFiles);
        });
    </script>
</head>
<body>
<div>
    <input type='file' class='file' size='50' name='file'/>
    <input type='button' value='Загрузить'/>
</div>
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
