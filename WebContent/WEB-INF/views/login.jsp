<%@ include file="init.jsp" %>

<our:Template>
	<h1>Hello, twitter!</h1>
	
	
<form name='f' action='/VeebiJavaProjekt/j_spring_security_check' method='POST'>
	<table>
		<tr>
			<td> Kasutaja: </td>
			<td><input type='text' name='j_username' value=''></td>
		</tr>
		<tr>
			<td>Parool: </td>
			<td><input type='password' name='j_password' value=''></td>
		</tr>
		<tr>
			<td colspan='2'> <input name="submit" type="submit" value="Sisene" /></td>
		</tr>
	</table>
</form>
</our:Template>



