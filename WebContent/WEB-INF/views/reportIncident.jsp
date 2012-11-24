<%@ include file="init.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<our:Template>
	<h2>Please report the Incident below.</h2>

	<form:form commandName="incident" method="POST">
		<table>
			<tr>
				<td>Start Date</td>
				<td><form:input path="start" /></td>
			</tr>
			<tr>
				<td>End Date</td>
				<td><form:input path="end" /></td>
			</tr>
			<tr>
				<td>Location</td>
				<td><form:input path="location" /></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><form:input path="description" /></td>
			</tr>
			<tr>
				<td>Number of involved guards</td>
				<td><form:input path="involvedGuardCount" /></td>
			</tr>
			<tr>
				<td>Status</td>
				<td><form:input path="status" /></td>
			</tr>
		</table>
		<input type="submit" value="Report" />
	</form:form>
</our:Template>