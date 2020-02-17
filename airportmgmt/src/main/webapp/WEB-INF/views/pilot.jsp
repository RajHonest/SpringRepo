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
	function deletePlane(pilotId)
	{
		if(confirm('Do you want to delete this pilot ?'))
		{
			var url='/api/pilot/delete/'+pilotId;
			window.location.href=url;
		}
	}
</script>
</head>
<body>
<h2>Add/Edit Pilot</h2>
<c:url var="action" value="/api/pilot/add"></c:url>
<form:form method="post" action="${action}" commandName="pilot" cssClass="customerForm">
	<table>
		<c:if test="${!empty pilot}">
			<tr>
				<td>
					<form:label path="pilotId" cssClass="customerLabel">
						<spring:message code="label.pilotId"/>
					</form:label>
				</td>
				<td>
					<form:input path="pilotId" readonly="true" size="8" disabled="true"/>
					<form:hidden path="pilotId"/>
				</td>
			</tr>
		</c:if>
		<tr>
			<td>
				<form:label path="pilotName" cssClass="customerLabel">
					<spring:message code="label.pilotName"/>
				</form:label>
			</td>
			<td>
				<form:input path="pilotName"/><form:errors path="pilotName" cssClass="error"></form:errors>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="licenseNo" cssClass="customerLabel">
					<spring:message code="label.licenseNo"/>
				</form:label>
			</td>
			<td>
				<form:input path="licenseNo"/><form:errors path="licenseNo" cssClass="error"></form:errors>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="addressLine1" cssClass="customerLabel">
					<spring:message code="label.addressLine1"/>
				</form:label>
			</td>
			<td>
				<form:input path="addressLine1"/><form:errors path="addressLine1" cssClass="error"></form:errors>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="addressLine2" cssClass="customerLabel">
					<spring:message code="label.addressLine2"/>
				</form:label>
			</td>
			<td>
				<form:input path="addressLine2"/><form:errors path="addressLine2" cssClass="error"></form:errors>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="city" cssClass="customerLabel">
					<spring:message code="label.city"/>
				</form:label>
			</td>
			<td>
				<form:input path="city"/><form:errors path="city" cssClass="error"></form:errors>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="state" cssClass="customerLabel">
					<spring:message code="label.state"/>
				</form:label>
			</td>
			<td>
				<form:input path="state"/><form:errors path="state" cssClass="error"></form:errors>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="zipCode" cssClass="customerLabel">
					<spring:message code="label.zipCode"/>
				</form:label>
			</td>
			<td>
				<form:input path="zipCode"/><form:errors path="zipCode" cssClass="error"></form:errors>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="ssn" cssClass="customerLabel">
					<spring:message code="label.ssn"/>
				</form:label>
			</td>
			<td>
				<form:input path="ssn"/><form:errors path="ssn" cssClass="error"></form:errors>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<c:if test="${!empty pilot.pilotName}">
					<input type="submit" value="<spring:message code="label.update"/>"/>
				</c:if>
				<c:if test="${empty pilot.pilotName}">
					<input type="submit" value="<spring:message code="label.add"/>"/>
				</c:if>
			</td>
		</tr>
	</table>
</form:form>
<h3>List of Pilot's</h3>
<c:if test="${!empty pilotList}">
	<table class="customerTable">
		<tr>
			<th width="180"><spring:message code="label.pilotName"/></th>
			<th width="160">Last Name</th>
			<th width="60">Contact No</th>
			<th width="80">Email</th>
			<th width="60">Type</th>
			<th width="60">Capacity</th>
		</tr>
		<c:forEach items="${pilotList}" var="pilot">
			<tr>
				<td><a href="<c:url value='/api/pilot/edit/${pilot.pilotId}'/>">${pilot.pilotName}</a></td>
				<td>${pilot.addressLine1}</td>
				<td>${pilot.addressLine2}</td>
				<td>${pilot.city}</td>
				<td>${pilot.state}</td>
				<td>${pilot.zipCode}</td>
				<td>
				 <img src="<c:url value='/images/vcard_delete.png'/>" title="Delete Plane" onclick="javascript:deletePlane(${pilot.pilotId})"/>
				<!--<a href="<c:url value='/api/pilot/delete/${pilot.pilotId}'/>"><img src="<c:url value='/images/vcard_delete.png'/>" title="Delete Plane"/></a> -->
					<a href="<c:url value='/api/pilot/edit/${pilot.pilotId}'/>"><img src="<c:url value='/images/vcard_edit.png'/>" title="Edit Plane"/></a>
				</td>
			</tr> 
		</c:forEach>
	</table>
</c:if>
</body>
</html>