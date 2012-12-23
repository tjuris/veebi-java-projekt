<%@ include file="init.jsp"%>

<our:Template>
	<h1>Näita Vahtkondi</h1>

Vaatamise kuva..
	
	<c:if test="${not empty allVahtkonds}">

		<table>
			<tr>
				<th>Muuda?</th>
				<th>ID</th>
				<th>Kood</th>
				<th>Nimetus</th>
				<th>Kommentaar</th>
				<th>Version</th>
				<th>Piiripunkt_id</th>
				<th>Väeosa_id</th>
				<th>Avatud</th>
				<th>Avaja</th>
				<th>Muudetud</th>
				<th>Muutja</th>
				<th>Suletud</th>
				<th>Sulgeja</th>			
			</tr>
			<c:forEach items="${allVahtkonds}" var="vahtkond"> 
				<tr>
					<td><a href="update?id=${vahtkond.id}">Muuda?</a></td>
					<td>${vahtkond.id}</td>
					<td>${vahtkond.kood}</td>
					<td>${vahtkond.nimetus}</td>
					<td>${vahtkond.kommentaar}</td>
					<td>${vahtkond.version}</td>
					<td>${vahtkond.piiripunkt_id}</td>
					<td>${vahtkond.vaeosa_id}</td>
					<td>${vahtkond.avatud}</td>
					<td>${vahtkond.avaja}</td>
					<td>${vahtkond.muudetud}</td>
					<td>${vahtkond.muutja}</td>
					<td>${vahtkond.suletud}</td>
					<td>${vahtkond.sulgeja}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
</our:Template>
