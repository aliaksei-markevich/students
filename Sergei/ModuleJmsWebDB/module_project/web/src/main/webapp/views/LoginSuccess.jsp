<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:url value="/j_spring_security_logout" var="logoutUrl"/>
    <c:set var="context" value="${pageContext.request.contextPath}"/>
    <c:set var="userRegion" value="${user_name}Region"/>
    <title>Подтверждение</title>
    <link rel="shortcut icon" href="">
    <script src="/js/jquery.js" type="text/javascript"></script>
    <script src="//api-maps.yandex.ru/2.0/?load=package.standard&lang=ru-RU" type="text/javascript"></script>
    <script src="/js/geolocation_ip.js" type="text/javascript"></script>
    <script src="/js/userRegionCookies.js" type="text/javascript"></script>
</head>
<body>
Вы вошли в систему как ${user_name}
<input type="hidden" id="user_name" value="${user_name}"/>
<br>
        <div id="regionSelectDiv">
            <select id="regionSelect">
                <option value="" disabled selected hidden>Выберите область</option>
                <option value="mogilev">Могилёвская область</option>
                <option value="vitebsk">Витебская область</option>
                <option value="brest">Брестская область</option>
                <option value="gomel">Гомельская область</option>
                <option value="minsk">Минская область</option>
                <option value="grodno">Гродненская область</option>
            </select>
            <button type="button" id="addRegionToCookies" data-user="${user_name}">Добавить регион в куки</button>
        </div>
        <div id="showCookie">
            <p>У вас выбрана область:</p><spans id="spanNameRegion">${cookie[userRegion].value}</spans>
            <button type="button" id="deleteRegionToCookies" data-user="${user_name}">Удалить регион в куки</button>
        </div>
<br>
<div id="map" style="width:400px; height:300px"></div>
    <c:if test="${user_name=='admin'}">
    <a href="${pageContext.servletContext.contextPath}/import">Импортировать список</a>
</c:if>
<a href="${context}/viewList">Просмотреть список</a>
<a href="${context}/viewTree">Просмотреть дерево</a>
<a href="${context}/search">Поиск</a>
<a href="${context}/convert">Конвентировать</a>
<a href="${context}/admin/managerFiles">Менеджер Файлов</a>
<br>
<a href="${logoutUrl}">Log Out</a>
<br>
</body>
</html>