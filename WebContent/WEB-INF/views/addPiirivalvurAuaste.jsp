<%@ include file="init.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<our:Template>
	<h1>Lisa piirivalvuri auaste</h1>


	<form:form action="add" method="POST" modelAttribute="piirivalvuriauaste">
	
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
		<form:label path="auaste_id" >Auaste<br></form:label>
			<form:select path="auaste_id">
			<form:option value="Reamees" label="Reamees" />
			<form:option value="Seersant" label="Seersant" />
			<form:option value="Kapten" label="Kapten" />
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
			<input class="btn" type="submit" value="Lisa piirivalvuri auaste">
			<a class="btn" href="show">Katkesta</a>
		</div>
	</form:form>
		
	<c:if test="${added == true }">
		<div>Uus auaste lisatud. Vaata <a href="show">kõiki piirivalvurite auastmeid</a></div>
	</c:if>
	
</our:Template>
	