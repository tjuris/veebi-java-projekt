<%@ include file="init.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<our:Template>
	<h1>Lisa vahtkond</h1>


	<form:form action="add" method="POST" modelAttribute="vahtkond">
	
		<div style="float:left;">
		<form:label path="kood" >Kood<br></form:label> <form:input path="kood" /><br/>
		<form:label path="piiripunkt_id" >Piiripunkt<br></form:label>
			<form:select path="piiripunkt_id">
			<form:option value="Valga" label="Valga" />
			<form:option value="Narva" label="Narva" />
			<form:option value="Ikla" label="Ikla" />
			</form:select><br>
		
		</div>
		<div style="float:left;">
		<form:label path="nimetus" >Nimetus<br></form:label> <form:input path="nimetus" /><br/>
		<form:label path="vaeosa_id" >V�eosa<br></form:label>
			<form:select path="vaeosa_id">
			<form:option value="Kupi" label="Kupi" />
			<form:option value="Viru" label="Viru" />
			<form:option value="Vahi" label="Vahi" />
			</form:select><br>
		
		</div>
	
		<div style="clear:both;">
		<form:label path="kommentaar" >Kommentaar<br></form:label> <form:input path="kommentaar" /><br/>
		</div>
		<div class="btn-group" >
			<input class="btn" type="submit" value="Lisa Vahtkond">
			<a class="btn" href="show">Katkesta</a>
		</div>
	</form:form>
		
	<c:if test="${added == true }">
		<div>Uus Vahtkond lisatud. Vaata <a href="show">k�iki vahtkondi</a></div>
	</c:if>
	
</our:Template>
	