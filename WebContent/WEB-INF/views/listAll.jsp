<%@ include file="init.jsp"%>

<our:Template>
	<table border="1">
		<tr>
			<th>Algusaeg</th>
			<th>Lõppaeg</th>
			<th>Asukoht</th>
			<th>Kirjeldus</th>
			<th>Valvurite arv</th>
			<th>Staatus</th>
		</tr>
		<c:forEach items="${incidents}" var="i">
			<tr>
				<td>${i.start}</td>
				<td>${i.end}</td>
				<td>${i.location}</td>
				<td>${i.description}</td>
				<td>${i.involvedGuardCount}</td>
				<td>${i.status}</td>
			</tr>
		</c:forEach>

	</table>
</our:Template>