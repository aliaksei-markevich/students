<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Просмотр дерева</title>
    <link rel="shortcut icon" href="">
    <script src='./js/jquery.js' type='text/javascript'></script>
    <script src="./js/jquery-ui.custom.js" type="text/javascript"></script>
    <script src='./js/jquery.cookie.js' type='text/javascript'></script>
    <script src='./js/jquery.dynatree.js' type='text/javascript'></script>
    <c:set var="context" value="${pageContext.request.contextPath}"/>
    <script>
        ;
        $(document).ready(
                $(function () {
                    // Attach the dynatree widget to an existing <div id="tree"> element
                    // and pass the tree options as an argument to the dynatree() function:
                    $("#tree").dynatree({
                        onActivate: function (node) {
                            // A DynaTreeNode object is passed to the activation handler
                            // Note: we also get this event, if persistence is on, and the page is reloaded.
                        },
                        ${tree}
                    });
                    <c:if test="${not empty index }">
                    $("#tree").dynatree("getTree").activateKey(${index});
                    </c:if>
                }));
    </script>
    <link href="./css/ui.dynatree.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="tree"></div>
<hr>
<a href="${context}/import">Импорт в таблицу</a>
<a href="${context}/viewList">Просмотреть список</a>
<a href="${context}/search">Поиск</a>
<a href="${context}/login">Сменить логин</a>
<br>
</body>
</html>
