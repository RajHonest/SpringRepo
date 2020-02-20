<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<style>
body, html {
  height: 100%;
  font-family: Arial, Helvetica, sans-serif;
}

* {
  box-sizing: border-box;
}
.bg-img {
  /* The image used */
  background-image: url("images/airport2.jpg");

  min-height: 380px;

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;
}

/* Add styles to the form container */
.loginContainer {
  position: absolute;
  /*right: 0;*/
  margin: 12px;
  max-width: 300px;
  padding: 12px;
  background-color: white;
}

input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

.loginBtn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.loginBtn:hover {
  opacity: 1;
}

.message {
  color:#00ff00;
	font-style: italic;
}
.errMessage {
	color: red;
	font-style: italic;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Airport</title>
</head>
<body>
<div class="bg-img">
	<a href="register"> Registration View</a>
	<form name='f' action="login" method='POST' class="loginContainer">
		<div>
		<c:if test="${not empty errorMessage}"><div class="errMessage">${errorMessage}</div></c:if>
		<c:if test="${not empty message}"><div class="message">${message}</div></c:if>
		</div>
		
      <table>
         <tr>
            <td>User:</td>
            <td><input type='text' name='username' value=''></td>
         </tr>
         <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
         </tr>
         <tr>
            <td><input name="submit" type="submit" value="submit" class="loginBtn"/></td>
         </tr>
      </table>
  </form>
 </div>
</body>
</html>