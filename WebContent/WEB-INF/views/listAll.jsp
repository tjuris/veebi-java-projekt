<%@ include file="init.jsp" %>

<our:Template>
	<table>
		<c:forEach items="${incidents}" var="i">
			<tr>
				<td>${i}</td>
			</tr>
		</c:forEach>
		
	</table>
	Tere!
</our:Template>