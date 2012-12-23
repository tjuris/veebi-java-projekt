<%@ include file="init.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<our:Template>
	<h1>Lisa vahtkond</h1>


	<form:form action="add" method="POST" modelAttribute="piirivalvur">
	
		<div style="float:left;">
		<form:label path="sodurikood" >Sõduri kood<br></form:label> <form:input path="sodurikood" /><br/>
		<form:label path="isikukood" >Isikukood<br></form:label> <form:input path="isikukood" /><br/>
		<form:label path="eesnimi" >Eesnimi<br></form:label> <form:input path="eesnimi" /><br/>
		<form:label path="perekonnanimi" >Perekonnanimi<br></form:label> <form:input path="perekonnanimi" /><br/>
		<form:label path="sugu" >Sugu<br></form:label>
			<form:select path="sugu">
			<form:option value="0" label="M/N" />
			<form:option value="1" label="M" />
			<form:option value="2" label="N" />
			</form:select><br>
		<div class="btn-group">	
		<input class="btn" type="submit" value="Lisa Valvur">
		<a class="btn" href="show">Katkesta</a>
		</div>
	</div>
	<div style="float:left;">
		<form:label path="email" >Email<br></form:label> <form:input path="email" /><br/>
		<form:label path="telefon" >Telefon<br></form:label> <form:input path="telefon" /><br/>
		<form:label path="aadress" >Aadress<br></form:label> <form:input path="aadress" /><br/>
		<form:label path="kommentaar" >Kommentaar<br></form:label> <form:input path="kommentaar" /><br/>
	</div>
	</form:form>
	
	<c:if test="${added == true }">
		<div>Uus piirivalvur lisatud. Vaata <a href="show">kõiki valvureid</a></div>
	</c:if>
	
</our:Template>
	