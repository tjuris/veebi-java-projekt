<%@ include file="init.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<our:Template>
	<h1>Reported Incident</h1>
	
	${msg }
	<table border="1">
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
<!-- 			${incident.start } -->
			</td>
			<td>
<!-- 			${incident.end } -->
 			</td>
			<td>
				${incident.location }
			</td>
			<td>
				${incident.description }
			</td>
	
			<td>
				<center>
					${incident.involvedGuardCount }
				</center>
			</td>
		
			<td>
				${incident.status }
			</td>
		</tr>
	</table>
</our:Template>
