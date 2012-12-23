<%@ include file="init.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<our:Template>
	<h1>Lisa Auaste</h1>


	<form:form action="add" method="POST" modelAttribute="auaste">
	
		<div style="float:left;">
		<form:label path="kood" >Kood<br></form:label> <form:input path="kood" /><br/>
		<form:label path="nimetus" >Nimetus<br></form:label> <form:input path="nimetus" /><br/>
		<form:label path="tyyp" >Auastme t��p<br></form:label>
			<form:select path="tyyp">
			<form:option value="Huvitav" label="Huvitav" />
			<form:option value="Jama" label="Jama" />
			</form:select><br>

		<div class="btn-group" >
			<input class="btn" type="submit" value="Lisa Auaste">
			<a class="btn" href="show">Katkesta</a>
		</div>
		</div>
	</form:form>
		
	<c:if test="${added == true }">
		<div>Uus Auaste lisatud. Vaata <a href="show">k�iki auastmeid</a></div>
	</c:if>
	
</our:Template>
	