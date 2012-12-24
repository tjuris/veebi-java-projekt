<%@ include file="init.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<our:Template>
	<h1>Piirivalvurite Auastmed</h1>

Vaatamise kuva..
	
	<c:if test="${not empty allPiirivalvurAuastes}">

		<table>
			<tr>
				<th>Muuda?</th>
				<th>ID</th>
				<th>Version</th>
				<th>Kommentaar</th>
				<th>Alates</th>
				<th>Kuni</th>
				<th>Piirivalvur</th>
				<th>Auaste</th>
				<th>Avatud</th>
				<th>Avaja</th>
				<th>Muudetud</th>
				<th>Muutja</th>
				<th>Suletud</th>
				<th>Sulgeja</th>			
			</tr>
			<c:forEach items="${allPiirivalvurAuastes}" var="piirivalvurAuaste"> 
				<tr>
					<td><a href="update?id=${piirivalvurAuaste.id}">Muuda?</a></td>
					<td>${piirivalvurAuaste.id}</td>
					<td>${piirivalvurAuaste.version}</td>
					<td>${piirivalvurAuaste.kommentaar}</td>
					<td>${piirivalvurAuaste.alates}</td>
					<td>${piirivalvurAuaste.kuni}</td>
					<td>${piirivalvurAuaste.piirivalvur}</td>
					<td>${piirivalvurAuaste.auaste}</td>
					<td>${piirivalvurAuaste.avatud}</td>
					<td>${piirivalvurAuaste.avaja}</td>
					<td>${piirivalvurAuaste.muudetud}</td>
					<td>${piirivalvurAuaste.muutja}</td>
					<td>${piirivalvurAuaste.suletud}</td>
					<td>${piirivalvurAuaste.sulgeja}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
</our:Template>
