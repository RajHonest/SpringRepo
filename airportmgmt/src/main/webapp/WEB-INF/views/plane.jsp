<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="label.app.title"/></title>
<script type="text/javascript">
	function deletePlane(planeId)
	{
		if(confirm('Do you want to delete this plane ?'))
		{
			var url='/api/plane/delete/'+planeId;
			window.location.href=url;
		}
	}
</script>
</head>
<body>
<%@ include file="/pages/header.html" %>
<div class="main">

<div class="headTitle"><span>Add/Edit Plane</span></div>
<c:url var="action" value="/api/plane/add"></c:url>
<form:form method="post" action="${action}" commandName="plane" cssClass="airportForm">
	<table>
		<c:if test="${!empty plane}">
			<tr>
				<td>
					<form:label path="id" cssClass="customerLabel">
						<spring:message code="label.planeId"/>
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
				<form:label path="ownerFirstName" cssClass="customerLabel">
					<spring:message code="label.ownerFirstName"/>
				</form:label>
			</td>
			<td>
				<form:input path="ownerFirstName"/><form:errors path="ownerFirstName" cssClass="error"></form:errors>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="ownerLastName" cssClass="customerLabel">
					<spring:message code="label.ownerLastName"/>
				</form:label>
			</td>
			<td>
				<form:input path="ownerLastName"/><form:errors path="ownerLastName" cssClass="error"></form:errors>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="ownerContactNumber" cssClass="customerLabel">
					<spring:message code="label.ownerContactNumber"/>
				</form:label>
			</td>
			<td>
				<form:input path="ownerContactNumber"/><form:errors path="ownerContactNumber" cssClass="error"></form:errors>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="ownerEmail" cssClass="customerLabel">
					<spring:message code="label.ownerEmail"/>
				</form:label>
			</td>
			<td>
				<form:input path="ownerEmail"/><form:errors path="ownerEmail" cssClass="error"></form:errors>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="planeType" cssClass="customerLabel">
					<spring:message code="label.planeType"/>
				</form:label>
			</td>
			<td>
				<form:input path="planeType"/><form:errors path="planeType" cssClass="error"></form:errors>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="planeCapacity" cssClass="customerLabel">
					<spring:message code="label.planeCapacity"/>
				</form:label>
			</td>
			<td>
				<form:input path="planeCapacity"/><form:errors path="planeCapacity" cssClass="error"></form:errors>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<c:if test="${!empty plane.ownerFirstName}">
					<input class="myButton" type="submit" value="<spring:message code="label.update"/>"/>
				</c:if>
				<c:if test="${empty plane.ownerFirstName}">
					<input type="submit" value="<spring:message code="label.add"/>"/>
				</c:if>
			</td>
		</tr>
	</table>
</form:form>
<div class="spaceDivider"></div>
<div class="headTitle"><span>List of Plane's</span></div>
<c:if test="${!empty planeList}">
	<table class="airportTable">
		<tr>
			<th width="180">First Name</th>
			<th width="150">Last Name</th>
			<th width="60">Contact No</th>
			<th width="80">Email</th>
			<th width="60">Type</th>
			<th width="60">Capacity</th>
			<th width="20">&nbsp;</th>
		</tr>
		<c:forEach items="${planeList}" var="plane">
			<tr>
				<td><a href="<c:url value='/api/plane/edit/${plane.id}'/>">${plane.ownerFirstName}</a></td>
				<td>${plane.ownerLastName}</td>
				<td>${plane.ownerContactNumber}</td>
				<td>${plane.ownerEmail}</td>
				<td>${plane.planeType}</td>
				<td>${plane.planeCapacity}</td>
				<td>
				<!-- <img src="<c:url value='/images/vcard_delete.png'/>" title="Delete Plane" onclick="javascript:deletePlane(${plane.id})"/> -->
				<a href="<c:url value='/api/plane/delete/${plane.id}'/>"><img src="<c:url value='/images/vcard_delete.png'/>" title="Delete Plane"/></a>
					<a href="<c:url value='/api/plane/edit/${plane.id}'/>"><img src="<c:url value='/images/vcard_edit.png'/>" title="Edit Plane"/></a>
				</td>
			</tr> 
		</c:forEach>
	</table>
</c:if>
</div>
</body>
</html>