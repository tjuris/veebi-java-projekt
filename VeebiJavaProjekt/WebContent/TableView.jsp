<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Border Station Table View</title>
</head>
<body>

	<jsp:useBean id="borderstation" class="ee.itcollege.i377.veebiJavaProjekt.BorderStation" scope="session"></jsp:useBean>
	<jsp:setProperty name="borderstation" property="*"></jsp:setProperty>

	<table border="1" style="text-align: center;">
		<tr>
			<th>Station name</th>
			<th>Address</th>
			<th>Border guards</th>
		</tr>
		<tr>
			<td>
				<c:out value="${borderstation.name }"></c:out>				
			</td>
			<td>
				<c:out value="${borderstation.address }"></c:out>				
			</td>
			<td>
				<c:out value="${borderstation.men }"></c:out>				
			</td>			
		</tr>
	</table>
	<form method='post' action="insertBorderStation.jsp">
		<br/><br/><input type='submit' value='Back' />
	</form>
</body>
</html>

