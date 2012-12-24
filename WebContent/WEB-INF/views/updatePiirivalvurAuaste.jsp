<%@ include file="init.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<our:Template>
	<h1>Uuenda piirivalvuri auastet</h1>


	<form:form action="update" method="POST" modelAttribute="piirivalvurAuaste">
	
		<div style="float:left;">
		<form:label path="piirivalvur.eesnimi" >Piirivalvur<br></form:label>
			<form:select path="piirivalvur.id">
			<form:option  value="${piirivalvurAuaste.piirivalvur.id}" label="${piirivalvurAuaste.piirivalvur.eesnimi}" />
			<form:options items="${allPiirivalvurs}" itemValue="id" itemLabel="eesnimi" />
			</form:select><br>
		
		<form:label path="auaste.nimetus" >Auaste<br></form:label>
			<form:select path="auaste.id">
			<form:option  value="${piirivalvurAuaste.auaste.id}" label="${piirivalvurAuaste.auaste.nimetus}" />
			<form:options items="${allAuastes}" itemValue="id" itemLabel="nimetus" />
			</form:select><br>
		
		</div>
		<div style="float:right;">
			<script>
    			$(function() {
        			$( "#datepicker_from" ).datepicker({ dateFormat: "dd/mm/yy" });
    			});
    		
    		    $(function() {
    		        $( "#datepicker_to" ).datepicker({ dateFormat: "dd/mm/yy" });
    		    });    		 
 			</script>
 			<form:label path="alates" >Alates<br></form:label>
			<form:input path="alates" id="datepicker_from" />
			<form:label path="kuni" >Kuni<br></form:label>
			<form:input path="kuni" id="datepicker_to" />
		</div>
	
		<div style="clear:both;">
		<form:label path="kommentaar" >Kommentaar<br></form:label> <form:input path="kommentaar" /><br/>
		</div>
		<div class="btn-group" >
			<input class="btn" type="submit" value="Uuenda piirivalvuri auastet">
			<a class="btn" href="show">Katkesta</a>
			<a class="btn" href="delete?id=${piirivalvurAuaste.id}">Kustuta</a>
		</div>
	</form:form>
		
		
	
		
	<c:if test="${updated == true }">
		<div>Piirivalvuri auaste uuendatud. Vaata <a href="show">kõiki piirivalvurite auastmeid</a></div>
	</c:if>
	
</our:Template>

	