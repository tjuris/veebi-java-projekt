<%@ include file="init.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<our:Template>
	<h1>Lisa vahtkonna liige</h1>


	<form:form action="add" method="POST" modelAttribute="vahtkonnaLiige">
	
		<div style="float:left;">
		<form:label path="piirivalvur" >Piirivalvur<br></form:label>
			<form:select path="piirivalvur.id">
			<form:options items="${allPiirivalvurs}" itemValue="id" itemLabel="eesnimi" />
			</form:select><br>
		
		<form:label path="vahtkond" >Vahtkond<br></form:label>
			<form:select path="vahtkond.id">
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
			<input class="btn" type="submit" value="Lisa vahtkonna liige">
			<a class="btn" href="show">Katkesta</a>
		</div>
	</form:form>
		
	<c:if test="${added == true }">
		<div>Uus vahtkonna liige lisatud. Vaata <a href="show">kõiki vahtkonna liikmeid</a></div>
	</c:if>
	
</our:Template>
	