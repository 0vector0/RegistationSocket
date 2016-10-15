<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<c:set var="urladdr" value="/userregistration"/>
<sf:form modelAttribute="reg" action="${urladdr}" method="post">
    <label for="name"><s:message code="reg.name"/> </label>
    <sf:input path="name"/>
    <sf:errors path="name" cssClass="error"/>

    <label for="name"><s:message code="reg.login"/> </label>
    <sf:input path="login"/>
    <sf:errors path="login" cssClass="error"/>

    <label for="name"><s:message code="reg.password"/> </label>
    <sf:input path="password"/>
    <sf:errors path="password" cssClass="error"/>
    <button type="submit" name="send"><s:message code="reg.submit"/></button>
</sf:form>
</body>
</html>
