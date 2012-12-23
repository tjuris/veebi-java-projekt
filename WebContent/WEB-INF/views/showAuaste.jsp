<%@ include file="init.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<our:Template>
	<h1>Auastmed</h1>

Vaatamise kuva..
	
	<c:if test="${not empty allAuastes}">

		<table>
			<tr>
				<th>Muuda?</th>
				<th>ID</th>
				<th>Kood</th>
				<th>Nimetus</th>
				<th>Tüüp</th>
				<th>Version</th>
				<th>Avatud</th>
				<th>Avaja</th>
				<th>Muudetud</th>
				<th>Muutja</th>
				<th>Suletud</th>
				<th>Sulgeja</th>			
			</tr>
			<c:forEach items="${allAuastes}" var="auaste"> 
				<tr>
					<td><a href="update?id=${auaste.id}">Muuda?</a></td>
					<td>${auaste.id}</td>
					<td>${auaste.kood}</td>
					<td>${auaste.nimetus}</td>
					<td>${auaste.tyyp}</td>
					<td>${auaste.version}</td>
					<td>${auaste.avatud}</td>
					<td>${auaste.avaja}</td>
					<td>${auaste.muudetud}</td>
					<td>${auaste.muutja}</td>
					<td>${auaste.suletud}</td>
					<td>${auaste.sulgeja}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
</our:Template>
