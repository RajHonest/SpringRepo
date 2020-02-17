<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
              body {
                     font-family: verdana;
                     font-size: 12px;
                     margin: 40px;
              }
              .customerTable, .customerTable td {
                     border-collapse: collapse;
                     border: 1px solid #aaa;
                     margin: 2px;
                     padding: 2px 2px 2px 10px;
                     font-size: 12px;
              }
              .CustomerTable th {
                     font-weight: bold;
                     font-size: 12px;
                     background-color: #5C82FF;
                     color: white;
              }
              .CustomerLabel {
                     font-family: verdana;
                     font-size: 12px;
                     font-weight: bold;
              }
              a, a:AFTER {
                     color: blue;
              }
              
  			.error {
      			color: red;
      			font-style: italic;
  			}
</style>
<script type="text/javascript">
	function deletePlane(planeId)
	{
		if(confirm('Do you want to delete this plane ?'))
		{
			var url='/plane/delete/'+planeId;
			window.location.href=url;
		}
	}
</script>
</head>
<body>
<h2>Add/Edit Plane</h2>
<c:url var="action" value="/api/user/add"></c:url>
<form:form method="post" action="${action}" commandName="user" cssClass="customerForm">
	<table>
		<c:if test="${!empty user}">
			<tr>
				<td>
					<form:label path="id" cssClass="customerLabel">
						<spring:message code="label.userId"/>
					</form:label>
				</td>
				<td>
					<form:input path="id" readonly="true" size="8" disabled="true"/>
					<form:hidden path="id"/>
				</td>
			</tr>
		</c:if>
		<tr>
			<td>
				<form:label path="userName" cssClass="customerLabel">
					<spring:message code="label.userName"/>
				</form:label>
			</td>
			<td>
				<form:input path="userName"/><form:errors path="userName" cssClass="error"></form:errors>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="password" cssClass="customerLabel">
					<spring:message code="label.password"/>
				</form:label>
			</td>
			<td>
				<form:input path="password"/><form:errors path="password" cssClass="error"></form:errors>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="role" cssClass="customerLabel">
					<spring:message code="label.role"/>
				</form:label>
			</td>
			<td>
				<form:input path="role"/><form:errors path="role" cssClass="error"></form:errors>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="firstName" cssClass="customerLabel">
					<spring:message code="label.firstName"/>
				</form:label>
			</td>
			<td>
				<form:input path="firstName"/><form:errors path="firstName" cssClass="error"></form:errors>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="lastName" cssClass="customerLabel">
					<spring:message code="label.lastName"/>
				</form:label>
			</td>
			<td>
				<form:input path="lastName"/><form:errors path="lastName" cssClass="error"></form:errors>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="email" cssClass="customerLabel">
					<spring:message code="label.email"/>
				</form:label>
			</td>
			<td>
				<form:input path="email"/><form:errors path="email" cssClass="error"></form:errors>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="age" cssClass="customerLabel">
					<spring:message code="label.age"/>
				</form:label>
			</td>
			<td>
				<form:input path="age"/><form:errors path="age" cssClass="error"></form:errors>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="gender" cssClass="customerLabel">
					<spring:message code="label.gender"/>
				</form:label>
			</td>
			<td>
				<form:input path="gender"/><form:errors path="gender" cssClass="error"></form:errors>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="dateOfBirth" cssClass="customerLabel">
					<spring:message code="label.dateOfBirth"/>
				</form:label>
			</td>
			<td>
				<form:input path="dateOfBirth"/><form:errors path="dateOfBirth" cssClass="error"></form:errors>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="contactNo" cssClass="customerLabel">
					<spring:message code="label.contactNo"/>
				</form:label>
			</td>
			<td>
				<form:input path="contactNo"/><form:errors path="contactNo" cssClass="error"></form:errors>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="altContactNo" cssClass="customerLabel">
					<spring:message code="label.altContactNo"/>
				</form:label>
			</td>
			<td>
				<form:input path="altContactNo"/><form:errors path="altContactNo" cssClass="error"></form:errors>
			</td>
		</tr>
		
		<tr>
			<td colspan="2">
				<c:if test="${!empty user.userName}">
					<input type="submit" value="<spring:message code="label.update"/>"/>
				</c:if>
				<c:if test="${empty user.userName}">
					<input type="submit" value="<spring:message code="label.add"/>"/>
				</c:if>
			</td>
		</tr>
	</table>
</form:form>

</body>
</html>