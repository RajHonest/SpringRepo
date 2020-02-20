    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!DOCTYPE html> 
<html>
<head>
</head>
<style>
.welcome {
	background-color:#CAE1F9;
	padding-bottom:10px;
	font-size:18px;
	height:100%;
	color:#E8A317;
}
.homePage {
	padding: 1px 2px 1px 1px;
	background-color:#CAE1F9;
	font-size:12px;
	height:100%;
	color:green;
}

</style>
<body>
<%@ include file="/pages/header.html" %>
<div class="main" style="height:200px;">
 <div class="welcome">Welcome to Airport management system</div>
 <div class="homePage">
 	<span>Supported operations as,</span>
 	<ul>
       <li>Managing the plane information</li>
       <li>Managing the pilot data</li>
       <li>Managing the hanger details</li>
       <li>Managing users</li>
    </ul>
   </div>
</div>
</body>
</html> 
 