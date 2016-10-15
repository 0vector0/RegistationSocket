<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>confirmation</title>
</head>
<body>
name:${sessionScope.reg.name}
<br/>
login:${sessionScope.reg.login}
<br/>
password:${sessionScope.reg.password}
<br/>
<sf:form action="/confirmation" method="get">
    <button type="submit" name="confirmation"><s:message code="reg.submit"/></button>
</sf:form>
</body>
</html>
