<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1" style="border-collapse:collapse">
<tr><th>Id</th><th>Name</th><th>City</th><th>Phone</th></tr>

<c:forEach var="listpersons" items="${list}">
<tr>
<td>
<c:out value="${listpersons.id}"></c:out></td>
<td><c:out value="${listpersons.name}"></c:out></td>
<td><c:out value="${listpersons.code}"></c:out></td>
</tr>
</c:forEach>

</table>
<c:if test="${current>0}">
<a href="/show?page=${current-1}">Prev</a>
</c:if>
<c:forEach begin="0" end="${total-1}" varStatus="loop">
<c:choose>
<c:when test="${loop.index==current}">
<mark>${loop.index+1}</mark>
</c:when>
<c:otherwise>
<a href="/show?page=${loop.index}">${loop.index+1}</a>
</c:otherwise>
</c:choose> 
</c:forEach>
<c:if test="${current<total}">
<a href="/show?page=${current+1}">Next</a>
</c:if>

</body>
</html>