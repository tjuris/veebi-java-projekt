<%@ include file="init.jsp"%>

<our:Template>
	<h1>Show Guard</h1>

Vaatamise kuva..
	
	<c:if test="${not empty allPiirivalvurs}">

		<table>
			<tr>
				<th>Muuda?</th>
				<th>ID</th>
				<th>Aadress</th>
				<th>Eesnimi</th>
				<th>Email</th>
				<th>Isikukood</th>
				<th>Kommentaar</th>
				<th>Perekonnanimi</th>
				<th>Sõdurikood</th>
				<th>Sugu</th>
				<th>Telefon</th>
				<th>Version</th>
				<th>Avatud</th>
				<th>Avaja</th>
				<th>Muudetud</th>
				<th>Muutja</th>
				<th>Suletud</th>
				<th>Sulgeja</th>			
			</tr>
			<c:forEach items="${allPiirivalvurs}" var="valvur"> 
				<tr>
					<td><a href="update?id=${valvur.id}">Muuda?</a></td>
					<td>${valvur.id}</td>
					<td>${valvur.aadress}</td>
					<td>${valvur.eesnimi}</td>
					<td>${valvur.email}</td>
					<td>${valvur.isikukood}</td>
					<td>${valvur.kommentaar}</td>
					<td>${valvur.perekonnanimi}</td>
					<td>${valvur.sodurikood}</td>
					<td>${valvur.sugu}</td>
					<td>${valvur.telefon}</td>
					<td>${valvur.version}</td>
					<td>${valvur.avatud}</td>
					<td>${valvur.avaja}</td>
					<td>${valvur.muudetud}</td>
					<td>${valvur.muutja}</td>
					<td>${valvur.suletud}</td>
					<td>${valvur.sulgeja}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
</our:Template>
