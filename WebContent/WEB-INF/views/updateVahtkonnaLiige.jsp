<%@ include file="init.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<our:Template>
	<h1>Uuenda vahtkonna liiget</h1>


	<form:form action="update" method="POST" modelAttribute="vahtkonnaLiige">
	
		<div style="float:left;">
		<form:label path="piirivalvur.eesnimi" >Piirivalvur<br></form:label>
			<form:select path="piirivalvur.id">
			<form:option  value="${vahtkonnaLiige.piirivalvur.id}" label="${vahtkonnaLiige.piirivalvur.eesnimi}" />
			<form:options items="${allPiirivalvurs}" itemValue="id" itemLabel="eesnimi" />
			</form:select><br>
		
		<form:label path="vahtkond.nimetus" >Vahtkond<br></form:label>
			<form:select path="vahtkond.id">
			<form:option  value="${vahtkonnaLiige.vahtkond.id}" label="${vahtkonnaLiige.vahtkond.nimetus}" />
			<form:options items="${allVahtkonds}" itemValue="id" itemLabel="nimetus" />
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
			<input class="btn" type="submit" value="Uuenda vahtkonna liiget">
			<a class="btn" href="show">Katkesta</a>
			<a class="btn" href="delete?id=${vahtkonnaLiige.id}">Kustuta</a>
		</div>
	</form:form>
		
		
	
		
	<c:if test="${updated == true }">
		<div>Vahtkonna liige uuendatud. Vaata <a href="show">kõiki vahtkonna liikmeid</a></div>
	</c:if>
	
</our:Template>

	