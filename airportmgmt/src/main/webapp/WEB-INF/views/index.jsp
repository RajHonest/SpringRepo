<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
//response.sendRedirect("/airportmgmt/login");
%>

<a href="../api/plane/">Plane</a>
<a href="../api/pilot/">Pilot</a>
<a href="../api/user/">Users</a>
<a href="../logout">Logout</a>

<nav class="nav">
    <a href="${pageContext.request.contextPath}/"></a>
    <ul id="menu">
       <li><a href="${pageContext.request.contextPath}/api/plane/">Plane</a></li>
       <li><a href="${pageContext.request.contextPath}/api/pilot/">Pilot</a></li>
       <li><a href="${pageContext.request.contextPath}/api/user/">Users</a></li>
       <li><a href="${pageContext.request.contextPath}/api/user/register">Register</a></li>
       <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
    </ul>
</nav>
