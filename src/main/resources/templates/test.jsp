<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h1>Hello, World!</h1>

<c:set var="name" value="John" />
<p>Hello, <c:out value="${name}" /></p>

<fmt:formatDate value="${now}" pattern="dd-MM-yyyy HH:mm:ss" var="formattedDate" />
<p>Current Date: <c:out value="${formattedDate}" /></p>



</body>
</html>
