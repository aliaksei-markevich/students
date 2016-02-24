<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<header>
    <title>Ошибка</title>
    <link rel="shortcut icon" href="">
</header>
<body>
<h1><tiles:insertAttribute name="title" /></h1>

<tiles:insertAttribute name="body" />

</body>
</html>
