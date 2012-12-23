<%@ include file="init.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<our:Template>
	<h1>Lisa vahtkonna liige</h1>


	<form:form action="add" method="POST" modelAttribute="vahtkonnaLiige">
	
		<div style="float:left;">
		<form:label path="piirivalvur_id" >Piirivalvur<br></form:label>
			<form:select path="piirivalvur_id">
			<form:options items="${allPiirivalvurs}" itemValue="id" itemLabel="eesnimi" />
			</form:select><br>
		</div>
		<div style="float:right;">
			<!-- <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
			 -->
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
			<form:options items="${allVahtkonds}" itemValue="id" itemLabel="nimetus" />
			</form:select><br>
		
		</div>
		<div style="float:right;">
			<!-- <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
			 -->
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
			<input class="btn" type="submit" value="Lisa vahtkonna liige">
			<a class="btn" href="show">Katkesta</a>
		</div>
	</form:form>
		
	<c:if test="${added == true }">
		<div>Uus vahtkonna liige lisatud. Vaata <a href="show">kõiki vahtkonna liikmeid</a></div>
	</c:if>
	
</our:Template>
	