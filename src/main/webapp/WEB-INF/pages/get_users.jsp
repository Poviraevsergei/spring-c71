<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All users</title>
</head>
<body>
<c:forEach items="${users}" var="user">
    <h6>${user.id}</h6>
    <h6>${user.username}</h6>
    <h6>${user.userPassword}</h6>
    <h6>${user.created}</h6>
    <h6>${user.changed}</h6>
    <h6>${user.age}</h6>
    <h3>----------------------</h3>
</c:forEach>
</body>
</html>
