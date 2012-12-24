<%@ include file="init.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<our:Template>
	<h1>Vahtkondade liikmed</h1>

Vaatamise kuva..
	
	<c:if test="${not empty allVahtkonnaLiiges}">

		<table>
			<tr>
				<th>Muuda?</th>
				<th>ID</th>
				<th>Alates</th>
				<th>Kuni</th>
				<th>Kommentaar</th>
				<th>Version</th>
				<th>Vahtkond_id</th>
				<th>Piirivalvur_id</th>
				<th>Avatud</th>
				<th>Avaja</th>
				<th>Muudetud</th>
				<th>Muutja</th>
				<th>Suletud</th>
				<th>Sulgeja</th>			
			</tr>
			<c:forEach items="${allVahtkonnaLiiges}" var="vahtkonnaLiige"> 
				<tr>
					<td><a href="update?id=${vahtkonnaLiige.id}">Muuda?</a></td>
					<td>${vahtkonnaLiige.id}</td>
					<td>${vahtkonnaLiige.alates}</td>
					<td>${vahtkonnaLiige.kuni}</td>
					<td>${vahtkonnaLiige.kommentaar}</td>
					<td>${vahtkonnaLiige.version}</td>
					<td>${vahtkonnaLiige.vahtkond}</td>
					<td>${vahtkonnaLiige.piirivalvur}</td>
					<td>${vahtkonnaLiige.avatud}</td>
					<td>${vahtkonnaLiige.avaja}</td>
					<td>${vahtkonnaLiige.muudetud}</td>
					<td>${vahtkonnaLiige.muutja}</td>
					<td>${vahtkonnaLiige.suletud}</td>
					<td>${vahtkonnaLiige.sulgeja}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
</our:Template>
