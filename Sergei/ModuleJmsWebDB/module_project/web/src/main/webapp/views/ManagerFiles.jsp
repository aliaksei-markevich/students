<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="/js/jquery.js" type="text/javascript"></script>
<script src="/js/deleteXMLFIle.js" type="text/javascript"></script>
<div>
    <c:forEach items="${listFilesXML}" var="file" varStatus="status">
        <div>
            <a href="../files/${file}">${file}</a>
            <input type="button" value="Удалить файл"/>
        </div>
    </c:forEach>
</div>
<hr>
<a href="${context}/viewList">Просмотреть список</a>
<a href="${context}/viewTree">Просмотреть дерево</a>
<a href="${context}/convert">Конвентировать</a>
<a href="${context}/search">Поиск</a>