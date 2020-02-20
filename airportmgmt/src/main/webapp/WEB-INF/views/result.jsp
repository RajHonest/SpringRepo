<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.failureMessage {
	color:green;
	font-size:18px;
	width: auto;
	padding: 5px;
	height:60%;
	boder:1px;
}
.successMessage {
	color:green;
	font-size:18px;
	width: auto;
	padding: 5px;
	height:60%;
	boder:1px;
}

.alert-box {
	color:#555;
	border-radius:10px;
	font-family:Tahoma,Geneva,Arial,sans-serif;font-size:11px;
	padding:10px 36px;
	margin:10px;
}
.alert-box span {
	font-weight:bold;
	text-transform:uppercase;
}
.success {
	background:#e9ffd9 url('images/success.png') no-repeat 10px 50%;
	border:1px solid #a6ca8a;
}
.error {
	background:#ffecec url('images/error.png') no-repeat 10px 50%;
	border:1px solid #f5aca6;
}
</style>
<body>
<%@ include file="/pages/header.html" %>
<div class="main">
		<!-- <div class="alert-box success"><span>success: </span>Write your success message here.</div> -->

		<c:if test="${not empty errorMessage}"><div class="alert-box error"><span>success: </span>${errorMessage}</div></c:if>
		<c:if test="${not empty message}"><div class="alert-box success"><span>success: </span>${message}</div></c:if>
</div>
</body>
</html>