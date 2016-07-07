<%--
  Created by IntelliJ IDEA.
  User: Ivko Serhei
  Date: 28.06.2016
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="spring_tags" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <link href="<c:url value="/resources/css/login_form.css" />" rel="stylesheet">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
          integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
            integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
            crossorigin="anonymous"></script>
    <title><spring_tags:message code="Login"/></title>
</head>
<body>
<div class="modal-dialog">
    <div class="loginmodal-container">
        <form:form method="post" modelAttribute="user">
            <div class="lang">
                <a href="?lang=ru">ru</a>
                <a href="?lang=en">en</a>
            </div>
            <form:label path="name">
                <spring_tags:message code="login"/>
            </form:label>
            <form:input path="name"/>
            <form:label path="password">
                <spring_tags:message code="password"/>
            </form:label>
            <form:password path="password"/>
            <c:if test="${not empty flowRequestContext.messageContext.allMessages}">
                <ul class="req_message">
                    <c:forEach items="${flowRequestContext.messageContext.allMessages}" var="message">
                        <li>${message.text}</li>
                    </c:forEach>
                </ul>
            </c:if>
            <c:if test="${not empty message}">
                <span class="errorForm">${message}</span>
            </c:if>
            <footer>
                <input type="submit" value="<spring_tags:message code="Login"/>" name="_eventId_submit">
                <input type="submit" value="<spring_tags:message code="create-user"/>" name="_eventId_createUser">
            </footer>
        </form:form>
    </div>
</div>
</body>
</html>
