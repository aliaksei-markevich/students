<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set value="/j_spring_security_logout" var="logoutUrl" />
<p>Данная старница вам не доступна</p>
Error user
<a href="${logoutUrl}">Log Out</a>

