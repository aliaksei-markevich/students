<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<link href="/css/errors.css" rel="stylesheet" type="text/css"/>
<link href="/css/formReg.css" rel="stylesheet" type="text/css"/>
<script src="/js/jquery.js"></script>
<script src="/js/checkCreateUserForm.js"></script>
<div class="form_box">
    <sf:form method="post" modelAttribute="user" action="/login/registration" class="rf">
        <div class="form-group">
            <label for="user_name">Login</label>
            <sf:input path="name" size="15" id="user_name" class="rfield"/>
            </br>
            <sf:errors path="name" cssClass="error"/>
        </div>
        <div class="form-group">
            <label for="user_password">Password</label>
            <sf:password path="password" size="15" id="user_password" class="rfield"/>
            </br>
            <sf:errors path="password" cssClass="error"/>
        </div>
        <div class="form-group">
            <label for="user_email">Email</label>
            <sf:input path="email" size="40" id="user_email" class="rfield"/>
            </br>
            <sf:errors path="email" cssClass="error"/>
        </div>
        <input type="submit" class="btn_submit disabled" value="Регистрация"/>
        <input type="reset" value="Очистить"/>
    </sf:form>
</div>
