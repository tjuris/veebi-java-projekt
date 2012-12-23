<%@ include file="init.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<our:Template>
	<h1>Uuenda vahtkonna liiget</h1>


	<form:form action="add" method="POST" modelAttribute="vahtkonnaliige">
	
		<div style="float:left;">
		<form:label path="piirivalvur_id" >Piirivalvur<br></form:label>
			<form:select path="piirivalvur_id">
			<form:option value="Jaan Tamm" label="Jaan Tamm" />
			<form:option value="Meelis Meri" label="Meelis Meri" />
			<form:option value="Priit Kask" label="Priit Kask" />
			</form:select><br>
		</div>
		<div style="float:right;">
			<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
			<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
			<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
			<script>$(function() {
				$("#datepicker" ).datepicker();
				});</script>
			<p>Alates: <input type="text" id="datepicker_from" /> </p>
		</div>
		
		<div style="float:left;">
		<form:label path="vahtkond_id" >Vahtkond<br></form:label>
			<form:select path="vahtkond_id">
			<form:option value="Esimene" label="Esimene" />
			<form:option value="Teine" label="Teine" />
			<form:option value="Kolmas" label="Kolmas" />
			</form:select><br>
		
		</div>
		<div style="float:right;">
			<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
			<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
			<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
			<script>$(function() {
				$("#datepicker" ).datepicker();
				});</script>
			<p>Kuni: <input type="text" id="datepicker_to" /> </p>
		</div>
	
		<div style="clear:both;">
		<form:label path="kommentaar" >Kommentaar<br></form:label> <form:input path="kommentaar" /><br/>
		</div>
	<div class="btn-group" >
		<input class="btn" type="submit" value="Uuenda Vahtkonda">
		<a class="btn" href="show">Katkesta</a>
		<a class="btn" href="delete?id=${vahtkonnaLiige.id}">Kustuta</a>
		
	</div>
	</form:form>
		
	<c:if test="${updated == true }">
		<div>Vahtkonna liige uuendatud. Vaata <a href="show">kõiki vahtkonna liikmeid</a></div>
	</c:if>
	
</our:Template>

	