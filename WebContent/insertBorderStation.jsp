<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Border Station</title>
</head>
<body>

	<jsp:useBean id="borderstation" class="ee.itcollege.i377.veebiJavaProjekt.BorderStation" scope="session"></jsp:useBean>

	<form method='post' action="TableView.jsp">
		<pre>Station Name:</pre><input type='text' name='name'/>
		<pre>Station Address:</pre><input type='text' name='address'/>
		<pre>Number of Men:</pre><input type='text' name='men'/>
		<br/><br/><input type='submit' value='Send' />
	</form>
</body>
</html>