<%@ include file="init.jsp"%>

<our:Template>
	<h1>Hello, twitter!</h1>

	<c:choose>
		<c:when test="${not empty userInfo}">${userInfo.name}</c:when>
		<c:otherwise>
			<form method="POST" action="userInfo">
				<label>Nimi</label> <input type="text" name="name" /> <label>Vanus</label>
				<input type="text" name="age" /> <input type="submit" value="Saada" />
			</form>
		</c:otherwise>
	</c:choose>
</our:Template>



