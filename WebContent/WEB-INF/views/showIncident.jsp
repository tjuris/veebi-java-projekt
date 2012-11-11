<%@ include file="init.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<our:Template>
	<h1>Reported Incident</h1>
	
	${msg }
	<table>
		<tr>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Location</th>
			<th>Description</th>
			<th>Nr. of involved guards</th>
			<th>Status</th>
		</tr>
		<tr>
			<td>
				${incident.start }
			</td>
		</tr>
		<tr>
			<td>
				${incident.end }
			</td>
		</tr>
		<tr>
			<td>
				${incident.location }
			</td>
		</tr>
		<tr>
			<td>
				${incident.description }
			</td>
		</tr>
		<tr>
			<td>
				${incident.involvedGuardCount }
			</td>
		</tr>
		<tr>
			<td>
				${incident.status }
			</td>
		</tr>
	</table>
</our:Template>
